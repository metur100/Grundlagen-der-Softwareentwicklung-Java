public class SUV extends PKW {
	public boolean allrad;

	public SUV(int gewicht, boolean allrad) {
		super(5, gewicht);
		this.allrad = allrad;
	}

	public boolean hatAllrad() {
		return allrad;
	}
}
