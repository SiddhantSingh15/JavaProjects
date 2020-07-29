package com.company;

import java.awt.*;
import java.util.Random;


public class Ball {

    public int x, y, width = 25, height = 25;
    public int motionX, motionY;
    public Random random;
    private final Pong pong;
    public int amountHits;

    public Ball(Pong pong) {
        this.pong = pong;
        this.random = new Random();
        spawn();
    }

    public void update(Paddle paddle1, Paddle paddle2){
        int speed = 5;

        this.x += motionX * speed;
        this.y += motionY * speed;

        if (this.y + height > pong.height || this.y < 0) {
            if(this.motionY < 0){
                this.y = 0;
                this.motionY = 1 + (amountHits / 5);
                if(motionY == 0){
                    motionY = 1;
                }
            }
            else{
                this.motionY = -random.nextInt(4);
                this.y = pong.height - height;
                if(motionY == 0){
                    motionY = -1;
                }
            }
        }

        if(checkCollision(paddle1) == 1){
            this.motionX = 1 + (amountHits / 5);
            this.motionY = -2 + random.nextInt(4);
            if(motionY == 0){
                motionY = 1;
            }
            amountHits++;
        }
        else if(checkCollision(paddle2) == 1){
            this.motionX = -1 - (amountHits / 5);
            this.motionY = -2 + random.nextInt(4);
            if(motionY == 0){
                motionY = 1;
            }
            amountHits++;
        }
        if(checkCollision(paddle1) == 2){
            paddle2.score++;
            spawn();
        }
        if(checkCollision(paddle2) == 2){
            paddle1.score++;
            spawn();
        }
    }

    public void spawn(){
        this.amountHits = 0;
        this.x = pong.width / 2 - this.width / 2;
        this.y = pong.height / 2 - this.height /2;

        this.motionY = -2 + random.nextInt(4);
        if(motionY == 0){
            motionY = 1;
        }
        if(random.nextBoolean()){
            motionX = 1;
        } else{
            motionX = -1;
        }
    }

    public int checkCollision(Paddle paddle) {

        if (this.x < paddle.x + paddle.width && this.x + this.width > paddle.x && this.y < paddle.y + paddle.height && this.y + this.height > paddle.y) {
            return 1; // bouncing
        } else if ((paddle.x > x && paddle.paddleNum == 1) || (paddle.x < x - width && paddle.paddleNum == 2)) {
            return 2; // scoring
        }
        return 0;
    }


    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
}
