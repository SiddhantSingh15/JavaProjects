package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Pong implements ActionListener, KeyListener {

    public static Pong pong;
    public int width = 700, height = 700;
    public Renderer renderer;
    public Paddle player1;
    public Paddle player2;
    public boolean bot = false, selectingDiff;
    public boolean w, s, up, down;
    public Ball ball;
    public int gameStatus = 0, scoreLimit = 1, playerWon ; // 0: Menu, 1: pause, 2: play, 3: over
    public int botDifficulty, botMoves, botCoolDown = 0;
    public Random random;



    public Pong(){
        Timer timer = new Timer(20, this);
        random = new Random();
        JFrame jFrame = new JFrame("Pong");
        renderer = new Renderer();

        jFrame.setSize(width + 15, height + 20);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(this.renderer);
        jFrame.addKeyListener(this);

        timer.start();
    }

    public void start(){
        gameStatus = 2;
        player1 = new Paddle(this, 1);
        player2 = new Paddle(this,2);
        ball = new Ball(this);
    }

    public void update() {
        if(player1.score >= scoreLimit){
            playerWon = 1;
            gameStatus = 3;
        }
        if(player2.score >= scoreLimit){
            playerWon = 2;
            gameStatus = 3;
        }
        if (w) {
            player1.move(true);
        }
        if (s) {
            player1.move(false);
        }
        if(!bot) {
            if (up) {
                player2.move(true);
            }
            if (down) {
                player2.move(false);
            }
        } else {
            if (botCoolDown > 0) {
                botCoolDown--;
                if(botCoolDown == 0){
                    botMoves = 0;
                }
            }
            if (botMoves < 10) {
                if (player2.y + player2.height / 2 < ball.y) {
                    player2.move(false);
                    botMoves++;
                }
                if (player2.y + player2.height / 2 > ball.y) {
                    player2.move(true);
                    botMoves++;
                }
                if (botDifficulty == 0) {
                    botCoolDown = 20;
                }
                if (botDifficulty == 1) {
                    botCoolDown = 15;
                }
                if (botDifficulty == 2) {
                    botCoolDown = 1;
                }
            }
        }
        ball.update(player1, player2);
    }


    public void render(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, width + 15, height);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(gameStatus == 0) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("PONG", width / 2 - 70, 50);

            if (!selectingDiff) {
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Press Space to Play", width / 2 - 150, height / 2 - 50);
                g.drawString("Press Shift to Play w Bot", width / 2 - 180, height / 2 - 100);
                g.drawString("~Score limit: " + scoreLimit + "~", width / 2 - 125, height / 2);
            }
        }

        if(selectingDiff){
            g.setFont(new Font("Arial", Font.BOLD, 30));
            String string = botDifficulty == 0 ? "Easy" : (botDifficulty == 1 ? "Medium" : "Hard");
            g.drawString("~Bot Difficulty: " + string + "~", width / 2 - 165, height / 2 - 50);
            g.drawString("Press Space to Play", width / 2 - 150, height / 2);
        }

        if(gameStatus == 1){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("PAUSED", width / 2 - 80, height / 2 - 100);
        }

        if(gameStatus == 1 || gameStatus == 2) {
            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
            g.drawLine(width / 2, 0, width / 2, height);

            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString(String.valueOf(player1.score), width / 2 - 90, 50);
            g.drawString(String.valueOf(player2.score), width / 2 + 65, 50);

            player1.render(g);
            player2.render(g);
            ball.render(g);
        }

        if(gameStatus == 3) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("PONG", width / 2 - 70, 50);
            if(bot && playerWon == 2){
                g.drawString("The Bot Wins!", width / 2 - 140, height / 2 - 150);
            } else{
                g.drawString("Player " + playerWon + " Wins!", width / 2 - 140, height / 2 - 150);
            }

            g.setFont(new Font("Arial", Font.BOLD, 25));
            g.drawString("Press Space to Play Again", width / 2 - 160, height / 2 - 100);
            g.drawString("Press Esc for Menu", width / 2 - 125, height / 2 - 50);
        }
    }

    public void actionPerformed(ActionEvent e){
        if(gameStatus == 2){
            update();
        }
        this.renderer.repaint();
    }

    public static void main(String[] args) {
        pong = new Pong();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();

        if (id == KeyEvent.VK_W) {
            w = true;
        } else if (id == KeyEvent.VK_S) {
            s = true;
        } else if (id == KeyEvent.VK_UP) {
            up = true;
        } else if (id == KeyEvent.VK_DOWN) {
            down = true;
        } else if (id == KeyEvent.VK_RIGHT) {
            if (selectingDiff) {
                if (botDifficulty < 2) {
                    botDifficulty++;
                } else {
                    botDifficulty = 0;
                }
            } else if (gameStatus == 0) {
                scoreLimit++;
            }
        } else if (id == KeyEvent.VK_LEFT) {
            if (selectingDiff) {
                if (botDifficulty > 0) {
                    botDifficulty--;
                } else {
                    botDifficulty = 2;
                }
            } else if (gameStatus == 0 && scoreLimit > 1) {
                scoreLimit--;
            }
        } else if (id == KeyEvent.VK_ESCAPE && (gameStatus == 2 || gameStatus == 3)) {
            gameStatus = 0;
        } else if (id == KeyEvent.VK_SHIFT && gameStatus == 0) {
            bot = true;
            selectingDiff = true;
        } else if (id == KeyEvent.VK_SPACE) {
            if (gameStatus != 0 && gameStatus != 3) {
                if (gameStatus == 1) {
                    gameStatus = 2;
                } else if (gameStatus == 2) {
                    gameStatus = 1;
                }
            }
            start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int id = e.getKeyCode();

        if(id == KeyEvent.VK_W){
            w = false;
        }
        else if (id == KeyEvent.VK_S){
            s = false;
        }
        else if (id == KeyEvent.VK_UP){
            up = false;
        }
        else if (id == KeyEvent.VK_DOWN){
            down = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
