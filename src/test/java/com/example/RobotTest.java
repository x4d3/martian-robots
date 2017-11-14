package com.example;

import org.junit.Test;

import junit.framework.Assert;

public class RobotTest {

	@Test
	public void runWithDeath() {
		Robot robot = new Robot(new Point(2, 2), Orientation.N, "FFFFF");
		Grid grid = new Grid(new Point(4, 4));
		//The robot dies
		Assert.assertEquals("2 4 N LOST", robot.run(grid));
		//The robot leaves a scent
		Assert.assertTrue(grid.hasScent(new Point(2, 4)));
	}

	@Test
	public void runWithDeathPreventedFromPreviousRobot() {
		Robot robot = new Robot(new Point(2, 2), Orientation.N, "FFFFF");
		Grid grid = new Grid(new Point(4, 4));
		grid.putScent(new Point(2, 4));

		Assert.assertEquals("2 4 N", robot.run(grid));
	}

}
