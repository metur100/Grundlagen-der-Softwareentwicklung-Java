public interface Anhaengerkupplung {
	Anhaenger ankuppeln(Anhaenger a);

	Anhaenger entkuppeln();

	boolean gekuppelt();
}
