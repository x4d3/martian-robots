package com.example;

import java.util.Set;

import java.util.HashSet;

public class Grid {

	private final Point upperBound;
	private final Set<Point> sents = new HashSet<>();
	public Grid(Point upperBound) {
		super();
		this.upperBound = upperBound;
	}
	
	public boolean isOutOfBound(Point point){
		return point.getX() > upperBound.getX() || point.getY() > upperBound.getY()  || point.getX() < 0 || point.getY() < 0;
	}
	
	public void putScent(Point point){
		sents.add(point);
	}
	
	public boolean hasScent(Point point){
		return sents.contains(point);
	}

	public Point getUpperBound() {
		return upperBound;
	}
	
}
