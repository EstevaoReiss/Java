package br.unip.sicc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.unip.sicc.model.GerenciadorDePersonagens;

public class TelaControlePersonagens extends JFrame implements WindowListener{

    private PainelCadastro painelCadastroPersonagem;
    private PainelBusca painelBuscaPersonagens;
    
    private GerenciadorDePersonagens gerenciador;

    //implementacao do padrao Singleton
    private static TelaControlePersonagens instance;
    
    private TelaControlePersonagens() {
        
        gerenciador = GerenciadorDePersonagens.getInstance();

        this.setTitle("Controle de Atividades");
        this.setSize(800, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(this);

        painelCadastroPersonagem = PainelCadastro.getInstance();
        painelBuscaPersonagens = PainelBusca.getInstance();

        this.add(painelCadastroPersonagem, BorderLayout.WEST);
        this.add(painelBuscaPersonagens, BorderLayout.CENTER);
        this.setJMenuBar(montaMenu());

        this.setVisible(true);

    }
    public static TelaControlePersonagens getInstance() {
        if (instance == null) {
            instance = new TelaControlePersonagens();
        }
        return instance;
    }
    //implementacao do padrao Singleton
   
    private JMenuBar montaMenu() {
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        menuCadastro.setMnemonic(KeyEvent.VK_T);
        JMenu menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic(KeyEvent.VK_A);
        JMenuItem itemNovo = new JMenuItem("Novo");
        itemNovo.setMnemonic(KeyEvent.VK_N);
        itemNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelCadastroPersonagem.setPersonagem(gerenciador.getNovoPersonagem());
            }
        });
        JMenuItem itemSobre = new JMenuItem("Sobre");
        itemSobre.setMnemonic(KeyEvent.VK_S);
        itemSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensagemSobre = "Software desenvolvido na disciplona ALPOO";
                JOptionPane.showMessageDialog(null, mensagemSobre,
                        "Sobre", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menuCadastro.add(itemNovo);
        menuAjuda.add(itemSobre);
        barraMenu.add(menuCadastro);
        barraMenu.add(menuAjuda);
        return barraMenu;
    }

 public static void main(String[] args) {

    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());

                TelaControlePersonagens.getInstance();

            } catch (ClassNotFoundException |
                     InstantiationException |
                     IllegalAccessException |
                     UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        }
    });
}

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e){
        System.out.println("Minimizou");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
