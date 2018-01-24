package Pong;
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.Rectangle;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;

	import javax.imageio.ImageIO;

	public class BasicEnemy extends GameObject
	{
		private Handler handler;
		public static Image img = null;

		public BasicEnemy(float x, float y, ID id, Handler handler) 
		{
			super(x, y, id);
			
			this.handler = handler;
			
			velX = 5;
			velY = 5;
		}

		public void tick() 
		{
			x += velX;
			y += velY;
			
			
			if(x <= 0 || x >= Game.WIDTH - 16)
				velX *= -1;
			if(y <= 0 || y >= Game.HEIGHT - 40)
				velY *= -1;
			
			//handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.03f, handler));
		}

		public void render(Graphics g) 
		{
			g.setColor(Color.WHITE);
			g.drawRoundRect(100, 100, 16,16,5,10);
		}

		public Rectangle getBounds() 
		{
			return new Rectangle((int)x, (int)y, 16, 16);
		}

	}