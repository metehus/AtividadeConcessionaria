package dev.matehus.trabalhos.data;

public class Motocicleta extends Veiculo {
	public int cilindradas;

	@Override
	public String toString() {
		return super.toString() + ", Cilindradas: " + cilindradas;
	}
}
