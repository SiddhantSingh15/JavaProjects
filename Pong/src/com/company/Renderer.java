package com.company;
import java.awt.*;
import javax.swing.JPanel;


public class Renderer extends JPanel{

    private static final long serialVersionUID = 1L;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Pong.pong.render((Graphics2D) g);
    }
}
