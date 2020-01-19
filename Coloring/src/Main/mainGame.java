package Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import ParticalSystem.Effect2;
import ParticalSystem.Effects;
import ParticalSystem.particalSystem;
import ParticalSystem.testEffect;

public class mainGame {
	private keyManager keyM;
	private Handler handler;
	private Font font16;
	private int rectSize, tileW,tileH;
	private int[] tileX, tileY;
	private ArrayList<tile> _tiles = new ArrayList<>();
	private ArrayList<colorPicker> _pick = new ArrayList<>();
	private Color currentColor;
	private Text txt =  new Text();
public mainGame(keyManager KeyManager, Handler handler) {

	this.keyM = KeyManager;
	this.handler = handler;
    rectSize = 8;
	font16 = FontLoader.loadFont("pixel.ttf", 16);
	tileW = 600/rectSize;	
	tileH = 600/rectSize;		
	tileX = new int[tileW];
	tileY = new int[tileH];
	currentColor = Color.red;
	makeTiles();
	makePickers();
	
}
public void makePickers() {

	_pick.add(new colorPicker(700,50,Color.WHITE));
	_pick.add(new colorPicker(700,100,Color.black));
	_pick.add(new colorPicker(700,150,Color.red));
	_pick.add(new colorPicker(700,200,Color.green));
	_pick.add(new colorPicker(700,250,Color.blue));
	_pick.add(new colorPicker(700,300,Color.yellow));
	_pick.add(new colorPicker(700,350,Color.PINK));
	_pick.add(new colorPicker(700,400,Color.ORANGE));
	
}
public void makeTiles() {

		for(int y = 0; y < tileH; y++) {
			for(int k = 0; k < tileH; k++) {
			_tiles.add(new tile(y*rectSize,k*rectSize,Color.BLACK));
			
	}}
	
	
}

public void tick() {
   int mouseX =  MouseInfo.getPointerInfo().getLocation().x - handler.getDisp().getFrame().getX()-5;
   int mouseY =  MouseInfo.getPointerInfo().getLocation().y - handler.getDisp().getFrame().getY()-30;
   Rectangle r = new Rectangle(mouseX,mouseY,1,1);
	for (int i = 0; i < _tiles.size(); i ++) {
			if(handler.getMouseMngr().leftClick) {
				Rectangle b = new Rectangle(_tiles.get(i).x,_tiles.get(i).y,rectSize,rectSize);
				if(r.intersects(b)) {
					_tiles.get(i).c = currentColor;
					
				}

			}
			
			for (int j = 0; j < _pick.size(); j ++) {
				if(handler.getMouseMngr().leftClick) {
					Rectangle k = new Rectangle(_pick.get(j).x,_pick.get(j).y,25,25);
					if(r.intersects(k)) {
						currentColor = _pick.get(j).c;
						
					}

				}
				
			
	

			}}
	if(handler.getMouseMngr().leftClick) {
		Rectangle b = new Rectangle(650, 550, 100, 40);
		if(r.intersects(b)) {
			resetTiles();
			
			
		}
				
		
		
	}
	
	
}
public void resetTiles() {
	
	for (int i = 0 ; i<_tiles.size(); i++) {
		_tiles.get(i).c = Color.black;
		
		
	}
}

public void render(Graphics g) {
for (int i = 0; i < _tiles.size(); i ++) {

	g.setColor(_tiles.get(i).c);
	g.fillRect(_tiles.get(i).x, _tiles.get(i).y, rectSize, rectSize);
	
}
for(int j = 0; j<_pick.size(); j++) {
    g.setColor(Color.black);
	g.drawRect(_pick.get(j).x-1,_pick.get(j).y-1, 22, 22);
	g.setColor(_pick.get(j).c);
	g.fillRect(_pick.get(j).x,_pick.get(j).y, 20, 20);
}

g.setColor(Color.DARK_GRAY);
g.fillRect(650, 550, 100, 40);
Text.drawString(g, "RESET", 700, 560, true, Color.black, font16);
}
}