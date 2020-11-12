/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

class Play extends JPanel{
    private Timer timer = new Timer( 10, new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(GameAliens.over()){
                gameover();
            }
        }
    });

    JButton str = new JButton(new ImageIcon("Stargame.gif"));
    JButton howto = new JButton(new ImageIcon("Howtoplay.gif"));

    Image bgg;


    public Play(){
        bgg = new ImageIcon("image\\bgstart1.jpg").getImage();
        setLayout(null);
        setSize(Frame.frame.getWidth(),Frame.frame.getHeight());

        //set size buttton
        str.setBounds(520,300, 300, 60);
        howto.setBounds(520, 400, 300, 60);
        add(str);
        add(howto);
        
       //push button start game
        str.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();

                Frame.frame.remove(Frame.frame.play);
                if(Frame.frame.game==null){
                    Frame.frame.game=new GameAliens();
                }
                Frame.frame.add(Frame.frame.game);
                Frame.frame.game.requestFocusInWindow();
                Frame.frame.repaint();
            }
        });

        //push button howto
        howto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                Frame.frame.remove(Frame.frame.play);
                if(Frame.frame.howto==null){
                    Frame.frame.howto=new Howto();
                }
                Frame.frame.add(Frame.frame.howto);
                Frame.frame.repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgg, 0, 0, 1349, 700,this);


    }
    //send constc GemeEnd
    public void gameover (){
        Frame.frame.remove(Frame.frame.game);
        if(Frame.frame.end==null){
            Frame.frame.end=new GameEnd();
        }
        timer.stop();
        Frame.frame.add(Frame.frame.end);
        Frame.frame.end.requestFocusInWindow();
        Frame.frame.repaint();
    }
    
    //send constc GemeEnd2
    public void gamewin (){
        
        Frame.frame.remove(Frame.frame.game);
        if(Frame.frame.win==null){
            Frame.frame.win=new GameEnd2();
        }
        timer.stop();
        Frame.frame.add(Frame.frame.win);
        Frame.frame.win.requestFocusInWindow();
        Frame.frame.repaint();
        
    }


}