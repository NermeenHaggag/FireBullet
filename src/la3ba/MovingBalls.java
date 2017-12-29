/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la3ba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 *
 * @author nerme
 */
public class MovingBalls extends JPanel implements Runnable 
{
    public ArrayList<Ball>Balls=new ArrayList<Ball>(5);
   public Tank BlueTank=new Tank("C:\\Users\\nerme\\Desktop\\TankBlueS.jpg");
   public Tank BlueTank1=new Tank("C:\\Users\\nerme\\Desktop\\TankBlueS1.jpg");
   
    public MovingBalls()
    {
        setSize(1500,1000);
        setBackground(Color.BLACK);
        BlueTank.pos.x=900;
        BlueTank.pos.y=720;
        BlueTank1.pos.x=400;
        BlueTank1.pos.y=720;
        this.addKeyListener(new keylist());
        this.addKeyListener(new keylist1());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                //BlueTank1.mover();
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
               // BlueTank1.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
                //BlueTank1.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    private class keylist1 implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent n) {
           
        }

       
        @Override
        public void keyPressed(KeyEvent n) {
            //System.out.println("Test");
            if (n.getKeyCode()==KeyEvent.VK_D)
            {
                
                BlueTank1.mover();
                //BlueTank1.mover();
            }
            if (n.getKeyCode()==KeyEvent.VK_A)
            {
                
                BlueTank1.movel();
               // BlueTank1.movel();
                //repaint();
            }
            if (n.getKeyCode()==KeyEvent.VK_X)
            {
                
                BlueTank1.fireBullet();
                //BlueTank1.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent n) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 1500, 1000);
        
        try
        {
       BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgtank1 = ImageIO.read(new File(BlueTank1.ImagePath));
     
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        BufferedImage imgrocket1 = ImageIO.read(new File(BlueTank.Rocket1.imgPath));
        
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgtank1, BlueTank1.pos.x, BlueTank1.pos.y,null);
        
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        g.drawImage(imgrocket1, BlueTank1.Rocket1.pos.x, BlueTank1.Rocket1.pos.y,null);
        
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
                break;
                
            }
            if (BlueTank1.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
                break;
                
            }
            
            
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
