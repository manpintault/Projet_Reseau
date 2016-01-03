package pong.gui;

import java.awt.Point;
import java.awt.Image;
import java.awt.Toolkit;


public class Ball extends PongItem
{

	private Point ball_speed;


	public Ball(Point ball_speed)
	{

		super(Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/ball.png")));
		this.setPosition(100, 100); //pour pas qu'il commence bloqué au coin
		this.ball_speed = ball_speed;
	}

	

	public void updatePosition(int dimension_fenetre_X, int dimension_fenetre_Y, Racket racket)
	{
		Point tmp = this.getPosition();
		tmp.translate(ball_speed.x, ball_speed.y);

		if (tmp.x < 0)
		{
			//item_position.x = 0;
			tmp.x = 0; //update tmp point for other ifs
			this.setX(0); //update actual position
			ball_speed.x = -ball_speed.x;
		}
		if (tmp.y < 0)
		{
			tmp.y = 0;
			this.setY(0);
			ball_speed.y = -ball_speed.y;
		}
		int tmp_calc = dimension_fenetre_X - this.getWidth();
		if (tmp.x > tmp_calc)
		{
			tmp.x = tmp_calc;
			this.setX(tmp_calc);
			ball_speed.x = -ball_speed.x;
		}

		if((tmp.x < racket.getWidth()) & ((racket.getY() - racket.getHeight()/2) > tmp.y ) & (tmp.y > (racket.getY() + racket.getHeight()/2)))
		{
			tmp.x = tmp_calc;
			this.setX(tmp_calc);
			ball_speed.x = -ball_speed.x;
		}

		tmp_calc = dimension_fenetre_Y - this.getHeight();
		if (tmp.y > tmp_calc)
		{
			tmp.y = tmp_calc;
			this.setY(tmp_calc);
			ball_speed.y = -ball_speed.y;
		}


	}
}



	