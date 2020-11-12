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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Spaceman extends Charector{
    Spaceman player;
    Image left,right;
    int sx,sy;
    boolean isLeft;
    private JPanel panel;
    public Spaceman() {
        player = this;
        x=530;
        y=300;
        sx=0;
        sy=0;
        width=150;
        height=150;
        img = left = new ImageIcon("image\\ufo0.png").getImage();
        right = new ImageIcon("image\\ufo0.png").getImage();
        isLeft=true;
     
         
        t = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(x+sx>=0&&x+width+sx<=Frame.frame.getWidth()){
                    x+=sx;
                }
                if(y>470)
                    y=470;
                if(y<100)
                    y=100;
                
                y+=sy;
            }
        });
        t.start();
    }
    //check move
    void moveLeft(){
        sx=-50;
        img=left;
        isLeft=true;
    }
      void moveUp(){
        sy=-50;
     
    }
        void moveDown(){
        sy=50;
      
      
    }
    void moveRight(){
        sx=50;
        img=right;
        isLeft=false;
    }
    
    void moveStop(){
        sx=0;
        sy=0;
    }

}

