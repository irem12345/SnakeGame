/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;

/**
 *
 * @author İrem Serra
 */
public class kutu extends JLabel {

    @Override
    public boolean action(Event evt, Object what) {
        return super.action(evt, what); //To change body of generated methods, choose Tools | Templates.
    }
    public int mGenişlik = 20;

    public int mYon = YON.SAG;

    kutu() {

        setBounds(100, 100, mGenişlik, mGenişlik);
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rect = new Rectangle2D.Double(1, 1, getWidth() - 2, getHeight() - 2);

        g2.setColor(Color.black);

        g2.setStroke(new BasicStroke(2));

        g2.draw(rect);

        g2.setColor(Color.red);

        g2.fill(rect);
    }

    public void solaGit() {

        int PosX = getX();
        int PosY = getY();
        PosX -= mGenişlik;
        setBounds(PosX, PosY, mGenişlik, mGenişlik);

    }

    public void sagaGit() {
        int PosX = getX();
        int PosY = getY();
        PosX += mGenişlik;
        setBounds(PosX, PosY, mGenişlik, mGenişlik);

    }

    public void yukarıGit() {
        int PosX = getX();
        int PosY = getY();
        PosY -= mGenişlik;
        setBounds(PosX, PosY, mGenişlik, mGenişlik);

    }

    public void asagiGit() {

        int PosX = getX();
        int PosY = getY();
        PosY += mGenişlik;
        setBounds(PosX, PosY, mGenişlik, mGenişlik);

    }

    public void Hareket() {

        if(mYon == YON.SOL)
            solaGit();
        else if(mYon == YON.SAG)
            sagaGit();
        else if(mYon == YON.ASAGI)
            asagiGit();
        else 
           yukarıGit();
        
        
    }
    
    
    
    public kutu KutuOluştur(){
       
    kutu K = new kutu();
    
    int X = getX();
    int Y = getY();
    
    K.setBounds(X, Y, mGenişlik, mGenişlik);
    
    K.mYon = -mYon;
    
    K.Hareket();
    
    K.mYon = mYon;
    
     return K;
    
    }
    

}
