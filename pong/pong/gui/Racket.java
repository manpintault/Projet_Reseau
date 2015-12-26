package pong.gui;

import java.awt.Point;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Racket extends PongItem implements KeyListener
{

	private int racket_speed;
	private final int RACKET_SPEED;


	public Racket(int racket_speed)
	{

		super(Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/racket.png")));
		this.RACKET_SPEED = racket_speed;
		this.racket_speed = racket_speed;
		//this.addKeyListener(this);
	}

	

	public void updatePosition(int dimension_fenetre_Y)
	{
		//Point tmp = this.getPosition();
		//tmp.translate(ball_speed.x, ball_speed.y);
		int tmp_y = this.getY();
		tmp_y += racket_speed;
		this.setY(tmp_y);
		if (tmp_y < 0)
		{
			tmp_y = 0;
			this.setY(tmp_y);
		}
		int tmp_calc = dimension_fenetre_Y - this.getHeight()/2;
		if (tmp_y > tmp_calc)
		{
			tmp_y = tmp_calc;
			this.setY(tmp_y);
		}


	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
				this.racket_speed = -this.RACKET_SPEED;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
				this.racket_speed = this.RACKET_SPEED;
				break;
			default:
				System.out.println("got press "+e);
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
				this.racket_speed = 0;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
				this.racket_speed = 0;
				break;
			default:
				System.out.println("got release "+e);
		}
	}

	public void keyTyped(KeyEvent e) { }
}



	