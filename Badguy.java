package game;

import java.awt.Image;
import java.awt.Toolkit;

public class Badguy {


	private int xCoord;
	private int yCoord;
	private int width;
	private int height;
	private Image img;
	
	/**
	 * Goodguy default constructor 
	 */
	public Badguy() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("files/Stickman.jpg");
	}
	

	public Badguy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h); 
		setImg(imgpath);	
	}
	
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}
	public void moveIt(int direction) {

		int speed = 20;

		int x = getxCoord();

		int y = getyCoord();

		

		if (direction == 39){

			x = x + speed;

			setxCoord(x);

			setImg("files/Stickman.jpg");

		} else if (direction == 37) {

			x = x - speed;

			setxCoord(x);

			setImg("files/Stickman.jpg");

		}else if (direction == 38) {

			y = y - speed;

			setyCoord(y);

		}else if (direction == 40) {

			y = y + speed;

			setyCoord(y);

		}	
}
}



