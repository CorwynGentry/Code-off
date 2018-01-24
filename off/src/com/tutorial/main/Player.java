package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.tutorial.main.Game.STATE;

public class Player extends GameObject  {
	Menu menu;
	Game game;
	public boolean h;
	private final float MAX_SPEED = 4;
	private boolean falling = true;
	private boolean shoot = false;
	private float gravity = 0.3f;
	Handler handler;
	HUD hud;
	public static float qq;
	public static float q;
	public static int love;
	BasicEnemy be;
	public static Image img = null;
	public Player(float x, float y, ID id, Handler handler, HUD hud) 
	{
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
		q = this.y;
		qq = this.x;
	}

	public void tick() 
	{
		x += velX;
		y += velY;
		x = Game.clamp((int)x, 0, Game.WIDTH - 33);
		y = Game.clamp((int)y, 0, Game.HEIGHT - 60);
		
		if(hud.getLevel() >= 10 && hud.getLevel() <= 15){
			y = Game.clamp((int)y, 100, Game.WIDTH - 38);
		}
		if(y == Game.HEIGHT - 210){
			HUD.score1 = 8;
		}
		if(falling || jumping){
			velY += gravity;
			if(velY > MAX_SPEED){
				velY = MAX_SPEED;
			}
			if(HUD.health == 0){
				handler.removeAll();
				Game.gameState = STATE.Win1;
				
			}
		}
		collision();
	}
	
	public void collision()
	{
		for(int count = 0;(count < handler.object.size());count++)
		{
			GameObject tempObject = handler.object.get(count);
			if(tempObject.getId() == ID.Shot2)
			{
				if(tempObject.getBounds().intersects(getBounds())){
					HUD.health -= 1;
				}
					
				}
				}
			}
		

	

	public void render(Graphics g) 
	{
		g.setColor(Color.green);
		g.fillRect((int)x, (int) y, 32, 32);
		
	}

	public Rectangle getBounds() 
	{	
		return new Rectangle((int) x, (int)y, 32, 32);
	}
public float getY(){
	return y;
}
public static float getQ(){
	
	return q;
}
}
