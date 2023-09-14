package dev.matehus.trabalhos;

import dev.matehus.trabalhos.armazenamento.Armazenamento;
import dev.matehus.trabalhos.data.Carro;
import dev.matehus.trabalhos.data.Motocicleta;
import dev.matehus.trabalhos.data.Veiculo;

import java.util.List;

public class Concessionaria {
	private Armazenamento armazenamento;

	public Concessionaria(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public void salvarVeiculo(Veiculo veiculo) {
		if (veiculo instanceof Carro) {
			armazenamento.salvarCarro((Carro)veiculo);
		} else if (veiculo instanceof Motocicleta) {
			armazenamento.salvarMotocicleta((Motocicleta)veiculo);
		}
	}

	public void listarVeiculos() {
		List<Carro> carros = armazenamento.listarCarros();

		System.out.println("* Carros *");
		for (Carro carro : carros) {
			System.out.println(carro.toString());
		}

		List<Motocicleta> motos = armazenamento.listarMotocicletas();

		System.out.println("* Motocicletas *");
		for (Motocicleta motocicleta : motos) {
			System.out.println(motocicleta.toString());
		}
	}
}
