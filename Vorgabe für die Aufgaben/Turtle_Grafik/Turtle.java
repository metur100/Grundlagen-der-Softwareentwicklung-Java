
public class Turtle {

	//Constants
	private static final double STEP_FACTOR = 0.01;
	private static final int DEFAULT_ANGLE = 0;

	//Attributes
	private double m_positionX;
	private double m_positionY;
	private int m_angle;
	private boolean m_drawing;

	//Constructors
	public Turtle() {
		m_positionX = 0.5;
		m_positionY = 0.5;
		m_angle = DEFAULT_ANGLE;
		m_drawing = true;
	}

	//Methods
	public void forward(int p_steps) {
		double newX;
		double newY;
		double angle;

		angle = Math.toRadians(m_angle);
		newX = m_positionX + p_steps * Math.sin(angle) * STEP_FACTOR;
		newY = m_positionY + p_steps * Math.cos(angle) * STEP_FACTOR;

		if (m_drawing) StdDraw.line(m_positionX, m_positionY, newX, newY);

		m_positionX = newX;
		m_positionY = newY;
	}

	public void backward(int p_steps) {
		double newX;
		double newY;
		double angle;

		angle = Math.toRadians(m_angle);
		newX = m_positionX - p_steps * Math.sin(angle) * STEP_FACTOR;
		newY = m_positionY - p_steps * Math.cos(angle) * STEP_FACTOR;

		if (m_drawing) StdDraw.line(m_positionX, m_positionY, newX, newY);

		m_positionX = newX;
		m_positionY = newY;
	}

	public void right(int p_degrees) {
		m_angle = (m_angle + p_degrees) % 360;
	}

	public void left(int p_degrees) {
		m_angle = (m_angle - p_degrees) % 360;
	}

	public void up() {
		m_drawing = false;
	}

	public void down() {
		m_drawing = true;
	}

}
