package Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;

public class Bullet {
	private int x, y, mouseX,mouseY, gunX, gunY;
	private float vel;
	private double angle, radAngle;
	private Handler handler;
	private int timer,maxTime;
	public boolean active;
	public Rectangle bounds;
	
	public Bullet(int x, int y, Handler handler, float angle) {
		active = true;
		this.x = x;
		this.y = y;
		this.handler = handler;
		this.angle = angle;
		vel = 15;
    	//System.out.println(angle);
    	radAngle =  Math.toRadians(angle);
    	timer = 0;
    	maxTime = 60;
    	bounds = new Rectangle(x,y,10,10);
	    
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void tick() {
		Move(radAngle);
	    bounds.x = x;
	    
	    bounds.y = y;
		
	}
	public void Move(double a) {
		timer ++;
		if(timer>maxTime) {
			active = false;
		}

		this.x += vel * Math.cos(a);
		this.y += vel * Math.sin(a);

		
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(x, y, 3, 3);
		
	}
	

}
