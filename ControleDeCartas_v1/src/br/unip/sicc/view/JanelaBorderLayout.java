package br.unip.sicc.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JanelaBorderLayout extends JFrame {
	
	private JPanel painelCadastro;
	private JPanel painelBusca;
	
	private JanelaBorderLayout() {
		
		painelCadastro = montaPainelCadastro();
		painelBusca = montaPainelBusca();
		
		this.add(painelCadastro, BorderLayout.WEST);
		this.add(painelBusca, BorderLayout.CENTER);
		
		// titulo da janela;
		this.setTitle("Controle de Cartas");
		// tamanho da janela;
		this.setSize(800, 300);
		//encerramento da janela;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Centralizando a Janela ;
		this.setLocationRelativeTo(null);
		
	}
	
	private JPanel montaPainelBusca() {

		
		return new PainelBusca();
	}
	
	
	private JPanel montaPainelCadastro() {
	
		return new PainelCadastro();
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new JanelaBorderLayout().setVisible(true);
		});
	}
	
	
	
}