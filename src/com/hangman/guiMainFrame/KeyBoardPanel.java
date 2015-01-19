package com.hangman.guiMainFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyBoardPanel extends JPanel {

	private PhrasePanel phrasePanel;
	private final ArrayList<JLabel> labelslist;

	/**
	 * Creates the panel.
	 * 
	 * @author Tryfou Margarita
	 */
	public KeyBoardPanel(PhrasePanel aPhrasePanel) {

		phrasePanel = aPhrasePanel;
		labelslist = phrasePanel.getLabelList();

		// Creation of panel that contains the button
		GridBagLayout gbl_panelKeyboard = new GridBagLayout();
		gbl_panelKeyboard.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelKeyboard.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelKeyboard.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelKeyboard.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gbl_panelKeyboard);

		final JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnA.getText())) {
						labellist.setVisible(true);
						btnA.setEnabled(false);
					} else
						btnA.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnA = new GridBagConstraints();
		gbc_btnA.insets = new Insets(0, 0, 5, 5);
		gbc_btnA.gridx = 0;
		gbc_btnA.gridy = 0;
		this.add(btnA, gbc_btnA);

		final JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnB.getText())) {
						labellist.setVisible(true);
						btnB.setEnabled(false);
					} else
						btnB.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnB = new GridBagConstraints();
		gbc_btnB.insets = new Insets(0, 0, 5, 5);
		gbc_btnB.gridx = 1;
		gbc_btnB.gridy = 0;
		this.add(btnB, gbc_btnB);

		final JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnC.getText())) {
						labellist.setVisible(true);
						btnC.setEnabled(false);
					} else
						btnC.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.insets = new Insets(0, 0, 5, 5);
		gbc_btnC.gridx = 2;
		gbc_btnC.gridy = 0;
		this.add(btnC, gbc_btnC);

		final JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnD.getText())) {
						labellist.setVisible(true);
						btnD.setEnabled(false);
					} else
						btnD.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnD = new GridBagConstraints();
		gbc_btnD.insets = new Insets(0, 0, 5, 5);
		gbc_btnD.gridx = 3;
		gbc_btnD.gridy = 0;
		this.add(btnD, gbc_btnD);

		final JButton btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnE.getText())) {
						labellist.setVisible(true);
						btnE.setEnabled(false);
					} else
						btnE.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnE = new GridBagConstraints();
		gbc_btnE.insets = new Insets(0, 0, 5, 5);
		gbc_btnE.gridx = 4;
		gbc_btnE.gridy = 0;
		this.add(btnE, gbc_btnE);

		final JButton btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnF.getText())) {
						labellist.setVisible(true);
						btnF.setEnabled(false);
					} else
						btnF.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnF = new GridBagConstraints();
		gbc_btnF.fill = GridBagConstraints.VERTICAL;
		gbc_btnF.insets = new Insets(0, 0, 5, 5);
		gbc_btnF.gridx = 5;
		gbc_btnF.gridy = 0;
		this.add(btnF, gbc_btnF);

		final JButton btnG = new JButton("G");
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnG.getText())) {
						labellist.setVisible(true);
						btnG.setEnabled(false);
					} else
						btnG.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnG = new GridBagConstraints();
		gbc_btnG.insets = new Insets(0, 0, 5, 0);
		gbc_btnG.gridx = 6;
		gbc_btnG.gridy = 0;
		this.add(btnG, gbc_btnG);

		final JButton btnH = new JButton("H");
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnH.getText())) {
						labellist.setVisible(true);
						btnH.setEnabled(false);
					} else
						btnH.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnH = new GridBagConstraints();
		gbc_btnH.insets = new Insets(0, 0, 5, 5);
		gbc_btnH.gridx = 0;
		gbc_btnH.gridy = 1;
		this.add(btnH, gbc_btnH);

		final JButton btnI = new JButton("I");
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnI.getText())) {
						labellist.setVisible(true);
						btnI.setEnabled(false);
					} else
						btnI.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnI = new GridBagConstraints();
		gbc_btnI.insets = new Insets(0, 0, 5, 5);
		gbc_btnI.gridx = 1;
		gbc_btnI.gridy = 1;
		this.add(btnI, gbc_btnI);

		final JButton btnJ = new JButton("J");
		btnJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnJ.getText())) {
						labellist.setVisible(true);
						btnJ.setEnabled(false);
					} else
						btnJ.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnJ = new GridBagConstraints();
		gbc_btnJ.insets = new Insets(0, 0, 5, 5);
		gbc_btnJ.gridx = 2;
		gbc_btnJ.gridy = 1;
		this.add(btnJ, gbc_btnJ);

		final JButton btnK = new JButton("K");
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnK.getText())) {
						labellist.setVisible(true);
						btnK.setEnabled(false);
					} else
						btnK.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnK = new GridBagConstraints();
		gbc_btnK.insets = new Insets(0, 0, 5, 5);
		gbc_btnK.gridx = 3;
		gbc_btnK.gridy = 1;
		this.add(btnK, gbc_btnK);

		final JButton btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnL.getText())) {
						labellist.setVisible(true);
						btnL.setEnabled(false);
					} else
						btnL.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnL = new GridBagConstraints();
		gbc_btnL.insets = new Insets(0, 0, 5, 5);
		gbc_btnL.gridx = 4;
		gbc_btnL.gridy = 1;
		this.add(btnL, gbc_btnL);

		final JButton btnM = new JButton("M");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnM.getText())) {
						labellist.setVisible(true);
						btnM.setEnabled(false);
					} else
						btnM.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnM = new GridBagConstraints();
		gbc_btnM.insets = new Insets(0, 0, 5, 5);
		gbc_btnM.gridx = 5;
		gbc_btnM.gridy = 1;
		this.add(btnM, gbc_btnM);

		final JButton btnN = new JButton("N");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnN.getText())) {
						labellist.setVisible(true);
						btnN.setEnabled(false);
					} else
						btnN.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnN = new GridBagConstraints();
		gbc_btnN.insets = new Insets(0, 0, 5, 0);
		gbc_btnN.gridx = 6;
		gbc_btnN.gridy = 1;
		this.add(btnN, gbc_btnN);

		final JButton btnO = new JButton("O");
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnO.getText())) {
						labellist.setVisible(true);
						btnO.setEnabled(false);
					} else
						btnO.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnO = new GridBagConstraints();
		gbc_btnO.insets = new Insets(0, 0, 5, 5);
		gbc_btnO.gridx = 0;
		gbc_btnO.gridy = 2;
		this.add(btnO, gbc_btnO);

		final JButton btnP = new JButton("P");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnP.getText())) {
						labellist.setVisible(true);
						btnP.setEnabled(false);
					} else
						btnP.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnP = new GridBagConstraints();
		gbc_btnP.insets = new Insets(0, 0, 5, 5);
		gbc_btnP.gridx = 1;
		gbc_btnP.gridy = 2;
		this.add(btnP, gbc_btnP);

		final JButton btnQ = new JButton("Q");
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnQ.getText())) {
						labellist.setVisible(true);
						btnQ.setEnabled(false);
					} else
						btnQ.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnQ = new GridBagConstraints();
		gbc_btnQ.insets = new Insets(0, 0, 5, 5);
		gbc_btnQ.gridx = 2;
		gbc_btnQ.gridy = 2;
		this.add(btnQ, gbc_btnQ);

		final JButton btnR = new JButton("R");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnR.getText())) {
						labellist.setVisible(true);
						btnR.setEnabled(false);
					} else
						btnR.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnR = new GridBagConstraints();
		gbc_btnR.insets = new Insets(0, 0, 5, 5);
		gbc_btnR.gridx = 3;
		gbc_btnR.gridy = 2;
		this.add(btnR, gbc_btnR);

		final JButton btnS = new JButton("S");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnS.getText())) {
						labellist.setVisible(true);
						btnS.setEnabled(false);
					} else
						btnS.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnS = new GridBagConstraints();
		gbc_btnS.insets = new Insets(0, 0, 5, 5);
		gbc_btnS.gridx = 4;
		gbc_btnS.gridy = 2;
		this.add(btnS, gbc_btnS);

		final JButton btnT = new JButton("T");
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnT.getText())) {
						labellist.setVisible(true);
						btnT.setEnabled(false);
					} else
						btnT.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnT = new GridBagConstraints();
		gbc_btnT.insets = new Insets(0, 0, 5, 5);
		gbc_btnT.gridx = 5;
		gbc_btnT.gridy = 2;
		this.add(btnT, gbc_btnT);

		final JButton btnU = new JButton("U");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnU.getText())) {
						labellist.setVisible(true);
						btnU.setEnabled(false);
					} else
						btnU.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnU = new GridBagConstraints();
		gbc_btnU.insets = new Insets(0, 0, 5, 0);
		gbc_btnU.gridx = 6;
		gbc_btnU.gridy = 2;
		this.add(btnU, gbc_btnU);

		final JButton btnV = new JButton("V");
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnV.getText())) {
						labellist.setVisible(true);
						btnV.setEnabled(false);
					} else
						btnV.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnV = new GridBagConstraints();
		gbc_btnV.insets = new Insets(0, 0, 0, 5);
		gbc_btnV.gridx = 1;
		gbc_btnV.gridy = 3;
		this.add(btnV, gbc_btnV);

		final JButton btnW = new JButton("W");
		btnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnW.getText())) {
						labellist.setVisible(true);
						btnW.setEnabled(false);
					} else
						btnW.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnW = new GridBagConstraints();
		gbc_btnW.insets = new Insets(0, 0, 0, 5);
		gbc_btnW.gridx = 2;
		gbc_btnW.gridy = 3;
		this.add(btnW, gbc_btnW);

		final JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnX.getText())) {
						labellist.setVisible(true);
						btnX.setEnabled(false);
					} else
						btnX.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnX = new GridBagConstraints();
		gbc_btnX.insets = new Insets(0, 0, 0, 5);
		gbc_btnX.gridx = 3;
		gbc_btnX.gridy = 3;
		this.add(btnX, gbc_btnX);

		final JButton btnY = new JButton("Y");
		btnY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnY.getText())) {
						labellist.setVisible(true);
						btnY.setEnabled(false);
					} else
						btnY.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnY = new GridBagConstraints();
		gbc_btnY.insets = new Insets(0, 0, 0, 5);
		gbc_btnY.gridx = 4;
		gbc_btnY.gridy = 3;
		this.add(btnY, gbc_btnY);

		final JButton btnZ = new JButton("Z");
		btnZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JLabel labellist : labelslist) {
					if (labellist.getText().equalsIgnoreCase(btnZ.getText())) {
						labellist.setVisible(true);
						btnZ.setEnabled(false);
					} else
						btnZ.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnZ = new GridBagConstraints();
		gbc_btnZ.insets = new Insets(0, 0, 0, 5);
		gbc_btnZ.gridx = 5;
		gbc_btnZ.gridy = 3;
		this.add(btnZ, gbc_btnZ);
	}
}
