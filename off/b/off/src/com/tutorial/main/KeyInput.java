package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter {
	private Handler handler; 
	public int k;
	private int o = 0;
	private Menu menu;
	private boolean[] keydown = new boolean[4];
	private boolean[] keydown1 = new boolean[4];
	int GRAVITY = 3;
	int TERMINAL_VELOCITY = 10;
	public static boolean Love;
	public static boolean Love1; 
	public KeyInput(Handler handler){
		this.handler = handler;
		keydown[0] = false;
		keydown[1] = false;
		keydown[2] = false;
		keydown[3] = false;
		keydown1[0] = false;
		keydown1[1] = false;
		keydown1[2] = false;
		keydown1[3] = false;
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0;(i< handler.object.size()); i ++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_W){
			
					tempObject.setVelY(-5);
					Player.jumping = true;
					if(HUD.score1 > 0){
						
						HUD.score1 -= 1;
					}
					keydown[0] = true;
					}
					
				
				if(key == KeyEvent.VK_S){ 
					tempObject.setVelY(5);
					keydown[1] = true;
				}
				if(key == KeyEvent.VK_A){ 
					tempObject.setVelX(-5);
					keydown[2] = true;
				}
				if(key == KeyEvent.VK_D){ 
					tempObject.setVelX(5);
					keydown[3] = true;
				}
			}
						if(tempObject.getId() == ID.Player2){
							if(key == KeyEvent.VK_UP){ 
									
									tempObject.setVelY(-5);
									
									if(HUD.score2 > 0){
										HUD.score2 -= 1;
									}
									keydown1[0] = true;
									
							}
							if(key == KeyEvent.VK_DOWN){ 
								tempObject.setVelY(5);
								keydown1[1] = true;}
							if(key == KeyEvent.VK_LEFT){
								tempObject.setVelX(-5);
								keydown1[2] = true;
							}
							if(key == KeyEvent.VK_RIGHT){
								tempObject.setVelX(5);
								keydown1[3] = true;
							}
							}
						
						}
		if(Game.gameState == STATE.Win){
			if(key == KeyEvent.VK_SPACE){
				Game.gameState = STATE.Menu;
				HUD.health = 100;
				HUD.health2 = 100;
			}
		}
		if(Game.gameState == STATE.Win){
			if(key == KeyEvent.VK_F1){
				Game.gameState = STATE.Menu;
				HUD.health = 100;
				HUD.health2 = 100;
			}				
			}
		if(Game.gameState == STATE.Win1){
			if(key == KeyEvent.VK_SPACE){
				Game.gameState = STATE.Menu;
				HUD.health = 100;
				HUD.health2 = 100;
			}
		}
		}
	public void keyReleased(KeyEvent e){
		
		int key = e.getKeyCode();
		for(int i = 0;(i< handler.object.size()); i ++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player){
		if(key == KeyEvent.VK_W){ 
			//tempObject.setVelY(0);
			keydown[0] = false;
		}
		if(key == KeyEvent.VK_S){ 
			//tempObject.setVelY(0);
			keydown[1] = false;
			}
		if(key == KeyEvent.VK_A){ 
			//tempObject.setVelX(0);
			keydown[2] = false;
			}
		if(key == KeyEvent.VK_D){ 
			//tempObject.setVelX(0);
			keydown[3] = false;	
		}
		if(!keydown[0] && !keydown[1]){
			tempObject.setVelY(0);
		}
		if(!keydown[2] && !keydown[3]){
			tempObject.setVelX(0);
		}
	}
		if(tempObject.getId() == ID.Player2){
			if(key == KeyEvent.VK_UP){ 
				//tempObject.setVelY(0);
				keydown1[0] = false;	
				
				}
			if(key == KeyEvent.VK_DOWN){ 
				//tempObject.setVelY(0);
				keydown1[1] = false;	}
			if(key == KeyEvent.VK_LEFT){ 
				//tempObject.setVelX(0);
				keydown1[2] = false;	}
			if(key == KeyEvent.VK_RIGHT){ 
				//tempObject.setVelX(0);
				keydown1[3] = false;	}
		}
		if(!keydown1[0] && !keydown1[1]){
			tempObject.setVelY(0);
		}
		if(!keydown1[2] && !keydown1[3]){
			tempObject.setVelX(0);
		}
		}
		
}
}
