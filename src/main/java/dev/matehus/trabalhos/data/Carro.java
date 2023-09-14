package dev.matehus.trabalhos.data;

public class Carro extends Veiculo {
	public int numeroDePortas;

	@Override
	public String toString() {
		return super.toString() + ", Numero de portas: " + numeroDePortas;
	}
}
