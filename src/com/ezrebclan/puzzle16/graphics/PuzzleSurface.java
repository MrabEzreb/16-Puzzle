package com.ezrebclan.puzzle16.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PuzzleSurface extends JPanel {

	public PuzzlePiece[] canvas = new PuzzlePiece[15];
	public BufferedImage image;
	public PuzzlePiece finalPiece = new PuzzlePiece(15, true);
	
	/**
	 * Create the panel.
	 */
	public PuzzleSurface() {
		try {
			image = ImageIO.read(PuzzleWindow.class.getClassLoader().getResourceAsStream("res/image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setSize(new Dimension(200, 200));
		setLayout(null);
		
		for (int i = 0; i < canvas.length; i++) {
			canvas[i] = new PuzzlePiece(i);
		}
		for (PuzzlePiece pp : canvas) {
			add(pp);
		}
		add(finalPiece);
	}
	
	public void randomize() {
		PuzzlePiece[] puzzles = new PuzzlePiece[16];
		puzzles[0] = finalPiece;
		finalPiece.setLocation(50, 150);
		finalPiece.setShowing(false);
		int puzzleCount = 1;
		for (int i = 0; i < 15; i++) {
			canvas[i].moveRand(puzzles);
			puzzles[puzzleCount++] = canvas[i];
			System.out.println("randomized "+i);
		}
		canvas = puzzles;
		System.out.println("finished randomizing");
	}
	
	public BufferedImage getImageFromIndex(int index, BufferedImage image) {
		BufferedImage retVal = null;
		switch(index) {
			case 0:
				retVal = image.getSubimage(0, 0, 50, 50);
				break;
			case 1:
				retVal = image.getSubimage(50, 0, 50, 50);
				break;
			case 2:
				retVal = image.getSubimage(100, 0, 50, 50);
				break;
			case 3:
				retVal = image.getSubimage(150, 0, 50, 50);
				break;
			case 4:
				retVal = image.getSubimage(0, 50, 50, 50);
				break;
			case 5:
				retVal = image.getSubimage(50, 50, 50, 50);
				break;
			case 6:
				retVal = image.getSubimage(100, 50, 50, 50);
				break;
			case 7:
				retVal = image.getSubimage(150, 50, 50, 50);
				break;
			case 8:
				retVal = image.getSubimage(0, 100, 50, 50);
				break;
			case 9:
				retVal = image.getSubimage(50, 100, 50, 50);
				break;
			case 10:
				retVal = image.getSubimage(100, 100, 50, 50);
				break;
			case 11:
				retVal = image.getSubimage(150, 100, 50, 50);
				break;
			case 12:
				retVal = image.getSubimage(0, 150, 50, 50);
				break;
			case 13:
				retVal = image.getSubimage(50, 150, 50, 50);
				break;
			case 14:
				retVal = image.getSubimage(100, 150, 50, 50);
				break;
		}
		return retVal;
	}
	
	public Point getOriginFromIndex(int index) {
		Point retVal = null;
		switch(index) {
			case 0:
				retVal = new Point(0, 0);
				break;
			case 1:
				retVal = new Point(50, 0);
				break;
			case 2:
				retVal = new Point(100, 0);
				break;
			case 3:
				retVal = new Point(150, 0);
				break;
			case 4:
				retVal = new Point(0, 50);
				break;
			case 5:
				retVal = new Point(50, 50);
				break;
			case 6:
				retVal = new Point(100, 50);
				break;
			case 7:
				retVal = new Point(150, 50);
				break;
			case 8:
				retVal = new Point(0, 100);
				break;
			case 9:
				retVal = new Point(50, 100);
				break;
			case 10:
				retVal = new Point(100, 100);
				break;
			case 11:
				retVal = new Point(150, 100);
				break;
			case 12:
				retVal = new Point(0, 150);
				break;
			case 13:
				retVal = new Point(50, 150);
				break;
			case 14:
				retVal = new Point(100, 150);
				break;
			case 15:
				retVal = new Point(150, 150);
				break;
		}
		return new Point(retVal);
	}
}
