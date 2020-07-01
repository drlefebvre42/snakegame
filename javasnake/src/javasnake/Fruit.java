package javasnake;

import java.awt.Color;
import java.awt.Graphics;

public class Fruit {
	
	private int xCoor, yCoor, width, height;
	
	//constructor
	public Fruit(int xCoor, int yCoor, int tileSize){
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.width = tileSize;
		this.height = tileSize;
		
	}
	
	//spawning the fruit
	public void draw(Graphics g) {
		g.setColor(Color.RED);
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
}