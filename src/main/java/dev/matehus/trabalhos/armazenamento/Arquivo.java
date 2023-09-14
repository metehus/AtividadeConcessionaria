package dev.matehus.trabalhos.armazenamento;

import dev.matehus.trabalhos.data.Carro;
import dev.matehus.trabalhos.data.Motocicleta;
import dev.matehus.trabalhos.data.Veiculo;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Arquivo implements Armazenamento {
	private File file = new File("dados.txt");
	private List<Carro> carros = new ArrayList<>();
	private List<Motocicleta> motos = new ArrayList<>();

	public Arquivo() {
		criarArquivo();
		lerArquivo();
	}

	private void criarArquivo() {
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Arquivo dados.txt criado");
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	private void lerArquivo() {
		try {
			Scanner scanner = new Scanner(file);

			String tipo = null;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.equals("[CARROS]")) {
					tipo = "carro";
				} else if (line.equals("[MOTOS]")) {
					tipo = "moto";
				} else if (tipo != null){
					Veiculo veiculo;
					String[] split = line.split(",");

					if (tipo.equals("carro")) {
						Carro carro = new Carro();
						veiculo = carro;
						carros.add(carro);

						carro.numeroDePortas = Integer.parseInt(split[4]);
					} else {
						Motocicleta moto = new Motocicleta();
						veiculo = moto;
						motos.add(moto);

						moto.cilindradas = Integer.parseInt(split[4]);
					}

					veiculo.marca = split[0];
					veiculo.modelo = split[1];
					veiculo.anoLancamento = Integer.parseInt(split[2]);
					veiculo.preco = Double.parseDouble(split[3]);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private String serializaVeiculo(Veiculo veiculo) {
		return veiculo.marca + "," + veiculo.modelo + "," + veiculo.anoLancamento + "," + veiculo.preco;
	}

	private void salvarDados() {
		try {
			List<String> lines = new ArrayList<>();

			lines.add("[CARROS]");

			for (Carro carro : carros) {
				lines.add(serializaVeiculo(carro) + "," + carro.numeroDePortas);
			}

			lines.add("[MOTOS]");

			for (Motocicleta moto : motos) {
				lines.add(serializaVeiculo(moto) + "," + moto.cilindradas);
			}

			FileWriter fw = new FileWriter(file);

			fw.write(String.join("\n", lines));
			fw.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void salvarCarro(Carro carro) {
		carros.add(carro);
		salvarDados();
	}

	@Override
	public List<Carro> listarCarros() {
		return carros;
	}

	@Override
	public void salvarMotocicleta(Motocicleta moto) {
		motos.add(moto);
		salvarDados();
	}

	@Override
	public List<Motocicleta> listarMotocicletas() {
		return motos;
	}
}
