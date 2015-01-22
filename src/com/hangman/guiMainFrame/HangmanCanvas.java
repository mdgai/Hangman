package com.hangman.guiMainFrame;

import java.awt.Canvas;
import java.awt.Graphics;

import com.hangman.draw.Circle;
import com.hangman.draw.Line;

public class HangmanCanvas extends Canvas {

	private LivesScorePanel livesScorePanel;

	/**
	 * Constructor
	 * 
	 * @param aLivesScorePanel
	 */
	public HangmanCanvas(LivesScorePanel aLivesScorePanel) {

		livesScorePanel = aLivesScorePanel;
	}

	/**
	 * Draw on canvas
	 * 
	 * @param g
	 * @author Tryfoy Margarita
	 */
	public void paint(Graphics g) {
		int diameter = 70, y = 5, x = this.getWidth() / 2, y_bodyline = 200;

		if (livesScorePanel.getLives() == 5) {
			Circle c = new Circle(x - diameter / 2, y);
			c.paint(getGraphics());
		} else if (livesScorePanel.getLives() == 4) {
			Line c1 = new Line(x, y + diameter, x, y_bodyline);
			c1.paint(getGraphics());
		} else if (livesScorePanel.getLives() == 3) {
			Line c1 = new Line(x, y_bodyline / 2, x - 50, y_bodyline - diameter);
			c1.paint(getGraphics());
		} else if (livesScorePanel.getLives() == 2) {
			Line c1 = new Line(x, y_bodyline / 2, x + 50, y_bodyline - diameter);
			c1.paint(getGraphics());
		} else if (livesScorePanel.getLives() == 1) {
			Line c1 = new Line(x, y_bodyline, x - 50, y_bodyline + diameter);
			c1.paint(getGraphics());
		} else if (livesScorePanel.getLives() == 0) {
			Line c1 = new Line(x, y_bodyline, x + 50, y_bodyline + diameter);
			c1.paint(getGraphics());
		}

	}

}
