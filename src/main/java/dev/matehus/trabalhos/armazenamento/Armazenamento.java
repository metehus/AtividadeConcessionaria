package dev.matehus.trabalhos.armazenamento;

import dev.matehus.trabalhos.data.Carro;
import dev.matehus.trabalhos.data.Motocicleta;

import java.util.List;

public interface Armazenamento {
	void salvarCarro(Carro carro);
	List<Carro> listarCarros();

	void salvarMotocicleta(Motocicleta moto);
	List<Motocicleta> listarMotocicletas();
}
