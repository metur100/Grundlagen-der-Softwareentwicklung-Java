package geometry.test;

import geometry.Point;
import geometry.Line;
import geometry.Triangle;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {

	@Test
	public void creation() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(5, 2);
		Point p3 = new Point(3, 5);

		Triangle t1 = new Triangle(p1, p2, p3);

		assertEquals(t1.getPointA(), p1);
		assertEquals(t1.getPointB(), p2);
		assertEquals(t1.getPointC(), p3);
	}

	@Test
	public void equals() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(5, 2);
		Point p3 = new Point(3, 5);
		Point p4 = new Point(5, 3);

		Triangle t1 = new Triangle(p1, p2, p3);
		Triangle t2 = new Triangle(p1, p4, p3);

		assertNotEquals(t1, t2);
		assertEquals(t1, new Triangle(p1, p2, p3));
	}

	@Test
	public void getLines() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(5, 2);
		Point p3 = new Point(3, 5);

		Triangle t1 = new Triangle(p1, p2, p3);

		Line[] lines = t1.getLines();

		assertEquals(lines[0], new Line(p1, p2));
		assertEquals(lines[1], new Line(p2, p3));
		assertEquals(lines[2], new Line(p3, p1));
	}
}
