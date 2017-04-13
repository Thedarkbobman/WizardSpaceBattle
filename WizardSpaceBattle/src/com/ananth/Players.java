package com.ananth;

public class Players {
int x,y,move;
public Players(int ox,int oy){
	x=ox;
	y=oy;
	move = 10;
}
public void moveLeft(){
	x-=move;
}
public void moveUp(){
	y-=move;
}
public void moveRight(){
	x+=move;
}
public void moveDown(){
	y+=move;
}
public void setX(int x2){
	x= x2;
}
public void setY(int y2){
	y=y2;
}

public int getX(){
	return x;
}
public int getY(){
	return y;
}


}
