package geometry.test;

import geometry.Point;
import geometry.Line;

import org.junit.Test;
import static org.junit.Assert.*;

public class LineTest {

	@Test
	public void creation() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(5, 9);
		Line l1 = new Line(p1, p2);
		Line l2 = new Line(l1); 

		assertEquals(l1.getPointA(), p1);
		assertEquals(l1.getPointB(), p2);

		assertEquals(l2.getPointA(), p1);
		assertEquals(l2.getPointB(), p2);
	}

	@Test
	public void equals() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(5, 9);
		Point p3 = new Point(1, 2);
		Point p4 = new Point(-23, -4);

		Line l1 = new Line(p1, p2);
		Line l2 = new Line(p3, p4);

		assertNotEquals(l1, l2);
		assertEquals(l1, new Line(l1));
	}

	@Test
	public void length() {
		Line l1 = new Line(new Point(2, 4), new Point(9, 4));
		Line l2 = new Line(new Point(-5, -12), new Point(-5, -9));

		assertEquals(l1.length(), 7, 0.0f);
		assertEquals(l2.length(), 3, 0.0f);
	}
}
