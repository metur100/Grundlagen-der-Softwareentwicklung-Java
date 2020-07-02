public class Coupe extends PKW {
	private boolean faltdach;
		
	public Coupe (int sitze, int gewicht, boolean faltdach) {
		super(sitze, gewicht);
		this.faltdach = faltdach;
	}
	
	public boolean hatFaltdach() {
		return faltdach;
	}
}
