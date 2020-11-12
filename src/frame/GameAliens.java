/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.*;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameAliens extends JPanel implements KeyListener {


    Image bgg, bgg2, bgg3, ht, win;
    Spaceman player;
    Timer t1, t2;
    ArrayList<Laser> laser;
    ArrayList<Aliens> aliens, bos;
    Heart heart;
    static int x = 10;
    static int score = 0;
    static int checkover = 0;
    static int checkwin = 0;

    public GameAliens() {

        bgg = new ImageIcon("image\\bg1.jpg").getImage();
        bgg2 = new ImageIcon("image\\bg2.jpg").getImage();
        bgg3 = new ImageIcon("image\\bg3.jpg").getImage();

        ht = new ImageIcon("image\\Heart.png").getImage();

        setLayout(null);
        setSize(Frame.frame.getWidth(), Frame.frame.getHeight());
        t1 = new Timer(33, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.frame.game.repaint();
            }
        });
        t2 = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                aliens.add(new Aliens());
            }
        });
        
         
        t1.start();
        t2.start();
        addKeyListener(this);
        player = new Spaceman();
        laser = new ArrayList<Laser>();
        aliens = new ArrayList<Aliens>();

        heart = new Heart();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (score < 1000) {

            g.drawImage(bgg, 0, 0, 1349, 700, this);
        } else if (score >= 1000 && score < 3000) {
            g.drawImage(bgg2, 0, 0, 1349, 700, this);

        } else if (score >= 3000) {

            g.drawImage(bgg3, 0, 0, 1349, 700, this);
        }

        g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
        for (int i = 0; i < laser.size(); i++) {
            g.drawImage(laser.get(i).getImage(), laser.get(i).getX(), laser.get(i).getY(), laser.get(i).getWidth(), laser.get(i).getHeight(), this);
        }
        for (int i = 0; i < aliens.size(); i++) {
            g.drawImage(aliens.get(i).getImage(), aliens.get(i).getX(), aliens.get(i).getY(), aliens.get(i).getWidth(), aliens.get(i).getHeight(), this);
        }

        //draw Score && pic heart
        g.drawImage(ht, 1250, 10, 30, 30, this);

        g.setFont(new Font(" ", Font.BOLD, 30));
        g.drawString(" " + x, 1200, 30);

        g.setFont(new Font(" ", Font.BOLD, 30));
        g.drawString("SCORE : " + score, 600, 30);

        if (x <= 0) {
            checkover = 1;
        }
        if(score == 4000){
            checkwin = 1;
        }
        repaint();
    }

    //push key
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            laser.add(new Laser(player));
        }
    }

    //unpush key
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.moveStop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    //loser

    public static boolean over() {
        if (checkover == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    // win
    public static boolean win() {
        if (checkwin == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        x = 10;
        score = 0;
        checkover = 0;

        laser.removeAll(laser);
        laser.removeAll(aliens);
    }

}

