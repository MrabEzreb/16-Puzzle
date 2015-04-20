package com.ezrebclan.puzzle16.graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Rectangle;

public class PuzzleWindow extends JFrame {

	private JPanel contentPane;
	public PuzzleSurface puzzleSurface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleWindow frame = new PuzzleWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PuzzleWindow() {
		setResizable(false);
		setSize(new Dimension(300, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		puzzleSurface = new PuzzleSurface();
		contentPane.add(puzzleSurface, BorderLayout.CENTER);
	}

}
