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

public class Laser extends Charector{
    int posx,posy;
    static Image imgL = new ImageIcon("RllaerBullet.png").getImage();
    static Image imgR = new ImageIcon("LllaerBullet.png").getImage();

    Laser laser;
    public Laser(Spaceman player) {

        //posi laser
        laser=this;
        x = player.getX()+1;
        y = player.getY()+40;
        width=24;
        height=12;

        if(player.isLeft){
            posx=-20;
            img=imgL;
        }else  {

            posx=+20;
            img=imgR;
        }

        t = new Timer(30, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                x+=posx;
                y+=posy;

                    //check aliens&&laser+score
                for(int i=0;i<Frame.frame.game.aliens.size();i++){
                    if(Frame.frame.game.aliens.get(i).getBounds().intersects(getBounds())){
                        Frame.frame.game.aliens.get(i).die();
                        Frame.frame.game.laser.remove(laser);
                        GameAliens.score+=100;
                        t.stop();
                        break;
                    }
                }
            }
        });
        t.start();
    }
    public Laser() {
        Spaceman s = new Spaceman();
        new Laser(s);
    }
}