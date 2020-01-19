package ParticalSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Main.Handler;

public class Effect2 extends Effects {
private int x,y,maxParticals,speed,alpha;
private Color c;
private Handler handler;
private ArrayList<Partical> particals = new ArrayList<Partical>();
	public Effect2(Handler handler, int x, int y, int maxParticals, int speed) {
		super(handler, x, y, maxParticals, speed);
	 this.maxParticals = maxParticals;
	 this.x = x;
	 this.y = y;
	 this.speed = speed;
	 this.handler = handler;
	 alpha = 255;
	 
	addParticals();
	}

	public void addParticals() {
		for(int i = 0; i < maxParticals; i++) {
			int r = handler.getRandomNumber(0, 255);
		    int g = handler.getRandomNumber(0, 255);
		    int b = handler.getRandomNumber(0, 255);
			particals.add(new Partical(handler.getRandomDirection(),handler.getRandomDirection(),x,y,handler.getRandomNumber(0, 360),handler.getRandomNumber(1, speed),r,g,b));
		   
		}
		
		
	}
	public void tick() {
		
		for (int i =0; i<particals.size(); i++) {
		    particals.get(i).x += particals.get(i).speed*Math.cos(Math.toRadians(particals.get(i).rotation));
			particals.get(i).y += particals.get(i).speed*Math.sin(Math.toRadians(particals.get(i).rotation));
		    particals.get(i).tick();
		    if(particals.get(i).isActive == false) {
		    	particals.remove(i);
		    }
		}
		
		
	}

	@Override
	public void render(Graphics g) {
	for (int i =0; i<particals.size(); i++) {
		 
		    	particals.get(i).render(g);
		  
			
			
		}
		
	}

}
