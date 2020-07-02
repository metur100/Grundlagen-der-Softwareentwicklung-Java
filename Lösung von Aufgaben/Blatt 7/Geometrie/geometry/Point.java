package geometry;

public class Point {
	private float x;
	private float y;

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		Point p = (Point) o;
		return x == p.x && y == p.y;
	}

	@Override
	public String toString() {
		return "(" + x + "/" + y + ")";
	}
};
