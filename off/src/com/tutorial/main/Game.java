
package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends Canvas implements Runnable{
	public static String winner = "no";
	public static String winner1 = "no";
	private static final long serialVersionUID = 1550691097823471818L;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Random r;
	public static int k = 10;
	private int i = 0;
	HUD hud;
	private Image img;
	private Menu menu;
	public static int GOLD = 0;
	public static boolean shot = false;
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	
	public enum STATE {
		Game,
		End,
		Help,
		Menu,  
		love, 
		Shop, 
		main, Win, Win1;
		
	}
	public static STATE gameState = STATE.Menu;
	public static boolean shot1 = false;
	
    
	public Game(){
		handler = new Handler();
		menu = new Menu(this, handler);
		hud = new HUD(handler);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		new Window(WIDTH, HEIGHT, "Gun Boots", this);
		r = new Random();
		//handler.addObject(new Player(0,HEIGHT/2 -24, ID.Player, handler, hud));
		//handler.addObject(new Player2(0,HEIGHT/2 -24, ID.Player2, handler, hud));
		}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public static float clamp(int x, int min, int max)
	{
		if(x >= max)
			return max;
		else if(x <= min)
			return min;
		else
			return x;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
}
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double ammountOfTicks = 60.0;
		double ns = 1000000000 / ammountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta --;
			}
			if(running)
				try {
					render();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			frames ++;
			Player.love ++;  
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			
		
			}			
		}
		stop();
	}
	
	
	private void tick(){
		if(gameState == STATE.Game){
		handler.tick();
		hud.tick();
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.Win || gameState == STATE.Win1){
			menu.tick();
			//menup.tick();
		}
		
		
	}
	
	private void render() throws IOException{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){	
			this.createBufferStrategy(5);
			return;
		}
	  
		Graphics g = bs.getDrawGraphics();
	//	g.drawImage(Player.img, (int)getX(), (int)getY(), (int)32, (int)32, null);
		g.setColor(Color.black);
		g.fillRect( 0, 0, WIDTH, HEIGHT);
		handler.render(g);
		if(gameState == STATE.Game){
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.Win || gameState == STATE.Win1){
			menu.render(g);
			//menup.render(g);
			}
		
			
		g.dispose();
		bs.show();
	}
	
	private Image read(File file) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[]args){
		new Game();
		
		
		
		}
}