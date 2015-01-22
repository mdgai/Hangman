package com.hangman.guiMainFrame;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LivesScorePanel extends JPanel {

	private static int lives, score;
	private JLabel lblTrackLives;
	private JLabel lblTrackScore;

	/**
	 * Create the panel. Track lives and score
	 */
	public LivesScorePanel() {

		initialize();
		setLayout(new GridLayout(0, 4, 0, 0));

		// Score and Lives labels
		JLabel lblLives = new JLabel("Lives:");
		lblLives.setFont(new Font("Tahoma", Font.BOLD, 28));
		this.add(lblLives);

		lblTrackLives = new JLabel(String.valueOf(lives));
		lblTrackLives.setFont(new Font("Tahoma", Font.BOLD, 28));
		this.add(lblTrackLives);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 28));
		this.add(lblScore);

		lblTrackScore = new JLabel(String.valueOf(score));
		lblTrackScore.setFont(new Font("Tahoma", Font.BOLD, 28));
		this.add(lblTrackScore);

	}

	/**
	 * Initializes variables lives and score
	 * 
	 * @author Tryfou Margarita
	 */
	public void initialize() {
		lives = 6;
		score = 0;
	}

	/**
	 * 
	 * @return
	 * @author Tryfou Margarita
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @author Tryfou Margarita
	 */
	public void setLives() {
		if (lives > 0)
			lives--;
		lblTrackLives.setText(String.valueOf(lives));
	}

	/**
	 * @author Tryfou Margarita
	 */
	public void setScore() {
		score += 50;
		lblTrackScore.setText(String.valueOf(score));
	}

}
