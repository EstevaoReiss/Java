package br.unip.sicc.dao;

import java.sql.Connection;

public class TesteGerenciadorConexao {

    public static void main(String[] args) throws DadosException {
        Connection conexao = GerenciadorConexao.getConnection();

        if (conexao == null) {
            throw new DadosException("A conexão não foi criada");
        }

        GerenciadorConexao.fechar(conexao);
        System.out.println("Conexão aberta e fechada com sucesso.");
    }
}