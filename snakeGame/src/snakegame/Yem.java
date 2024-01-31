/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javafx.scene.shape.Ellipse;
import javax.swing.JLabel;

/**
 *
 * @author İrem Serra
 */
public class Yem extends JLabel {
    
    public int mgenişlik = 20;
    
    
     Yem() {
         setPosition(20, 20);
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        Ellipse2D elipse = new Ellipse2D.Double(1, 1, mgenişlik-2, mgenişlik-2  );

        g2.setColor(Color.black);

        g2.setStroke(new BasicStroke(2));

        g2.draw(elipse);

        g2.setColor(Color.red);

        g2.fill(elipse);
    }
    
 
    
    public void setPosition (int PosX, int PosY){
    
        setBounds(PosX, PosY, mgenişlik, mgenişlik);
    }
}
