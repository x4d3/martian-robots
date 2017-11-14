package com.example;

import org.junit.Test;

import junit.framework.Assert;

public class OrientationTest {

	@Test
	public void rotateRight() {
		Assert.assertEquals(Orientation.E, Orientation.N.rotateRight());
		Assert.assertEquals(Orientation.S, Orientation.E.rotateRight());
		Assert.assertEquals(Orientation.W, Orientation.S.rotateRight());
		Assert.assertEquals(Orientation.N, Orientation.W.rotateRight());
	}

	@Test
	public void rotateLeft() {
		Assert.assertEquals(Orientation.W, Orientation.N.rotateLeft());
		Assert.assertEquals(Orientation.N, Orientation.E.rotateLeft());
		Assert.assertEquals(Orientation.E, Orientation.S.rotateLeft());
		Assert.assertEquals(Orientation.S, Orientation.W.rotateLeft());
	}

	@Test
	public void nextPoint() {
		Point p = new Point(1, 1);
		Assert.assertEquals(new Point(1, 2), Orientation.N.nextPoint(p));
		Assert.assertEquals(new Point(2, 1), Orientation.E.nextPoint(p));
		Assert.assertEquals(new Point(1, 0), Orientation.S.nextPoint(p));
		Assert.assertEquals(new Point(0, 1), Orientation.W.nextPoint(p));
	}

}
