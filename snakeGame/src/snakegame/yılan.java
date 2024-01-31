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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.*;

/**
 *
 * @author İrem Serra
 */
public class yılan extends JLabel {

    public kutu mHead = new kutu();

    public Timer mTimer = null;

    public Yem mYem = new Yem();

    public Random mRandom = new Random();

    public ArrayList<kutu> Liste = new ArrayList<kutu>();

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rect = new Rectangle2D.Double(5, 5, getWidth() - 10, getHeight() - 10);

        g2.setColor(Color.red);

        g2.setStroke(new BasicStroke(10));

        g2.draw(rect);
    }

    public yılan() {

        mRandom = new Random(System.currentTimeMillis());
        addKeyListener(new klavyeKontrol());
        setFocusable(true);

        mTimer = new Timer(100, new TimerKontrol());
        mTimer.start();

        Liste.add(mHead);

        for (int i = 1; i < 10; i++) {

            kuyrukEkle();
        }
        add(mHead);
        add(mYem);
    }

    public void kuyrukEkle() {

        kutu K = Liste.get(Liste.size() - 1).KutuOluştur();
        Liste.add(K);
        add(K);

    }

    public void YemEkle() {

        int Width = getWidth() - 30 - mYem.mgenişlik;
        int Height = getHeight() - 30 - mYem.mgenişlik;

        int PosX = 10 + Math.abs(mRandom.nextInt()) % Width;
        int PosY = 10 + Math.abs(mRandom.nextInt()) % Width;

        PosX = PosX - PosX % 20;
        PosY = PosY - PosY % 20;

        for (int i = 0; i < Liste.size(); i++) {
            if (PosX == Liste.get(i).getX() && (PosY == Liste.get(i).getY())) {
                YemEkle();
                return;
            }
        }

        mYem.setPosition(PosX, PosY);

    }

    public void hepsiniYurut() {

        for (int i = Liste.size() - 1; i > 0; i--) {
            kutu onceki = Liste.get(i - 1);
            kutu sonraki = Liste.get(i);

            Liste.get(i).Hareket();
            sonraki.mYon = onceki.mYon;
        }
        mHead.Hareket();

    }

    class klavyeKontrol implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (mHead.mYon != YON.SAG) {
                    mHead.mYon = YON.SOL;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (mHead.mYon != YON.SOL) {
                    mHead.mYon = YON.SAG;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (mHead.mYon != YON.YUKARI) {
                    mHead.mYon = YON.ASAGI;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (mHead.mYon != YON.ASAGI) {
                    mHead.mYon = YON.YUKARI;
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }

    class TimerKontrol implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            hepsiniYurut();
            if (carpısmaVarmı()) {
                mTimer.stop();
            }

        }

        public boolean carpısmaVarmı() {
            int kalem = 10;

            int genislik = getWidth();
            int yukseklik = getHeight();

            if (mHead.getX() <= 10) {
                return true;
            }

            if (mHead.getX() + mHead.mGenişlik >= genislik - kalem) {

                return true;
            }

            if (mHead.getY() <= 10) {
                return true;
            }

            if (mHead.getY() + mHead.mGenişlik >= yukseklik - kalem) {

                return true;
            }

            for (int i = 1; i < Liste.size(); i++) {

                int X = Liste.get(i).getX();
                int Y = Liste.get(i).getY();

                if ((X == mHead.getX()) && (Y == mHead.getY())) {
                    return true;
                }

            }

            if (mYem.getX() == mHead.getX() && (mYem.getY() == mHead.getY())) {

                kuyrukEkle();
                YemEkle();

            }

            return false;

        }

    }

}
