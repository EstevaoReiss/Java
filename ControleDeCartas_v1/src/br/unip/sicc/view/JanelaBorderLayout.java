package br.unip.sicc.view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JanelaBorderLayout extends JFrame implements WindowStateListener {
	
	private JPanel painelCadastro;
	private JPanel painelBusca;
	
	private JanelaBorderLayout() {
		
		painelCadastro = montaPainelCadastro();
		painelBusca = montaPainelBusca();
		
		this.add(painelCadastro, BorderLayout.WEST);
		this.add(painelBusca, BorderLayout.CENTER);
		
		// Monta a barra de menus
		this.setJMenuBar(montaMenu());
		
		// Título da janela
		this.setTitle("Controle de Cartas");
		
		// Tamanho da janela
		this.setSize(800, 300);
		
		// Encerramento da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowStateListener(this);
		
		// Centralizando a janela
		this.setLocationRelativeTo(null);
		
	}

	@Override
	public void windowStateChanged(WindowEvent evento) {
		if (evento.getNewState() == JFrame.ICONIFIED) {
			System.out.println("MINIZOU");
		}
	}
	
	private JPanel montaPainelBusca() {
		return new PainelBusca();
	}
	
	private JPanel montaPainelCadastro() {
		return new PainelCadastro();
	}
	
	private JMenuBar montaMenu() {
		
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setMnemonic(KeyEvent.VK_T);
		
		JMenuItem itemNovo = new JMenuItem("Novo");
		itemNovo.setMnemonic(KeyEvent.VK_N);
		
		menuCadastro.add(itemNovo);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem itemSobre = new JMenuItem("Sobre");
		itemSobre.setMnemonic(KeyEvent.VK_S);
		
		menuAjuda.add(itemSobre);
		
		barraMenu.add(menuCadastro);
		barraMenu.add(menuAjuda);
		
		return barraMenu;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new JanelaBorderLayout().setVisible(true);
		});
	}
}