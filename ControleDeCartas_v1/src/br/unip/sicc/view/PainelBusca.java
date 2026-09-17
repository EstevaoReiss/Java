package br.unip.sicc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import br.unip.sicc.dao.ArtefatoList;
import br.unip.sicc.model.Artefato;

public class PainelBusca extends JPanel {
	private JLabel lblFiltro;
	private JComboBox cboFiltro;
	private JButton btnFiltro, btnSelecionar, btnExcluir;
	private JTable tabela;
	private JScrollPane scroll;
	private ArtefatoTableModel artefato;
	private ArtefatoList artefatoList;
	
	private JPanel painelFiltro;
	private JPanel painelTabela;
	private JPanel painelBotoes;
	
	PainelBusca(){
		this.setLayout(new BorderLayout());
		
		
		painelFiltro = montaPainelFiltro();
		painelTabela = montaPainelTabela();
		painelBotoes = montaPainelBotoes();
		
		this.add(painelFiltro, BorderLayout.NORTH);
		this.add(painelTabela, BorderLayout.CENTER);
		this.add(painelBotoes, BorderLayout.SOUTH);

		
	}
	
	private JPanel montaPainelFiltro() {
		JPanel painelFiltro = new JPanel();
		
		lblFiltro = new JLabel("Tipo");
		cboFiltro = new JComboBox();
		btnFiltro = new JButton("Buscar");
		btnFiltro.setMnemonic(KeyEvent.VK_B);
		
		painelFiltro.add(lblFiltro);
		painelFiltro.add(cboFiltro);
		painelFiltro.add(btnFiltro);
		
		return painelFiltro;
	}
	
	private JPanel montaPainelTabela() {
		JPanel painelTabela = new JPanel();
		try {
			// Aqui estamos chamando aquela lista com todos os artefatos cadastrados manualmente.
			List<Artefato> artefatoList = new ArtefatoList().getTodos();
			
			// Aqui estamos passando a lista para que a tabela consiga entender essa lista e guardamos isso no atributo da classe(this.artefato) para que conseguimos atualizar e excluir
			this.artefato = new ArtefatoTableModel(artefatoList);
			
			// Aqui passamos para a tabela todos os artefatos para ela conseguir desenhar no painel
			tabela = new JTable(this.artefato);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			tabela = new JTable();

		}
		
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroll = new JScrollPane(tabela);
		
		painelTabela.add(scroll);

		return painelTabela;
	}
	
	private JPanel montaPainelBotoes() {
		JPanel painelBotoes = new JPanel();
		
		painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));


		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setMnemonic(KeyEvent.VK_S);
		btnExcluir = new JButton("Excluir");
		btnExcluir.setMnemonic(KeyEvent.VK_X);
		
		painelBotoes.add(btnSelecionar);
		painelBotoes.add(btnExcluir);
		
		return painelBotoes;
	}
}