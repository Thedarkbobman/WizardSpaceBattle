package com.ananth;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class keyControl extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private int width, height, leet;

	private boolean rockCheck,loseCheck;
	private boolean[] keys = new boolean[65536];
	private Players p,p2;
	private ArrayList<Shot> shots,shots2;
	private Shot shot;
	public keyControl(int w, int h, Players ps,Players ps2,ArrayList<Shot> x,ArrayList<Shot> y) {
		width = w;
		height = h;

		rockCheck=true;
		loseCheck = false;
		p = ps;
		p2 = ps2;
		shots = x;
		shots2 = y;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void tick() {
		if (keys[KeyEvent.VK_A]) {
			if(p.getX()>0)
			p.moveLeft();
		}

		if (keys[KeyEvent.VK_D]) {
			if(p.getX()<width-60)
			p.moveRight();
		}
if (keys[KeyEvent.VK_W]) {
		if(p.getY()>0)
			p.moveUp();
			
		}
if (keys[KeyEvent.VK_S]) {
	if(p.getY()<height-60)
	p.moveDown();
	
}
		if (keys[KeyEvent.VK_SHIFT]) {
			if(p.getX()<p2.getX()){
			shot = new Shot(p.getX()+60,p.getY()+30,false);
			}
			if(p.getX()>p2.getX()){
				shot = new Shot(p.getX(),p.getY()+30,true);
				}
			shots.add(shot);
			
			
		}
		if (keys[KeyEvent.VK_SPACE]) {
			if(p.getX()<p2.getX()){
			shot = new Shot(p2.getX(),p2.getY()+30,true);
			}
			if(p.getX()>p2.getX()){
				shot = new Shot(p2.getX()+60,p2.getY()+30,false);
				}
			shots2.add(shot);

			
		}
		if(keys[KeyEvent.VK_LEFT]){
			if(p2.getX()>0)
			p2.moveLeft();
		}
		if(keys[KeyEvent.VK_RIGHT]){
			if(p2.getX()<width-60)
			p2.moveRight();
		}
if(keys[KeyEvent.VK_UP]){
	if(p2.getY()>0)
			p2.moveUp();
		}
if(keys[KeyEvent.VK_DOWN]){
	if(p2.getY()<height-60)
	p2.moveDown();
}
if(keys[KeyEvent.VK_DELETE]){
	try {
		Thread.sleep(50);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	}
	
	public int xLoc() {
return 1;
	}

	public int yLoc() {
return 1;
	}




}
