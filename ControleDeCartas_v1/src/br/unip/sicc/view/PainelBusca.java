package br.unip.sicc.view;

import br.unip.sicc.dao.ArtefatoList;
import br.unip.sicc.model.Artefato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

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
    private static PainelBusca painelBusca;
    
    private PainelBusca(){
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
            List<Artefato> artefatoList = new ArtefatoList().getTodos();
            this.artefato = new ArtefatoTableModel(artefatoList);
            tabela = new JTable(this.artefato);
        } catch(Exception e) {
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

        // adicionando do ícone de seleção
        URL urlCheck = PainelBusca.class.getResource("/br/unip/sicc/resource/check.png");
        Icon iconeCheck = new ImageIcon(urlCheck);
        btnSelecionar = new JButton("Selecionar", iconeCheck);
        btnSelecionar.setMnemonic(KeyEvent.VK_S);

        // adicionando ícone de exclusão
        URL urlDelete = PainelBusca.class.getResource("/br/unip/sicc/resource/delete.png");
        Icon iconeDelete = new ImageIcon(urlDelete);
        btnExcluir = new JButton("Excluir", iconeDelete);
        btnExcluir.setMnemonic(KeyEvent.VK_X);
        
        painelBotoes.add(btnSelecionar);
        painelBotoes.add(btnExcluir);
        
        return painelBotoes;
    }

    public static PainelBusca getInstance(){
        if(painelBusca == null){
            painelBusca = new PainelBusca();
        }else{
            System.out.println("PainelBusca já instanciado");
        }
        return painelBusca;
    }
}