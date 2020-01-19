package ParticalSystem;

import java.awt.Color;
import java.awt.Graphics;

public class Partical {
	public int xDir,yDir, x, y,rotation,speed,alpha,red,green,blue;
	public Color color;
	public boolean isActive;

	public Partical(int xDir, int yDir, int x, int y,int rotation, int speed, int red, int green, int blue) {
		this.xDir = xDir;
		this.yDir = yDir;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.speed = speed;
		this.alpha = 255;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.color = new Color(red,green,blue,alpha);
		isActive = true;
	}
	public void tick() {
		color = new Color(red,green,blue,alpha);
		alpha -= 10;
		if(alpha<5) {
			isActive = false;
		}
		
	}
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 5, 5);
		
	}

}
