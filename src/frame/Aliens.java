/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Aliens extends Charector {

    Image left, right, bos, win;
    int sx;
//    boolean isLeft;
//    boolean isRight;
//    boolean isufo;
    Aliens aliens;

    public Aliens() {
        aliens = this;

        x = (int) (Math.random() * 1);
        if (x == 0 || x == 1) {
            x = 1;
        } else {
            x = 1349;
        }

        y = (int) (Math.random() * 300);
        if (y < 250) {
            y += 210;
        } else {
            y += 140;
        }
        
      
        width = 70;
        height = 70;

        right = new ImageIcon("image\\monster.png").getImage();
        bos = new ImageIcon("image\\alien.png").getImage();

        if (x < Frame.frame.getWidth() / 2) {
            img = right;
            if (GameAliens.score <= 1000) {
                sx =  20;
            } else if (GameAliens.score >= 1000 && GameAliens.score < 3000) {
                sx =  80;

            } else if (GameAliens.score > 3000) {

                sx =  130;
            }

        }
        

        t = new Timer(350, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                x += sx;

                if (getBounds().intersects(Frame.frame.game.player.getBounds())) {
                    //System.out.print("5555");
                    GameAliens.x -= 1;

                }
            }
        });
        t.start();
    }

    //remove aliens
    void die() {
        Frame.frame.game.aliens.remove(this);
        t.stop();
    }

}
