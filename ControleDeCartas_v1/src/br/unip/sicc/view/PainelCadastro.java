package br.unip.sicc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCadastro extends JPanel {
	private JLabel lblId;
	private JLabel lblNome;
	private JTextField txtId;
	private JTextField txtNome;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	private JPanel painelCadastro;
	private JPanel painelBotao;
	
	 PainelCadastro() {
		this.setLayout(new BorderLayout());
		
		painelCadastro = montaPainelCadastro();
		painelBotao = montaPainelBotao();
		 
		this.add(painelCadastro, BorderLayout.NORTH);
		this.add(painelBotao, BorderLayout.SOUTH);
	}
	
	
	private JPanel montaPainelCadastro() {
		JPanel painelCadastro = new JPanel();
	
		painelCadastro.setLayout(new GridLayout(2, 2));
		
		lblId = new JLabel("id");
		txtId = new JTextField();
		txtId.setEnabled(false);
		lblNome = new JLabel("Nome");
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		painelCadastro.add(lblId);
		painelCadastro.add(txtId);
		painelCadastro.add(lblNome);
		painelCadastro.add(txtNome);
		
		
		return painelCadastro;
	}
	
	private JPanel montaPainelBotao() {
		JPanel painelBotao = new JPanel();
		
		painelBotao.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnSalvar = new JButton("Salvar");
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		
		painelBotao.add(btnCancelar);
		painelBotao.add(btnSalvar);
		
		return painelBotao;
	}
}