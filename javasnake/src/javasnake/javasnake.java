package javasnake;
//Dawson Lefebvre Snake Game
//6/19/20

import javax.swing.JFrame;


public class javasnake {
	//game window creation
	public javasnake() {
		JFrame window = new JFrame();
		
		Gameplay gameplay = new Gameplay();
		
		window.add(gameplay);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setTitle("Snake Game");
		
		
		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
	}
	//main
	public static void main(String args[]) {
		new javasnake();
		

		
		
	
	
	}
}
