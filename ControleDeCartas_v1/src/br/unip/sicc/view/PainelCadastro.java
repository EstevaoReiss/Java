package br.unip.sicc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PainelCadastro extends JPanel  implements ActionListener{
	private JLabel lblId;
	private JLabel lblNome;
	private JTextField txtId;
	private JTextField txtNome;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	private JPanel painelCadastro;
	private JPanel painelBotao;
	private static PainelCadastro painelCadastro1;

	 private PainelCadastro() {
		this.setLayout(new BorderLayout());
		
		painelCadastro = montaPainelCadastro();
		painelBotao = montaPainelBotao();
		 
		this.add(painelCadastro, BorderLayout.NORTH);
		this.add(painelBotao, BorderLayout.SOUTH);
	}
	
	public static PainelCadastro getInstance(){
		if(painelCadastro1 == null){
			painelCadastro1 = new PainelCadastro();
		
		}else{
			System.out.println("PainelCadastro já instanciado");
		}
		return painelCadastro1;
	}
	
	private JPanel montaPainelCadastro() {
		JPanel painelCadastro = new JPanel();

		DestacaFocoText destacaFoco = new DestacaFocoText();
	
		painelCadastro.setLayout(new GridLayout(2, 2));
		
		lblId = new JLabel("id");
		txtId = new JTextField();
		txtId.setEnabled(true);
		lblNome = new JLabel("Nome");
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.addFocusListener(destacaFoco);
		
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

		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("simulando cancelar");
			}
		});
		
		return painelBotao;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
		btnSalvar.setEnabled(false);

		Thread threadDemorada = new Thread(new SalvarPersonagem());
		threadDemorada.start();
    }

	private class SalvarPersonagem implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println("iniciando salvamento");
				Thread.sleep(10000);
				System.out.println("salvamento concluido");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						btnSalvar.setEnabled(true);
					}
				});
			}
		}
	}

	
}