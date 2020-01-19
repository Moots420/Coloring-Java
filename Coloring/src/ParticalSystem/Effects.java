package ParticalSystem;

import java.awt.Graphics;

import Main.Handler;

public abstract class Effects {
	private Handler handler;
	private int x,y;
	
	public boolean isActive;
	public Effects(Handler handler, int x, int y,int maxParticals, int speed) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		isActive = true;
		
	}
	
public abstract void tick();
public abstract void render(Graphics g);



}