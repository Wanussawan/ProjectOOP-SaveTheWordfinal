/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import javax.swing.JFrame;
import java.awt.*;

public class Frame extends JFrame {

    static Frame frame;
    Play play;
    Howto howto;
    GameAliens game, aliens;
    GameEnd end;
    GameEnd2 win;
   

    public Frame() {
        frame = this;

    
        setResizable(false);
        setBounds(275, 120, 1349, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        play = new Play();
        add(play);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Frame();
    }

    
    
}

