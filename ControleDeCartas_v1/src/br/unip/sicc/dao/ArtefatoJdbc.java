package br.unip.sicc.dao;

import br.unip.sicc.model.Artefato;
import br.unip.sicc.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtefatoJdbc implements ArtefatoDao {

    private static final String SQL_DELETE
            = "DELETE FROM TB_ARTEFATO WHERE ID = ?;";
    private static final String SQL_INSERT
            = "INSERT INTO TB_ARTEFATO (NOME, CATEGORIA, NOME_IMAGEM, FORCA) "
            + "VALUES (?, ?, ?, ?);";
    private static final String SQL_UPDATE
            = "UPDATE TB_ARTEFATO SET NOME = ?, CATEGORIA = ? , NOME_IMAGEM = ? , FORCA = ? WHERE ID = ?;";
    private static final String SQL_SELECT_ALL
            = "SELECT ID, NOME, CATEGORIA, NOME_IMAGEM, FORCA FROM TB_ARTEFATO;";
    private static final String SQL_SELECT_BY_ID
            = "SELECT ID, NOME, CATEGORIA, NOME_IMAGEM, FORCA FROM TB_ARTEFATO WHERE ID = ?;";
        private static final String SQL_SELECT_BY_CATEGORY
            = "SELECT ID, NOME, CATEGORIA, NOME_IMAGEM, FORCA FROM TB_ARTEFATO WHERE CATEGORIA = ?;";

    @Override
    public void excluir(Artefato artefato) throws DadosException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = GerenciadorConexao.getConnection();
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, artefato.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DadosException("Não foi possível excluir", e);
        } finally {
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    @Override
    public void atualizar(Artefato artefato) throws DadosException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = GerenciadorConexao.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, artefato.getNome());
            statement.setString(2, artefato.getCategoria().name());
            statement.setString(3, artefato.getNomeImagem());
            statement.setInt(4, artefato.getForca());
            statement.setLong(5, artefato.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DadosException("Não foi possível atualizar", e);
        } finally {
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    @Override
    public void incluir(Artefato artefato) throws DadosException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = GerenciadorConexao.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, artefato.getNome());
            statement.setString(2, artefato.getCategoria().name());
            statement.setString(3, artefato.getNomeImagem());
            statement.setInt(4, artefato.getForca());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DadosException("Não foi possível incluir", e);
        } finally {
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    @Override
    public Artefato getPorId(Long id) throws DadosException {
        Artefato artefato = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = GerenciadorConexao.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                artefato = new Artefato();
                artefato.setId(resultSet.getLong("ID"));
                artefato.setNome(resultSet.getString("NOME"));
                artefato.setCategoria(Categoria.valueOf(resultSet.getString("CATEGORIA")));
                artefato.setNomeImagem(resultSet.getString("NOME_IMAGEM"));
                artefato.setForca(resultSet.getInt("FORCA"));
            }
        } catch (SQLException e) {
            throw new DadosException("Não foi possível selecionar", e);
        } finally {
            GerenciadorConexao.fechar(connection, statement, resultSet);
        }

        return artefato;
    }

    @Override
    public List<Artefato> getPorCategoria(Categoria categoria) throws DadosException {
        List<Artefato> artefatos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = GerenciadorConexao.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_CATEGORY);
            statement.setString(1, categoria.name());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Artefato artefato = new Artefato();
                artefato.setId(resultSet.getLong("ID"));
                artefato.setNome(resultSet.getString("NOME"));
                artefato.setCategoria(Categoria.valueOf(resultSet.getString("CATEGORIA")));
                artefato.setNomeImagem(resultSet.getString("NOME_IMAGEM"));
                artefato.setForca(resultSet.getInt("FORCA"));
                artefatos.add(artefato);
            }
        } catch (SQLException e) {
            throw new DadosException("Não foi possível selecionar", e);
        } finally {
            GerenciadorConexao.fechar(connection, statement, resultSet);
        }

        return artefatos;
    }

    @Override
    public List<Artefato> getTodos() throws DadosException {
        List<Artefato> artefatos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = GerenciadorConexao.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Artefato artefato = new Artefato();
                artefato.setId(resultSet.getLong("ID"));
                artefato.setNome(resultSet.getString("NOME"));
                artefato.setCategoria(Categoria.valueOf(resultSet.getString("CATEGORIA")));
                artefato.setNomeImagem(resultSet.getString("NOME_IMAGEM"));
                artefato.setForca(resultSet.getInt("FORCA"));
                artefatos.add(artefato);
            }
        } catch (SQLException e) {
            throw new DadosException("Não foi possível selecionar", e);
        } finally {
            GerenciadorConexao.fechar(connection, statement, resultSet);
        }

        return artefatos;
    }
}
