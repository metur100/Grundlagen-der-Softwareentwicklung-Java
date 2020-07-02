package geometry;

public class Triangle {

	private Point[] p;

	public Triangle(Triangle t) {
		p[0] = new Point(t.getPointA());
		p[1] = new Point(t.getPointB());
		p[2] = new Point(t.getPointC());
	}

	public Triangle(Point a, Point b, Point c) {
		p = new Point[3];

		p[0] = a;
		p[1] = b;
		p[2] = c;
	}

	public Point getPointA() {
		return p[0];
	}

	public Point getPointB() {
		return p[1];
	}

	public Point getPointC() {
		return p[2];
	}

	public Line[] getLines() {
		Line[] lines = new Line[3];

		lines[0] = new Line(p[0], p[1]);
		lines[1] = new Line(p[1], p[2]);
		lines[2] = new Line(p[2], p[0]);

		return lines;
	}

	@Override
	public boolean equals(Object o) {
		Triangle t = (Triangle) o;
		for (int i = 0; i < p.length; i++) {
			if (!p[i].equals(t.p[i])) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		return "<A: " + p[0] + ", B: " + p[1] + ", C: " + p[2] + ">";
	}
}
