package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player2 extends GameObject 
{
	Menu menu;
	public boolean h;
	Handler handler;
	HUD hud;
	BasicEnemy be;
	public static Image img = null;
	public Player2(float x, float y, ID id, Handler handler, HUD hud) 
	{
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() 
	{
		x += velX;
		y += velY;
		
		x = Game.clamp((int)x, 0, Game.WIDTH - 50);
		y = Game.clamp((int)y, 0, Game.HEIGHT - 165);
		
		if(hud.getLevel() >= 10 && hud.getLevel() <= 15){
			y = Game.clamp((int)y, 100, Game.WIDTH - 38);}
		
		collision();
	}
	
	public void collision()
	{
		for(int count = 0;(count < handler.object.size());count++)
		{
			GameObject tempObject = handler.object.get(count);
			if(tempObject.getId() == ID.BasicEnemy )
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					tempObject.setVelX(tempObject.getVelX()*-1);
				}
			}
		}
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int) y, 16, 16);
	}

	public Rectangle getBounds() 
	{
		return new Rectangle(570, (int)y, 16, 16);
	}

}