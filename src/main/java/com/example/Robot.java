package com.example;

public class Robot {

	private static final String LOST_MESSAGE = "LOST";

	private Point position;
	private Orientation orientation;
	private String instructions;

	public Robot(Point position, Orientation orientation, String instructions) {
		super();
		this.position = position;
		this.orientation = orientation;
		this.instructions = instructions;
	}

	public String run(Grid grid) {
		for (int i = 0; i < instructions.length(); i++) {
			char instruction = instructions.charAt(i);
			switch (instruction) {
			case 'F':
				Point nextPosition = orientation.nextPoint(position);
				if (!grid.isOutOfBound(nextPosition)) {
					position = nextPosition;
				} else {
					// If a previous Robot left a Scent we do nothing otherwise our robot dies, leave a scent to is current posisition
					if (!grid.hasScent(position)) {
						grid.putScent(position);
						return getStatus() + " " + LOST_MESSAGE;
					}
				}
				
				break;
			case 'R':
				orientation = orientation.rotateRight();
				break;
			case 'L':
				orientation = orientation.rotateLeft();
				break;
			// Add other cases here. or register in a Map<Character, Instructor> if there is too many instruction.
			}

		}
		return getStatus();
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

	public String getStatus() {
		return position.getX() + " " + position.getY() + " " + orientation;
	}

}
