/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.Timer;

public abstract class Charector {

    int x, y, width, height, width2, height2;
    Image img;
    Timer t;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    int getWidth2() {
        return width2;
    }

    int getHeight2() {
        return height2;
    }

    Image getImage() {
        return img;
    }

    Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    Rectangle getBounds2() {
        return new Rectangle(width2, height2);
    }
}
