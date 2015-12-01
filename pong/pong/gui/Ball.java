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

public class Ball extends PongItem {

    /**
	 * Position of ball
	 */
	private Point ball_position = new Point(0, 0);
	/**
	 * Speed of ball, in pixels per timestep
	 */
	private Point ball_speed = new Point(BALL_SPEED, BALL_SPEED);
   
	public Ball(){
	
		super();
	
	}

	public void animate() {
		/* Update ball position */
		ball_position.translate(ball_speed.x, ball_speed.y);
		if (ball_position.x < 0)
		{
			ball_position.x = 0;
			ball_speed.x = -ball_speed.x;
		}
		if (ball_position.y < 0)
		{
			ball_position.y = 0;
			ball_speed.y = -ball_speed.y;
		}
		if (ball_position.x > SIZE_PONG_X - ball_width)
		{
			ball_position.x = SIZE_PONG_X - ball_width;
			ball_speed.x = -ball_speed.x;
		}
		if (ball_position.y > SIZE_PONG_Y - ball_height)
		{
			ball_position.y = SIZE_PONG_Y - ball_height;
			ball_speed.y = -ball_speed.y;
		}
	}

}