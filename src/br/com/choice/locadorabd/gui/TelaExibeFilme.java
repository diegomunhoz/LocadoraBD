package br.com.choice.locadorabd.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por controlar tela de consulta de FILME
 * 
 * @author Diego Munhoz
 * @since 21/02/2014
 */

public class TelaExibeFilme {

	private JFrame janelaExibeFilme;
	private JPanel painelDaJanelaExibeFilme;
	private JTable tabelaFilme;
	private JButton btnSair;

	private String codigoFilme;
	private String nomeFilme;
	private String valorFilme;
	private String disponivelFilme;
	private String valorPromocionalFilme;
	private String promocaoFilme;

	private JScrollPane painelDeScroll;

	private String[] colunas = new String[] { "Código", "Nome", "Valor",
			"Disponível", "Promoção", "Valor Promocional" };
	private String[][] dados = new String[][] { {} };

	private String nomeArquivo = "saidaFilme.txt";

	public TelaExibeFilme() {
		iniciaTelaExibeFilme();
	}

	public void iniciaTelaExibeFilme() {

		janelaExibeFilme = new JFrame("CONSULTA DE FILMES");
		btnSair = new JButton("SAIR");

		painelDaJanelaExibeFilme = (JPanel) janelaExibeFilme.getContentPane();
		painelDaJanelaExibeFilme.setLayout(null);

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tabelaFilme = new JTable(modelo);

		tabelaFilme.setEnabled(false);

		painelDeScroll = new JScrollPane(tabelaFilme);
		painelDeScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		painelDeScroll.setBounds(0, 0, 560, 310);
		tabelaFilme.setBounds(0, 0, 500, 310);
		btnSair.setBounds(190, 320, 150, 30);

		painelDaJanelaExibeFilme.add(painelDeScroll);
		painelDaJanelaExibeFilme.add(btnSair);

		listarFilme();

		btnSair.addActionListener(new SairFrameListener());

		janelaExibeFilme.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaExibeFilme.setSize(575, 400);
		janelaExibeFilme.setLocationRelativeTo(null);
		janelaExibeFilme.setVisible(true);

	}

	public class SairFrameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			janelaExibeFilme.setVisible(false);
		}
	}

	public void listarFilme() {
		try {
			Scanner leitor = new Scanner(new FileReader(nomeArquivo));
			DefaultTableModel m = (DefaultTableModel) tabelaFilme.getModel();
			m.removeRow(0);
			while (leitor.hasNext()) {
				codigoFilme = leitor.nextLine();
				nomeFilme = leitor.nextLine();
				valorFilme = leitor.nextLine();
				disponivelFilme = leitor.nextLine();
				promocaoFilme = leitor.nextLine();
				valorPromocionalFilme = leitor.nextLine();
				DefaultTableModel modelo = (DefaultTableModel) tabelaFilme
						.getModel();
				modelo.addRow(new String[] { codigoFilme, nomeFilme,
						valorFilme, disponivelFilme, promocaoFilme, valorPromocionalFilme});
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de entrada não encontrado");
		}
	}

}// fim da classe