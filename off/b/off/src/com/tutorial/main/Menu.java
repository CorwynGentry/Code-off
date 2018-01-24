
package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Player player;
	private Handler handler;
	private Random r;	
	public boolean l;
	HUD hud;
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
		r = new Random();
		hud = new HUD(handler);
	}
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu){
		if(mouseOver(mx, my, 220, 150, 200, 64)){
			HUD.score1  = 8;
			HUD.score2  = 8;
			handler.addObject(new Player(Game.WIDTH/2 - 32,Game.HEIGHT/2 -32, ID.Player, handler, hud));
			
			Game.gameState = STATE.Game;
			}
		if(mouseOver(mx,my,210,350,200,64)){
			System.exit(1);
		}
		if(mouseOver(mx,my,225,250,200,64)){
			Game.gameState = STATE.Help;
		}
		}
		if(Game.gameState == STATE.Help){
			if(mouseOver(mx,my,210,350,200,64)){
				Game.gameState = STATE.Menu;
			}
		}
			if(Game.gameState == STATE.Shop){
				if(mouseOver(mx,my,210,360,200,64)){
				Game.gameState = STATE.Menu;
			
		}
	}
			if(Game.gameState == STATE.Help){
				if(mouseOver(mx,my,300, 250, 200, 64)){
					if(Game.GOLD >= 5){
						Game.GOLD -= 5;
						KeyInput.Love = true;
						l = false;
					}
				}
			}
		}	

		

	
	public void mouseReleased(MouseEvent e){
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width ){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick(){
		System.out.println(Game.gameState);
	}
	
	public void render(Graphics g){
		if(Game.gameState == STATE.Menu){
		Font fnt = new Font("arial", 1,50);
		Font fnt2 = new Font("arial", 1,16);
		Font fnt3 = new Font("arial", 1,40);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Gun Boots", 190, 80);
		g.setFont(fnt2);
		g.setFont(fnt);
		g.drawRect(220, 150, 200, 64);
		g.drawString("Play", 270, 200);
		
		g.setFont(fnt3);
		g.drawRect(225, 250, 200, 64);
		g.drawString("Help", 277, 300);
		
		g.setFont(fnt);
		g.drawRect(225, 350, 200, 64);
		g.drawString("Quit", 275, 400);
	

	}else if(Game.gameState == STATE.Help){
		Font fnt = new Font("arial", 1,50);
		Font fnt2 = new Font("arial", 1,16);
		Font fnt3 = new Font("arial", 1,20);

		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawRect(225, 20, 200, 64);
		g.drawString("Help", 270, 70);
		g.setFont(fnt2);
		g.drawString("",5, 100);
		g.drawString("",5, 125);
		g.drawString("",5, 150);
		g.drawString("",5,175);
		g.drawString("",5,200);
		g.setFont(fnt);
		g.drawRect(225, 350, 200, 64);
		g.setFont(fnt);
		g.drawString("Back", 250, 400);
	}else if(Game.gameState == STATE.Win){
			Font fnt = new Font("arial", 1,50);
			Font fnt2 = new Font("arial", 1,16);
			Font fnt3 = new Font("arial", 1,20);
			g.setColor(Color.RED);
			g.setFont(fnt);
			g.drawString("Player One wins", 120, 100);
			g.setFont(fnt3);
			g.drawString("Press Space to go to the menu", 165, 400);
			}else if(Game.gameState == STATE.Win1){
				Font fnt = new Font("arial", 1,50);
				Font fnt2 = new Font("arial", 1,16);
				Font fnt3 = new Font("arial", 1,20);
				g.setColor(Color.RED);
				g.setFont(fnt);
				g.drawString("Player Two wins", 120, 100);
				g.setFont(fnt3);
				g.drawString("Press Space to go to the menu", 165, 400);
			}
	}
}
