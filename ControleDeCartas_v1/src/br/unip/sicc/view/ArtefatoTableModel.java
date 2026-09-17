package br.unip.sicc.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.unip.sicc.model.Artefato;

public class ArtefatoTableModel extends AbstractTableModel{
	
	private List<Artefato> artefato;
	
	public ArtefatoTableModel(List<Artefato> artefato) {
		super();
		this.artefato = artefato;
	}
	
	@Override
	public int getRowCount() {
		return artefato.size();
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0: 
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Categoria";
		case 3:
			return "Força";
		}
		
		return "";
	}
	

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Artefato artefatoAtual =  artefato.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return artefatoAtual.getId();
		case 1:
			return artefatoAtual.getNome();
		case 2:
			return artefatoAtual.getCategoria();
		case 3:
			return artefatoAtual.getForca();
		}
		return null;
	}
		
	Artefato getArtefato(int index) {
		return artefato.get(index);
	}
	
	void setArtefato(List<Artefato> artefato) {
		this.artefato = artefato;
		fireTableDataChanged();
	}

}