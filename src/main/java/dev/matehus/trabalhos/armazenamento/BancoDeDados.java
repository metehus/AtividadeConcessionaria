package dev.matehus.trabalhos.armazenamento;

import dev.matehus.trabalhos.data.Carro;
import dev.matehus.trabalhos.data.Motocicleta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados implements Armazenamento {
	Connection connection;
	public BancoDeDados() {
		conectar();
	}

	void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:banco.db");

			criarTabelas();
		} catch (Exception exception) {
			System.out.println("Erro ao conectar ao banco");
			exception.printStackTrace();
		}
	}

	private void criarTabelas() {
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS carros (id INTEGER PRIMARY KEY AUTOINCREMENT, marca STRING, modelo STRING, ano INTEGER, preco DOUBLE PRECISION, numeroPortas INTEGER)");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS motos (id INTEGER PRIMARY KEY AUTOINCREMENT, marca STRING, modelo STRING, ano INTEGER, preco DOUBLE PRECISION, cilindradas INTEGER)");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void salvarCarro(Carro carro) {
		try {
			var stt = connection.prepareStatement("INSERT INTO carros (marca, modelo, ano, preco, numeroPortas) VALUES (?, ?, ?, ?, ?)");
			stt.setString(1, carro.marca);
			stt.setString(2, carro.modelo);
			stt.setInt(3, carro.anoLancamento);
			stt.setDouble(4, carro.preco);
			stt.setInt(5, carro.numeroDePortas);

			stt.executeUpdate();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public List<Carro> listarCarros() {
		try {
			var stt = connection.createStatement();
			var result = stt.executeQuery("SELECT * FROM carros");

			var carros = new ArrayList<Carro>();

			while (result.next()) {
				var carro = new Carro();
				carro.marca = result.getString("marca");
				carro.modelo = result.getString("modelo");
				carro.anoLancamento = result.getInt("ano");
				carro.preco = result.getDouble("preco");
				carro.numeroDePortas = result.getInt("numeroPortas");
				carros.add(carro);
			}
			return carros;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	@Override
	public void salvarMotocicleta(Motocicleta moto) {
		try {
			var stt = connection.prepareStatement("INSERT INTO motos (marca, modelo, ano, preco, cilindradas) VALUES (?, ?, ?, ?, ?)");
			stt.setString(1, moto.marca);
			stt.setString(2, moto.modelo);
			stt.setInt(3, moto.anoLancamento);
			stt.setDouble(4, moto.preco);
			stt.setInt(5, moto.cilindradas);

			stt.executeUpdate();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public List<Motocicleta> listarMotocicletas() {
		try {
			var stt = connection.createStatement();
			var result = stt.executeQuery("SELECT * FROM motos");

			var motos = new ArrayList<Motocicleta>();

			while (result.next()) {
				var moto = new Motocicleta();
				moto.marca = result.getString("marca");
				moto.modelo = result.getString("modelo");
				moto.anoLancamento = result.getInt("ano");
				moto.preco = result.getDouble("preco");
				moto.cilindradas = result.getInt("cilindradas");
				motos.add(moto);
			}
			return motos;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
}
