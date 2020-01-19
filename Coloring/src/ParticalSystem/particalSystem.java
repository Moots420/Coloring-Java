package ParticalSystem;

import java.awt.Graphics;
import java.util.ArrayList;

import Main.Handler;

public class particalSystem {
	
	private ArrayList<Effects> effects = new ArrayList<Effects>();
	private Handler handler;
	
	public void paricalSystem(Handler handler) {
		this.handler = handler;
	}
	
	public void createEffect(Effects e) {
		effects.add(e);
	
	}
	
	public  void tick() {
	for (int i = 0; i < effects.size(); i++) {
		effects.get(i).tick();
		if(effects.get(i).isActive == false) {
			effects.remove(i);
		}
	}
		
		
	}
	public void render(Graphics g) {
		for (int i = 0; i < effects.size(); i++) {
			effects.get(i).render(g);
		}

		
	}

}
