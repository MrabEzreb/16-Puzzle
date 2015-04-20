package com.ezrebclan.puzzle16.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PuzzleSurface extends JPanel {

	public PuzzlePiece[] canvas = new PuzzlePiece[15];
	public BufferedImage image;
	
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
	}
	
	public BufferedImage getImageFromIndex(int index, BufferedImage image) {
		BufferedImage retVal = null;
		switch(index) {
			case 0:
				retVal = image.getSubimage(0, 0, 50, 50);
			case 1:
				retVal = image.getSubimage(50, 0, 50, 50);
			case 2:
				retVal = image.getSubimage(100, 0, 50, 50);
			case 3:
				retVal = image.getSubimage(150, 0, 50, 50);
			case 4:
				retVal = image.getSubimage(0, 50, 50, 50);
			case 5:
				retVal = image.getSubimage(50, 50, 50, 50);
			case 6:
				retVal = image.getSubimage(100, 50, 50, 50);
			case 7:
				retVal = image.getSubimage(150, 50, 50, 50);
			case 8:
				retVal = image.getSubimage(0, 100, 50, 50);
			case 9:
				retVal = image.getSubimage(50, 100, 50, 50);
			case 10:
				retVal = image.getSubimage(100, 100, 50, 50);
			case 11:
				retVal = image.getSubimage(150, 100, 50, 50);
			case 12:
				retVal = image.getSubimage(0, 150, 50, 50);
			case 13:
				retVal = image.getSubimage(50, 150, 50, 50);
			case 14:
				retVal = image.getSubimage(100, 150, 50, 50);
		}
		return retVal;
	}
	
	public Point getOriginFromIndex(int index) {
		int[] retVal = null;
		switch(index) {
			case 0:
				retVal = new int[] {0, 0};
			case 1:
				retVal = new int[] {50, 0};
			case 2:
				retVal = new int[] {100, 0};
			case 3:
				retVal = new int[] {150, 0};
			case 4:
				retVal = new int[] {0, 50};
			case 5:
				retVal = new int[] {50, 50};
			case 6:
				retVal = new int[] {100, 50};
			case 7:
				retVal = new int[] {150, 50};
			case 8:
				retVal = new int[] {0, 100};
			case 9:
				retVal = new int[] {50, 100};
			case 10:
				retVal = new int[] {100, 100};
			case 11:
				retVal = new int[] {150, 100};
			case 12:
				retVal = new int[] {0, 150};
			case 13:
				retVal = new int[] {50, 150};
			case 14:
				retVal = new int[] {100, 150};
		}
		return new Point(retVal[0], retVal[1]);
	}
}
