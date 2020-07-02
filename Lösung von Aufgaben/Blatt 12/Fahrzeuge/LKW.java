public class LKW extends Fahrzeug implements Anhaengerkupplung {
	private int gewichtLadung;
	private Anhaenger anhaenger;

	public LKW(int sitze, int raeder, int gewicht, int gewichtLadung) {
		super(sitze, raeder, gewicht);
		this.gewichtLadung = gewichtLadung;
	}

	@Override
	public Anhaenger ankuppeln(Anhaenger a) {
		Anhaenger prev = anhaenger;
		anhaenger = a;
		return prev;
	}

	@Override
	public Anhaenger entkuppeln() {
		Anhaenger prev = anhaenger;
		anhaenger = null;
		return prev;
	}

	@Override
	public boolean gekuppelt() {
		return anhaenger != null;
	}

	@Override
	public int getGesamtgewicht() {
		if (anhaenger != null) {
			return super.getGesamtgewicht() + gewichtLadung + anhaenger.getGesamtgewicht();
		}

		return super.getGesamtgewicht() + gewichtLadung;
	}
}
