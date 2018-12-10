package game;


import java.awt.Canvas;
import sun.audio.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;


public class MyCanvas extends Canvas implements KeyListener{

	Goodguy deadpool = new Goodguy(20,20,60,60,"files/deadpool_emblem.png");
	LinkedList badguys = new LinkedList();
	
	LinkedList knives = new LinkedList();
	
	public MyCanvas() {

		this.setSize(600,400);

		this.addKeyListener(this);

		playIt("files/dustin.wav");
		
		
		Random rand = new Random();  
		int winwidth = this.getWidth(); 
		int winheight = this.getHeight();
		for(int i = 0; i<10; i++)  {
			Badguy bg = new Badguy(rand.nextInt(winwidth), rand.nextInt(winheight),50,50,"files/Stickman.jpg");
			Rectangle r = new Rectangle(100,100,30,30);
			if (r.contains(deadpool.getxCoord(), deadpool.getyCoord())) {
				System.out.println("badguy on top of deadpool");
				continue;
			}
			badguys.add(bg); 
		}
	}
		

	public void paint(Graphics g) {

		g.drawImage(deadpool.getImg(), deadpool.getxCoord(), deadpool.getyCoord(), deadpool.getHeight(), deadpool .getWidth(), this);

		for(int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i); 
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
	    }
		
	}


	public void keyPressed1(KeyEvent e) {
		System.out.println(e);
		deadpool.moveIt(e.getKeyCode());
		
		if (e.getKeyCode()==70) {
				Knives knife= new Knives(deadpool.getxCoord(),deadpool.getyCoord(),30,30,"images/knife.jpg");
				knives.add(knives);
		}
	
		deadpool.moveIt(e.getKeyCode());
		Rectangle ggrect = new Rectangle(deadpool.getxCoord(),deadpool.getyCoord(), deadpool.getWidth(), deadpool.getHeight());
		for(int i=0; i< badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			Rectangle r = new Rectangle (bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
			if (r.intersects(ggrect)) {
				System.out.println("badguy hit by deadpool");
				badguys.remove(bg);
			}
		}
		
		
		
		
		
		
		
		
	for(int i = 0; i < badguys.size(); i++) {
		Badguy bg = (Badguy) badguys.get(i); 
		Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
		if (r.contains(deadpool.getxCoord(),deadpool.getyCoord())) {
			System.out.println("badguy hit by deadpool");
			badguys.remove(i);
		}
	}
}	
	
	
	
	
	
	
	@Override

	public void keyTyped(KeyEvent e) {

	}

	@Override

	public void keyPressed(KeyEvent k) {

		deadpool.moveIt(k.getKeyCode());
		repaint();

	}

	@Override

	public void keyReleased(KeyEvent e) {

	}

	public void playIt(String filename) {

		try {

			InputStream in = new FileInputStream(filename);

			AudioStream as = new AudioStream(in);

			AudioPlayer.player.start(as);

			

		} catch (IOException e) {

			System.out.println(e);

		}

	}

}

	


