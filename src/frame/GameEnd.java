/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameEnd extends JPanel {

    GameAliens aa = new GameAliens();
    Image end;
   
    public GameEnd(){
        end = new ImageIcon("image\\lose.jpg").getImage();
       
        setLayout(null);
        setSize(Frame.frame.getWidth(), Frame.frame.getHeight());
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                Frame.frame.remove(Frame.frame.end);
                
                System.exit(0);

            }
        });
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
        g.drawImage(end, 0, 0, 1350, 700, this);
        g.setFont(new Font(" ",Font.BOLD,40));
        g.drawString("YOUR SCORE : "+GameAliens.score, Frame.frame.getWidth()/2-180, Frame.frame.getHeight()/2-300);

    
        
    }


}

