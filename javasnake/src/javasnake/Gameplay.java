package javasnake;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements Runnable, KeyListener{

	//setting up screen width/height
	public static final int WIDTH = 750, HEIGHT = 750;
	
	private static final long serialVersionUID = 1L;
	
	private Thread thread;
	
	private boolean running;
	
	private boolean right = true, left = false, up = false, down = false;
	
	//snake body
	private Snake b;
	private ArrayList<Snake> snake;
	
	//fruit spawns
	private Fruit fruit;
	private ArrayList<Fruit> fruits;
	
	int intScore = 0;
	
	private Random r;
	
	//snake location
	private int xCoor = 10, yCoor = 10, size = 3;
	private int ticks = 0;
	

	
	//setting up arrays and window..
	public Gameplay() {
		setFocusable(true);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);

		snake = new ArrayList<Snake>();
		fruits = new ArrayList<Fruit>();
		
		r = new Random();
		
		startgame();
		
		
		
	}
	
	//start up
	public void startgame() {
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	//stops game
	public void stopgame() {
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e){
			e.printStackTrace();
			
		}
		
	}
	//snake movement/growth
	public void tick() {
		if(snake.size() == 0) {
			b = new Snake(xCoor, yCoor, 10);
			snake.add(b);
		}
		ticks++;
		if(ticks > 250000) {
			if(right) xCoor++;
			if(left) xCoor--;
			if(up) yCoor--;
			if(down) yCoor++;
			
			ticks = 0;
			
			b = new Snake(xCoor, yCoor, 10);
			
			snake.add(b);
			
			if(snake.size() > size) {
				snake.remove(0);
				
			}
		}
		//spawning fruits and adding to the high score
		if(fruits.size() == 0) {
			int xCoor = r.nextInt(74);
			int yCoor = r.nextInt(74);
			
			fruit = new Fruit(xCoor, yCoor, 10);
			fruits.add(fruit);
			intScore += 10;
		}
		
		//eating fruit
		for(int i = 0; i < fruits.size(); i++) {
			if(xCoor == fruits.get(i).getxCoor() && yCoor == fruits.get(i).getyCoor()) {
				size++;
				fruits.remove(i);
				i++;
			}
		}
		//collision on self..
		for(int i = 0; i < snake.size(); i++) {
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
				if(i != snake.size() - 1) {
					JOptionPane.showMessageDialog(null, "Game Over!(SELF)");
					stopgame();
				}
			}
		}
		//collision on the border..
		if(xCoor < 0 || xCoor > 74 || yCoor < 0 || yCoor > 74) {
			JOptionPane.showMessageDialog(null, "Game Over!(WALL)");
			stopgame();
			
		}

	}
	//setting up window
	public void paint(Graphics g) {
		
		
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.BLACK);
		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for(int i = 0; i < WIDTH/10; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		for(int i = 0; i < HEIGHT/10; i++) {
			g.drawLine(0, i * 10, HEIGHT, i * 10);
		}
		for(int i = 0; i < snake.size(); i ++) {
			snake.get(i).draw(g);
		}
		
		for(int i = 0; i < fruits.size(); i++) {
			fruits.get(i).draw(g);
			
		}
		
		//adding high score
		g.drawString("Score: " + intScore, 10, 10);
		
		
	}
	//updating window
	@Override
	public void run() {
		while(running) {
			tick();
			repaint();
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	//setting up keys to be able recognize where to go when pressed
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT && !left) {
			right = true;
			up = false;
			down = false;
		}
		if(key == KeyEvent.VK_LEFT && !right) {
			left = true;
			up = false;
			down = false;
		}
		if(key == KeyEvent.VK_UP && !down) {
			up = true;
			left = false;
			right = false;
		}
		if(key == KeyEvent.VK_DOWN && !up) {
			down = true;
			right = false;
			left = false;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
