package com.ezrebclan.puzzle16.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PuzzlePiece extends Canvas {

	private int index;
	private boolean isLast = false;
	private boolean showing = true;
	public PuzzlePiece(int index) {
		super();
		this.index = index;
		this.setSize(50, 50);
		this.addHierarchyListener(new HierarchyListener() {
			
			@Override
			public void hierarchyChanged(HierarchyEvent e) {
				PuzzlePiece.this.setBounds(((PuzzleSurface) getParent()).getOriginFromIndex(PuzzlePiece.this.index).x, ((PuzzleSurface) getParent()).getOriginFromIndex(PuzzlePiece.this.index).y, 50, 50);
				setLocation(((PuzzleSurface) getParent()).getOriginFromIndex(PuzzlePiece.this.index).x, ((PuzzleSurface) getParent()).getOriginFromIndex(PuzzlePiece.this.index).y);
				repaint();
			}
		});
	}
	public PuzzlePiece(int index, boolean showing) {
		this(index);
		this.showing = showing;
	}
	public void moveRand(PuzzlePiece[] puzzles) {
		boolean foundSpot = false;
		while(foundSpot == false) {
			Point rand = getRandPoint();
			if(isSafe(puzzles, rand)) {
				this.setLocation(rand);
				foundSpot = true;
			}
		}
	}
	private boolean isSafe(PuzzlePiece[] puzzles, Point thisPoint) {
		for (PuzzlePiece puzzlePiece : puzzles) {
			if(puzzlePiece != null) {
				if(puzzlePiece.getX() == thisPoint.getX() && puzzlePiece.getY() == thisPoint.getY()) {
					return false;
				}
			}
		}
		return true;
	}
	private Point getRandPoint() {
		Random random = new Random();
		int x = random.nextInt(4);
		int y = random.nextInt(4);
		Point retVal = new Point(x*50, y*50);
		return retVal;
	}
	@Override
	public void paint(Graphics g) {
		if(showing) {
//			System.out.println(index);
//			System.out.println("Painted "+index+" at "+this.getX()+" "+this.getY());
			BufferedImage image2 = ((PuzzleSurface) getParent()).getImageFromIndex(index, ((PuzzleSurface) getParent()).image);
			Component imobs = ((PuzzleSurface) getParent());
			g.drawImage(image2, 0, 0, imobs);
//			g.setColor(Color.CYAN);
//			g.drawRect(0, 0, 50, 50);
		}
	}
	/**
	 * @return the showing
	 */
	public boolean isShowing() {
		return showing;
	}
	/**
	 * @param showing the showing to set
	 */
	public void setShowing(boolean showing) {
		if(this.isLast) {
			this.showing = showing;
		}
	}
}
