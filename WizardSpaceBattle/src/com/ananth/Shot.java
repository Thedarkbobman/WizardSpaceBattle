package com.ananth;

public class Shot {
	int xLoc,yLoc,move;
	boolean b;
	public Shot(int x,int y,boolean b2){
		xLoc = x;
		yLoc = y;
		b=b2;
		move = 10;
	}
	public void move(){
		if(b){
			xLoc-=move;
		}
		else{
			xLoc+=move;
		}
		
	}
	public int getX(){
		return xLoc;
	}
	public int getY(){
		return yLoc;
	}
}
