package dev.matehus.trabalhos;

import dev.matehus.trabalhos.armazenamento.Armazenamento;
import dev.matehus.trabalhos.armazenamento.Arquivo;
import dev.matehus.trabalhos.armazenamento.BancoDeDados;
import dev.matehus.trabalhos.data.Carro;
import dev.matehus.trabalhos.data.Motocicleta;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Armazenamento armazenamento = new BancoDeDados();
		Concessionaria concessionaria = new Concessionaria(armazenamento);

		Carro carro = Main.criarCarro();
		concessionaria.salvarVeiculo(carro);

		Motocicleta moto = Main.criarMoto();
		concessionaria.salvarVeiculo(moto);

		concessionaria.listarVeiculos();
	}

	public static Carro criarCarro() {
		var carro = new Carro();
		var random = new Random();

		carro.modelo = "Modelo " + random.nextInt(200);
		carro.marca = "Marca " + random.nextInt(200);
		carro.anoLancamento = 2000;
		carro.preco = random.nextDouble(200000);
		carro.numeroDePortas = 4;

		return carro;
	}

	public static Motocicleta criarMoto() {
		var moto = new Motocicleta();
		var random = new Random();

		moto.modelo = "Modelo " + random.nextInt(200);
		moto.marca = "Marca " + random.nextInt(200);
		moto.anoLancamento = 2000;
		moto.preco = random.nextDouble(200000);
		moto.cilindradas = random.nextInt(40);

		return moto;
	}
}