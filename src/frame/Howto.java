/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Howto extends JPanel{
    Image hto;

    //JButton Howto back Play;
    JButton bb = new JButton(new ImageIcon("Bback.png"));
    
    
    public Howto() {

        hto = new ImageIcon("image\\howtoo.jpg").getImage();
        setLayout(null);
        setSize(Frame.frame.getWidth(), Frame.frame.getHeight());
        
        
        bb.setBounds(1050, 580, 250, 60);
        add(bb);
        
        
        //push bb //back
        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.frame.remove(Frame.frame.howto);
                if(Frame.frame.play==null){
                    Frame.frame.play=new Play();
                }
                Frame.frame.add(Frame.frame.play);
                Frame.frame.play.requestFocusInWindow();
                Frame.frame.repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(hto, 0, 0, 1349, 700,this);

    }
}

