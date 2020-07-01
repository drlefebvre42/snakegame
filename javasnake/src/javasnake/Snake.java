package javasnake;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	
	private int xCoor, yCoor, width, height;
	
	//constructor
	public Snake(int xCoor, int yCoor, int tileSize){
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
		
	}
	
	//draw snake
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(xCoor * width, yCoor * height, width, height);
		
	}
	
	//getters/setters
	public int getxCoor() {
		return xCoor;
	}
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}
	public int getyCoor() {
		return yCoor;
	}
	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	public void tick() {
		
	}


}
