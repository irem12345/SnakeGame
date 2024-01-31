/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author İrem Serra
 */
public class pencere extends JFrame{
    
    
    private int mGenişlik = 600;
    private int mYükseklik = 600;
    
    
    private static pencere mPencere = null;
    
    private pencere(){
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); //pencereyi kapatınca program durur
        setDimension(mGenişlik, mYükseklik);
        setResizable(false); //pencerenin boyutunu kullanıcı değiştiremez
        
        yılan Y = new yılan();
        add(Y);
    
    }
    
    public static pencere pencereGetir(){
    
        if(mPencere == null){
        mPencere = new pencere();
        }
    return new pencere();
    }
    
    
    public void setDimension(int Genişlik, int Yükseklik){
    Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    int PosX = 0;
    int PosY = 0;
    
    if(mGenişlik+100 > Dim.width){
    Genişlik= Dim.width-100;
    }
    
    if(mYükseklik+100 > Dim.height){
    mYükseklik= Dim.height-100;
    }
    
    PosX = (Dim.width-mGenişlik)/2;
    PosY = (Dim.height-mYükseklik)/2;
    
    
    setBounds(PosX, PosY, mGenişlik, mYükseklik);
    
    
    
    }
    
    
    
}
