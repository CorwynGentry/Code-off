package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.beans.beancontext.BeanContext;

import com.tutorial.main.Game.STATE;

public class HUD 
{
	private Handler handler;
	BasicEnemy be;
	public static int kiss;
	public static int health = 100;
	public static int health2 = 100;
	private static int greenValue = 255;
	private static int greenValue2 = 255;
	public static float score1 = 8;
	public static float score2 = 8;
	private static int level = 1;
	private KeyInput k;
	public HUD(Handler handler) {
		this.handler = handler;
		this.k = k;
		this.be = be;
	}
	
	public static void tick()
	{
		health = (int) Game.clamp(health, 0, 100);
		Player.love ++;
		if(Player.love == 2500){
			Game.k ++;
			Player.love = 0;
		}
		greenValue = (int) Game.clamp(greenValue, 0, 255);
		
		greenValue = health * 2;
	}
	
	public static void render(Graphics g)
	{
		if(Game.gameState == STATE.Game){
			Font font = new Font("arial",1,50);
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, 200, 32);
			g.setColor(new Color(75, greenValue, 0));
			g.fillRect(0, 0, health * 2, 32);
			g.setColor(Color.WHITE);
			g.drawRect(0, 0, 200, 32);
			}
		}
		
		



	
	public void setScore(int score)
	{
		HUD.score1 = score;
	}
	
	public int getScore()
	{
		return (int) score1;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public static void setLevel(int level)
	{
		HUD.level = level;
		
	}
}