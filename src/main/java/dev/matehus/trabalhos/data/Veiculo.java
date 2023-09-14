package dev.matehus.trabalhos.data;

public class Veiculo {
	public String marca;
	public String modelo;
	public int anoLancamento;
	public double preco;

	@Override
	public String toString() {
		return "Marca: " + marca +
				", Modelo: " + modelo +
				", Ano de lançamento: " + anoLancamento +
				", Preço: " + preco;
	}
}
