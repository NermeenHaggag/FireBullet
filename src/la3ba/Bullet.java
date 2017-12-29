/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la3ba;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nerme
 */
public class Bullet implements Runnable
{
    public Point pos=new Point();
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
  
    
    public Bullet()
    {
        Speed=1;
    }
    public  void  move()
    {
        pos.y-=Speed;
    }

    @Override
    public void run() {
        for (int i=0;i<400;i++)
        {
            //System.out.println("Rocket Moving " +pos.y);
            move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }
            
        }
    }
}
