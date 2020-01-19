package Main;
import java.util.Random;

import ParticalSystem.particalSystem;

public class Handler {
private keyManager keyMngr;
private Engine engine;
private mainGame Game;
private Display disp;
private MouseHandler mouseMngr;
private particalSystem ParticalSystem;


public particalSystem getParticalSystem() {
	return ParticalSystem;
}

public void setParticalSystem(particalSystem particalSystem) {
	ParticalSystem = particalSystem;
}

public Handler() {
	
}

public MouseHandler getMouseMngr() {
	return mouseMngr;
}

public void setMouseMngr(MouseHandler mouseMngr) {
	this.mouseMngr = mouseMngr;
}

public int getRandomDirection() {
	 int rand = getRandomNumber(0,100);
	 if(rand<50) {
		 return -1;
	 }else {
		 return 1;
	 }
	 
	
}
public int getRandomNumber(int min, int max) {
	if (min >= max) {
		throw new IllegalArgumentException("max must be greater than min");
	}

	Random r = new Random();
	return r.nextInt(max-min + 1) + min;
	
	
}

//Getters and Setters
public Display getDisp() {
	return disp;
}
public void setDisp(Display disp) {
	this.disp = disp;
}
public Engine getEngine() {
	return engine;
}
public void setEngine(Engine engine) {
	this.engine = engine;
}

public mainGame getGame() {
	return Game;
}
public void setGame(mainGame game) {
	Game = game;
}
public keyManager getKeyMngr() {
	return keyMngr;
}
public void setKeyMngr(keyManager keyMngr) {
	this.keyMngr = keyMngr;
}

}
