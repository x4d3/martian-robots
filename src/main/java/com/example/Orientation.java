package com.example;

public enum Orientation {

	N(0,1), E(1,0), S(0,-1), W(-1,0);
	
	private final int xIncrement;
	private final int yIncrement;
	private Orientation(int xIncrement, int yIncrement) {
		this.xIncrement = xIncrement;
		this.yIncrement = yIncrement;
	}
	
	public Orientation rotateRight(){
		return rotate(1);
	}
	public Orientation rotateLeft(){
		return rotate(-1);
	}
	
	private Orientation rotate(int direction){
		int newIndex = Math.floorMod(this.ordinal() + direction, 4);
		return values()[newIndex];
	}
	
	public Point nextPoint(Point p){
		return new Point(p.getX() + xIncrement, p.getY() + yIncrement);
	}
	
	
}
