public class Main {
	public static void main(String[] args) {
		Anhaenger[] anhaenger = new Anhaenger[2];
		Fahrzeug[] fahrzeuge = new Fahrzeug[8];

		anhaenger[0] = new Anhaenger(1, 400, 400);
		anhaenger[1] = new Anhaenger(2, 500, 1000);

		fahrzeuge[0] = new LKW(3, 6, 16000, 5000);
		fahrzeuge[1] = new LKW(3, 6, 30000, 25000);

		((LKW) fahrzeuge[1]).ankuppeln(anhaenger[0]);
	
		fahrzeuge[2] = new SUV(2000, true);
		fahrzeuge[3] = new SUV(2200, false);
		fahrzeuge[4] = new SUV(1900, true);

		((SUV) fahrzeuge[3]).ankuppeln(anhaenger[1]);

		fahrzeuge[5] = new Coupe(2, 1400, true);
		fahrzeuge[6] = new Coupe(4, 1700, false);

		fahrzeuge[7] = new Motorrad(200);

		int gesamtgewicht = 0;
		for (int i = 0; i < fahrzeuge.length; i++) {
			gesamtgewicht += fahrzeuge[i].getGesamtgewicht();
		}

		System.out.println("Gesamtgewicht fahrzeuge: " + gesamtgewicht);
	}
}
