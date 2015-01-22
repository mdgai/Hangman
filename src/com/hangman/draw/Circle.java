package com.hangman.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle extends Component {

	private int diameter;
	private int x, y;

	public Circle(int x, int y) {
		this.x = x;
		this.y = y;
		diameter = 70;
	}

	/**
	 * Creates 2D graphics for circle
	 * 
	 * @param g
	 * @author Tryfou Margarita
	 */
	@Override
	public void paint(Graphics g) {
		// Draw circle
		Graphics2D ga = (Graphics2D) g;
		ga.setPaint(Color.BLACK);
		ga.setStroke(new BasicStroke(10.0f));
		ga.draw(new Ellipse2D.Double(x, y, diameter, diameter));

		// Fills the face with eyes and mouth.
		ga.setPaint(Color.BLACK);
		ga.fill(new Ellipse2D.Double(x + (diameter / 2) - (diameter / 4), y
				+ (diameter / 3), 10, 10));

		ga.setPaint(Color.BLACK);
		ga.fill(new Ellipse2D.Double(x + (diameter / 2) + (diameter / 4) - 10,
				y + (diameter / 3), 10, 10));

		ga.setPaint(Color.BLACK);
		ga.drawArc(x + (diameter / 2) - 2, y + (diameter / 2) + (diameter / 6),
				5, 5, 0, -180);

	}

}
