package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Simulation {

	private final Grid grid;
	private final List<Robot> robots;

	public Simulation(Grid grid, List<Robot> robots) {
		super();
		this.grid = grid;
		this.robots = robots;
	}

	public List<String> run() {
		List<String> logs = new ArrayList<>();
		for (Robot robot : robots) {
			logs.add(robot.run(grid));
		}
		return logs;
	}

	public static Simulation parseSimulation(List<String> inputs) throws InvalidSimulationException {
		try {

			Iterator<String> iterator = inputs.iterator();

			Point upperBound = parsePoint(iterator.next());
			Grid grid = new Grid(upperBound);
			List<Robot> robots = new ArrayList<>();
			for (; iterator.hasNext();) {
				// first line describe the position and orientation of the robot
				String robotDescription = iterator.next();
				// second line contains the robot instructions
				String instructions = iterator.next();
				Point position = parsePoint(robotDescription);
				String orientationCode = robotDescription.substring(robotDescription.length() - 1);
				Orientation orientation = Orientation.valueOf(orientationCode);
				robots.add(new Robot(position, orientation, instructions));
				// Empty line
				if (iterator.hasNext()) {
					iterator.next();
				}
			}
			return new Simulation(grid, robots);

		} catch (NoSuchElementException e) {
			// Manage Validation of inputs
			throw new InvalidSimulationException("Invalid input", e);
		}
	}

	public Grid getGrid() {
		return grid;
	}

	public List<Robot> getRobots() {
		return robots;
	}

	private static Point parsePoint(String input) {
		String[] split = input.split(" ");
		// TODO: Handle all the validation, check the lengh of array, and that inputs are int
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		return new Point(x, y);
	}

}
