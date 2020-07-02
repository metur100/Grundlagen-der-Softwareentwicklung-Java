package geometry;

public class Line {

	private Point p1;
	private Point p2;

	public Line(Line l) {
		p1 = new Point(l.getPointA());
		p2 = new Point(l.getPointB());
	}

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point getPointA() {
		return p1;
	}

	public Point getPointB() {
		return p2;
	}

	public float length() {
		return (float) Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
	}

	@Override
	public boolean equals(Object o) {
		Line l = (Line) o;
		return p1.equals(l.p1) && p2.equals(l.p2);
	}

	@Override
	public String toString() {
		return "[" + p1 + ", " + p2 + "]"; 
	}
}
