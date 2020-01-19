package ParticalSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Main.Handler;

public class testEffect extends Effects {

	private int x,y;
	private int maxParticals,minParticals,speed;
	private ArrayList<Partical> particals = new ArrayList<Partical>();
	
	
	public testEffect(Handler handler, int x, int y,int maxParticals, int speed) {
		super(handler, x, y, maxParticals,  speed);
		
		this.x = x;
		this.y = y;
		this.maxParticals = maxParticals;
		this.speed = speed;
		for(int i = 0; i < maxParticals; i++) {
			particals.add(new Partical(handler.getRandomDirection(),handler.getRandomDirection(),x+handler.getRandomNumber(1,20)*handler.getRandomDirection(),y+handler.getRandomNumber(1, 20)*handler.getRandomDirection(),0,speed,255,0,0));
	
		}
		
	}

	@Override
	public void tick() {
	for (int i = 0; i<particals.size(); i++) {
		
			particals.get(i).x += particals.get(i).xDir*speed;
			particals.get(i).y += particals.get(i).yDir*speed;
			particals.get(i).tick();
		}
	
	

	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i<particals.size(); i++) {
		 particals.get(i).render(g);
			
		}
	
	
		
	}




}
