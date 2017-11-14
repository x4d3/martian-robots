package com.example;

public class Robot {

	private Point position;
	private Orientation orientation;
	private String instructions;
	
	public Robot(Point position, Orientation orientation, String instructions) {
		super();
		this.position = position;
		this.orientation = orientation;
		this.instructions = instructions;
	}
	
	public void run(){
		
	}

	public Point getPosition() {
		return position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public String getInstructions() {
		return instructions;
	}
	
	
	

}
