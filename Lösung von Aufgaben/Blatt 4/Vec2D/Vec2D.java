public class Vec2D{

	public static double[] create(double x, double y) {
		double[] v = new double[2];

		v[0] = x;
		v[1] = y;

		return v;
	}

	public static void print(String name, double[] v) {

		System.out.println(name + ": (" + v[0] + "/" + v[1] + ")");
	}

	public static void print(String name, double val) {

		System.out.println(name + ": " + val);
	}

	public static double[] add(double[] v1, double[] v2) {
			
		return create(v1[0] + v2[0], v1[1] + v2[1]);	
	}

	public static double dot(double[] v1, double[] v2) {

		return v1[0] * v2[0] + v1[1] * v2[1];
	}

	public static double enorm(double[] v) {

		return Math.sqrt(dot(v, v));
	}

	public static double[] normalize(double[] v) {

		double v_enorm = enorm(v);

		return create(v[0] / v_enorm, v[1] / v_enorm);
	}

	public static void main(String[] args){
		
		double[] v1 = create(3.5, 4.9);
		double[] v2 = create(-1.5, 8.4);

		print("v1", v1);
		print("v2", v2);
		
		double[] v3 = add(v1, v2);
		print("add v1, v2", v3);

		double val = dot(v1, v2);
		print("dot v1, v2", val);

		double val2 = enorm(v1);
		print("enorm v1", val2);

		double[] v4 = normalize(v2);
		print("normalize v2", v4);

		// Ausgabe
		// v1: (3.5/4.9)
		// v2: (-1.5/8.4)
		// add v1, v2: (2.0/13.3)
		// dot v1, v2: 35.910000000000004
		// enorm v1: 6.021627686929839
		// normalize v2: (-0.1757906384836575/0.984427575508482)
	}

}
