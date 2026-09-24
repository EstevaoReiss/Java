package br.unip.sicc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GerenciadorConexao {

	private static final String SERVIDOR = "127.0.0.1";
	private static final String PORTA = "3306";
	private static final String BANCO_DADOS = "sakila";
	private static final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + BANCO_DADOS;
	private static final String USUARIO = "aluno";
	private static final String SENHA = "unip";

	private GerenciadorConexao() {
	}

	public static Connection getConnection() throws DadosException {
		try {
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DadosException("Não foi possivel conectar ao banco de dados", e);
		}
	}

	public static void fechar(Connection conexao) throws DadosException {
		try {
			conexao.close();
		} catch (SQLException e) {
			throw new DadosException("Não foi possivel desconectar ao banco de dados", e);
		}
	}

	public static void fechar(Connection conexao, Statement statement) throws DadosException {
		DadosException excecao = null;

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			excecao = new DadosException("Não foi possivel fechar o statement", e);
		}

		try {
			if (conexao != null) {
				conexao.close();
			}
		} catch (SQLException e) {
			if (excecao == null) {
				excecao = new DadosException("Não foi possivel desconectar ao banco de dados", e);
			}
		}

		if (excecao != null) {
			throw excecao;
		}
	}
}
