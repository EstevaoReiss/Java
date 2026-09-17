package br.unip.sicc.dao;

import java.util.ArrayList;
import java.util.List;

import br.unip.sicc.model.Artefato;
import br.unip.sicc.model.Categoria;
import br.unip.sicc.model.Classe;
import br.unip.sicc.model.Personagem;

public class ArtefatoList {
	// Aqui é uma lista onde todos os itens ficam guardados
	private List<Artefato> artefatos;
	// Aqui é um contador, ou seja, cada vez que um novo item entra na lista de artefato ele adiciona +1 no contador
	private static long contador = 1;
	

	// CONSTRUCTOR
	public ArtefatoList() {
	// A lista de artefatos é instanciado nesse construtor com alguns itens ja criados dentro dele
		artefatos = new ArrayList<>();
	// Aqui vamos adicionar alguns itens dentro desse ArrayList(Lista de artefatos)
		artefatos.add(new Artefato(contador++, "Espada Magica", Categoria.Ataque, 5));
		artefatos.add(new Artefato(contador++, "Escudo de Madeira", Categoria.Defesa, 6));
		artefatos.add(new Artefato(contador++, "Espada Justiceira", Categoria.Ataque, 5));
		artefatos.add(new Artefato(contador++, "Barril", Categoria.Defesa, 5));
		artefatos.add(new Artefato(contador++, "Veneno", Categoria.Pocao, 5));

	}
	
	public void incluir(Artefato artefato) throws DadosException{
        if (artefato != null) {
        	artefato.setId(contador++);
        	artefatos.add(artefato);
        } else {
			throw new DadosException("Artefato nulo");
        }		
	}

	public void atualizar(Artefato artefato) throws DadosException {
        if (artefato != null) {
            for (Artefato artefatoAtual : artefatos) {
                if (artefatoAtual.getId() == artefato.getId()) {
                    int indice = artefatos.indexOf(artefatoAtual);
                    artefatos.set(indice, artefato);
                    break;
                }
            }
        } else {
			throw new DadosException("Artefato nulo");
		}
	}

	public void excluir(Artefato artefato) throws DadosException {
		if (artefato != null) {
			artefatos.remove(artefato);
		} else {
			throw new DadosException("Artefato nulo");
		}
	}

	public Artefato getPorId(Long id) throws DadosException {
		Artefato artefato = null;
		for (Artefato artefatoAtual : artefatos) {
			if (artefatoAtual.getId() == id) {
				artefato = artefatoAtual;
				break;
			}
		}
		return artefato;
	}

	public List<Artefato> getPorCategoria(Categoria categoria) throws DadosException {
		List<Artefato> artefatosFiltrados = new ArrayList<>();
		for (Artefato artefato : artefatos) {
			if (artefato.getCategoria() == categoria) {
				artefatosFiltrados.add(artefato);
			}
		}
		return artefatosFiltrados;
	}

	public List<Artefato> getTodos() throws DadosException {
		return artefatos;
	}
}