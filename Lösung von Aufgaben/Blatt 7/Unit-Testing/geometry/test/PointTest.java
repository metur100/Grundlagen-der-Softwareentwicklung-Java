package geometry.test;

import geometry.Point;

import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {

	@Test
	public void creation() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(5, 9);

		assertEquals(p1.getX(), 1, 0.0f);
		assertEquals(p1.getY(), 2, 0.0f);
		assertEquals(p2.getX(), 5, 0.0f);
		assertEquals(p2.getY(), 9, 0.0f);
	}

	@Test
	public void equals() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(5, 9);
		Point p3 = new Point(1, 2);

		assertEquals(p1, p3);
		assertNotEquals(p1, p2);
	}
}
