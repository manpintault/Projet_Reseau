package pong.gui;

import java.awt.Image;

abstract class PongItem {

	/**
	 * Width of pong area
	 */
	private static final int SIZE_PONG_X = 800;
	/**
	 * Height of pong area
	 */
	private static final int SIZE_PONG_Y = 600;
	
	/**
	 * Speed of ball (in pixels per second)
	 */
	public static final int BALL_SPEED = 2;
	/**
	 * Speed of racket (in pixels per second)
	 */
	public static final int RACKET_SPEED = 4;

	/**
	 * Ball to be displayed
	 */
	private final Image ball;
	/**
	 * Width of ball in pixels
	 */
	private int ball_width;
	/**
	 * Height of ball in pixels
	 */
	private int ball_height;
	
	/**
	 * One Racket to be displayed
	 */
	private final Image racket;
	/**
	 * Width of the racket in pixels
	 */
	private int racket_width;
	/**
	 * Height of the racket in pixels
	 */
	private int racket_height;
	
	

	public PongItem() {
	
	    ImageIcon icon;
		
		this.racket = Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/racket.png"));
		icon = new ImageIcon(racket);
		this.racket_width = icon.getIconWidth();
		this.racket_height = icon.getIconHeight();
		
		this.ball = Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/ball.png"));
		icon = new ImageIcon(ball);
		this.ball_width = icon.getIconWidth();
		this.ball_height = icon.getIconHeight();
	
	}
	
	abstract void animate();


}