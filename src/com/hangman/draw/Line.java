package com.hangman.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Line extends Component {

	private int xStart, yStart, xEnd, yEnd;

	public Line(int xStart, int yStart, int xEnd, int yEnd) {
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;

		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D ga = (Graphics2D) g;
		ga.setPaint(Color.BLACK);
		ga.setStroke(new BasicStroke(10.0f));
		ga.draw(new Line2D.Double(xStart, yStart, xEnd, yEnd));

	}

}
