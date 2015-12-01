package pong.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Racket extends PongItem {
	
	/**
	 * Speed of racket, in pixels per timestamp
	 */
	private int racket_speed;
	/**
	 * Position of racket
	 */
	private Point racket_position = new Point(0, 0);
	
	
	public Racket(){
	
		super();
	
	}
	
	/**
         * Proceeds to the movement of the racket
	 */
	public void animate() {
		
		racket_position.y += racket_speed;
		if (racket_position.y < 0)
			racket_position.y = 0;
		if (racket_position.y > SIZE_PONG_Y - racket_height/2)
			racket_position.y = SIZE_PONG_Y - racket_height/2;

	}

}
