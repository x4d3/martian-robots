package com.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import junit.framework.Assert;

public class SimulationTest {

	private final static List<String> INPUTS = Arrays.asList("5 3", "1 1 E", "RFRFRFRF", "", "3 2 N", "FRRFLLFFRRFLL", "", "0 3 W", "LLFFFLFLFL");

	@Test
	public void parseFromFile() throws InvalidSimulationException, IOException {
		
		List<String> lines = IOUtils.readLines(SimulationTest.class.getResourceAsStream("input1.txt"), "UTF-8");
		Simulation simulation = Simulation.parseSimulation(lines);
		assertSimulation(simulation);
	}

	@Test
	public void parseWithValidInputs() throws InvalidSimulationException {
		Simulation simulation = Simulation.parseSimulation(INPUTS);
		assertSimulation(simulation);
	}

	private static void assertSimulation(Simulation simulation) {
		Assert.assertEquals(new Point(5, 3), simulation.getGrid().getUpperBound());
		List<Robot> robots = simulation.getRobots();
		Assert.assertEquals(3, robots.size());
		Robot robot1 = robots.get(0);
		Assert.assertEquals(new Point(1, 1), robot1.getPosition());
		Assert.assertEquals(Orientation.E, robot1.getOrientation());
		Assert.assertEquals("RFRFRFRF", robot1.getInstructions());
		Robot robot2 = robots.get(1);
		Assert.assertEquals(new Point(3, 2), robot2.getPosition());
		Assert.assertEquals(Orientation.N, robot2.getOrientation());
		Assert.assertEquals("FRRFLLFFRRFLL", robot2.getInstructions());
		Robot robot3 = robots.get(2);
		Assert.assertEquals(new Point(0, 3), robot3.getPosition());
		Assert.assertEquals(Orientation.W, robot3.getOrientation());
		Assert.assertEquals("LLFFFLFLFL", robot3.getInstructions());
	}

	@Test
	public void run() throws InvalidSimulationException {
		Simulation simulation = Simulation.parseSimulation(INPUTS);
		List<String> result = simulation.run();
		Assert.assertEquals(3, result.size());
		Assert.assertEquals("1 1 E", result.get(0));
		Assert.assertEquals("3 3 N LOST", result.get(1));
		Assert.assertEquals("2 3 S", result.get(2));
	}
}
