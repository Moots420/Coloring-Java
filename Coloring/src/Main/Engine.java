package Main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ParticalSystem.particalSystem;



public class Engine implements Runnable{
private MouseHandler mouseMngr;
private int width, height; // resoloution
private int Fps;
private String title;
private BufferStrategy bs;
private Graphics g;
private Display disp;
private boolean running = false;
private Thread thread;
private mainGame game;
private keyManager KeyManager;
private Handler handler;
private particalSystem ParticalSystem;
private Color backgroundColor;
	
	public Engine(String title, int resX, int resY ) {
		System.setProperty("sun.java2d.opengl", "true"); //set to opengl
		Fps = 0;
        backgroundColor = Color.WHITE;
		this.width = resX;
		this.height = resY;
		this.title = title;
		handler = new Handler();
		KeyManager = new keyManager();
		mouseMngr = new MouseHandler();
		ParticalSystem = new particalSystem();
		game = new mainGame(KeyManager, handler);
		handler.setKeyMngr(KeyManager);
		handler.setMouseMngr(mouseMngr);
		handler.setEngine(this);
		handler.setGame(game);
		handler.setParticalSystem(ParticalSystem);

		
	}
	

	private void tick() {
		game.tick();
		KeyManager.tick();
		ParticalSystem.tick();
	
	}
	private void render() {
		
		bs = disp.getCanvas().getBufferStrategy();
		if(bs == null) {
			disp.getCanvas().createBufferStrategy(3);
		return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0,0,width,height);
		//draw here
		g.setColor(backgroundColor);
		g.fillRect(0, 0, width, height);
		game.render(g);
	
		
		
		//end draw
		
		bs.show();
		g.dispose();
	}
	
	private void init() {
		disp = new Display(title, width, height,handler); 
		handler.setDisp(disp);
		disp.getFrame().addKeyListener(KeyManager);
		
		
		
	}
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/ fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta>=1) {
		tick();
		render();
		ticks++; 
		delta--;
			}
			if(timer>= 1000000000) {
				//System.out.println("ticks and frames:" + ticks);
				Fps = ticks;
				ticks = 0;
				timer = 0;
			}
			
		}
		stop();
		
	}
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		
		thread.start();
	}
public synchronized void stop() {
	if(!running)
		return;
	running = false;
	try {
	
		thread.join();
		
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
}

}
