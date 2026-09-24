package br.unip.sicc.dao;

import br.unip.sicc.model.Artefato;
import br.unip.sicc.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArtefatoJdbc implements ArtefatoDao {

    private static final String SQL_DELETE
            = "DELETE FROM TB_ARTEFATO WHERE ID = ?;";

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
    }

    @Override
    public void incluir(Artefato artefato) throws DadosException {
    }

    @Override
    public Artefato getPorId(Long id) throws DadosException {
        return null;
    }

    @Override
    public java.util.List<Artefato> getPorCategoria(Categoria categoria) throws DadosException {
        return null;
    }

    @Override
    public java.util.List<Artefato> getTodos() throws DadosException {
        return null;
    }
}
