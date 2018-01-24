package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends Canvas {
	
	private static final long serialVersionUID = -240840600533728354L;

	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		frame.setResizable(false);
		frame.pack();
		JFrame frame1 = new JFrame(title);
		frame1.setPreferredSize(new Dimension(width, height));
		frame1.setMaximumSize(new Dimension(width, height));
		frame1.setMinimumSize(new Dimension(width, height));
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
	    frame1.setVisible(true);
	    frame1.add(game);
		game.start();
	}
	
}
