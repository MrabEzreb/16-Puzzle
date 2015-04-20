package com.ezrebclan.puzzle16.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PuzzlePiece extends Canvas {

	private int index;
	public PuzzlePiece(int index) {
		super();
		this.index = index;
	}
	@Override
	public void paint(Graphics g) {
		System.out.println("test");
		this.setBounds(((PuzzleSurface) getParent()).getOriginFromIndex(index).x, ((PuzzleSurface) getParent()).getOriginFromIndex(index).y, 50, 50);
		setLocation(((PuzzleSurface) getParent()).getOriginFromIndex(index).x, ((PuzzleSurface) getParent()).getOriginFromIndex(index).y);
		System.out.println("Painted "+index+" at "+this.getX()+" "+this.getY());
		BufferedImage image2 = ((PuzzleSurface) getParent()).getImageFromIndex(index, ((PuzzleSurface) getParent()).image);
		Component imobs = ((PuzzleSurface) getParent());
		g.drawImage(image2, 0, 0, imobs);
		g.setColor(Color.CYAN);
		g.drawRect(0, 0, 50, 50);
	}
}
