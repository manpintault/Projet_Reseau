package pong.gui;

import java.awt.Point;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PongItem  {
	/**
	 * Image to be displayed
	 */
	final Image item;
	/**
	 * Width of item in pixels
	 */
	private  int width;
	/**
	 * Height of item in pixels
	 */
	private int height;
	/**
	 * Position of item
	 */
	private Point position = new Point(0, 0); 
	/**
	 * Speed of item, in pixels per timestep
	 */
	//private Point speed = new Point(SPEED, SPEED);

	public int getWidth()
	{
		return this.width;

	}

	public int getHeight()
	{
		return this.height;

	}

	public Point getPosition()
	{
		return this.position;
	}

	public int getY()
	{
		return this.position.y;
	}

	public int setX()
	{
		return this.position.x;
	}

	public Image getImage()
	{
		return this.item;
	}

	public void setPosition(int x, int y)
	{
		this.position.x = x;
		this.position.y = y;
	}

	public void setX(int x)
	{
		this.position.x = x;
	}

	public void setY(int y)
	{
		this.position.y = y;
	}


	public PongItem (Image im)
	{
		ImageIcon icon;
		this.item = im;
		icon = new ImageIcon(item);
		this.width = icon.getIconWidth();
		this.height = icon.getIconHeight();

	}


}