/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la3ba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
/**
 *
 * @author nerme
 */
public class La3ba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        JFrame jf=new JFrame();
        jf.setSize(1500, 1000);
        
        MovingBalls mb=new MovingBalls();
        mb.Balls.add(new Ball());
        mb.Balls.add(new Ball(100,100,80,Color.orange));
        mb.Balls.add(new Ball(160,160,65,Color.red));
        mb.Balls.add(new Ball(180,180,80,Color.CYAN));
        mb.Balls.add(new Ball(100,100,80,Color.darkGray));
        mb.Balls.add(new Ball(100,100,70,Color.black));
        mb.Balls.add(new Ball(100,100,100,Color.gray));
        mb.Balls.add(new Ball(100,100,80,Color.magenta));
        mb.Balls.add(new Ball(100,100,60,Color.pink));
        mb.Balls.add(new Ball(100,100,60,Color.green));
        
        
        
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        Thread t2=new Thread(mb);
        t2.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }
    
}
