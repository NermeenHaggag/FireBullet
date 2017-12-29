/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la3ba;

import java.awt.Point;
/**
 *
 * @author nerme
 */
public class Tank 
{
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public Bullet Rocket1=new Bullet();
    public int speed;
    public Tank (String ImagePath)
    {
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="C:\\Users\\nerme\\Desktop\\rocket.gif";
        speed=5;
        this.ImagePath=ImagePath;
        Rocket1.imgPath="C:\\Users\\nerme\\Desktop\\rocket.gif";
        
    }
   

    
    void mover() {
        this.pos.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
    }

    public void fireBullet()
    {
        Rocket.pos.x=this.pos.x+60;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
        Rocket1.pos.x=this.pos.x+60;
        Rocket1.pos.y=this.pos.y;
        Thread t2=new Thread (Rocket1);
        t2.start();
        
    }  
}
