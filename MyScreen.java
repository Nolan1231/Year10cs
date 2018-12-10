package game;

import javax.swing.JFrame;
public class MyScreen extends JFrame {


/** 
 * MyScreen basic window for game, inherits properties and methods from JFrame 
 *@author nolan.murrell
 *@since sept. 27, 2018 
 */
	
	/**
	 * MyScreen default constructor 
	 * @param none, default constructor 
	 */
	public MyScreen() {
		//this is current instance, setters are mutator methods which change properties 
		this.setSize(600,400) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//main methos is required to run the program 
	public static void main(String[] args) {
		//instantiate an individual instance of MyScreen by calling on constructor 
		MyScreen screen = new MyScreen();
		MyCanvas canvas = new MyCanvas();
		screen.getContentPane().add(canvas);
	}

	
}