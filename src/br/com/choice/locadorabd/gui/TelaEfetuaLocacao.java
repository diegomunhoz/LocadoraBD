package br.com.choice.locadorabd.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.choice.locadorabd.model.Filme;


/**
 * Classe responsável por efetuar locação de FILME 
 * @author Diego Munhoz
 * @since 21/02/2014
 */

public class TelaEfetuaLocacao {
	
	List<Filme> arrayListFilme = new ArrayList<Filme>();
	List<Filme> arrayListFilmeLocado = new ArrayList<Filme>();
	
	private JFrame janelaLocacao;
	private JPanel painelDaJanelaLocacao;

	private JTable tabelaFilme;
	
	private JScrollPane painelDeScroll;

	private JLabel jlbNomeFilme;
	private JLabel jlbNomeVendedor;
	private JLabel jlbFormaPagamento;
	private JLabel jlbValorTotalFilme;
	private JLabel jlbValorPagoFilme;
	private JLabel jlbValorTrocoFilme;
	
	private JTextField jtfValorTotalFilme;
	private JTextField jtfValorPagoFilme;
	private JTextField jtfValorTrocoFilme;
	
	private JRadioButton rbtDinheiro;
	private JRadioButton rbtCheque;
	private JRadioButton rbtDebito;
	private JRadioButton rbtCredito;
	private ButtonGroup grpRadio;
	
	private JButton btnIncluirFilme;
	private JButton btnSalvarLocacao;
	private JButton btnCancelarLocacao;

	private JComboBox cboxFilme;
	private String[] filmeComps = {};

	private JComboBox cboxVendedor;
	private String[] vendedorComps = {};

	private String nomeVendedorEntrada = "";
	private String nomeVendedorSaida = "";

	private String disponivelFilme;
	private String promocaoFilme;

	private double valorTotalFilme;
	private String formaPagamento = "";
	private boolean validaLocacao = false;

	private String[] colunas = new String[] { "Código", "Nome", "Valor",
			"Disponível", "Promoção", "Valor Promocional" };
	private String[][] dados = new String[][] { {} };

	public TelaEfetuaLocacao() {
		iniciaLocacao();
	}

	public void iniciaLocacao(){

		janelaLocacao = new JFrame("LOCAÇÃO DE FILME");
		janelaLocacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaLocacao.setSize(700,450);

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tabelaFilme = new JTable(modelo);
		modelo.removeRow(0);

		painelDeScroll = new JScrollPane(tabelaFilme);
		painelDeScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		jlbNomeFilme = new JLabel("Nome do Filme:");
		jlbNomeVendedor = new JLabel("Nome do Vendedor:");
		jlbFormaPagamento = new JLabel("Forma de Pagamento:");
		
		jlbValorTotalFilme = new JLabel("Valor Total:");
		jlbValorPagoFilme = new JLabel("Valor Pago:");
		jlbValorTrocoFilme = new JLabel("Troco:");
		
		jtfValorTotalFilme = new JTextField("R$ 0,00");
		jtfValorPagoFilme = new JTextField("");
		jtfValorTrocoFilme = new JTextField("R$ 0,00");
		
		rbtDinheiro = new JRadioButton();
		rbtCheque = new JRadioButton();
		rbtDebito = new JRadioButton();
		rbtCredito = new JRadioButton();

		grpRadio = new ButtonGroup();

		cboxVendedor = new JComboBox(vendedorComps);
		cboxFilme = new JComboBox(filmeComps);
		
		btnIncluirFilme = new JButton("INCLUIR");
		btnSalvarLocacao = new JButton("SALVAR");
		btnCancelarLocacao = new JButton("CANCELAR");
		
		rbtDinheiro.setText("Dinheiro");
		rbtCheque.setText("Cheque");
		rbtDebito.setText("Débito");
		rbtCredito.setText("Crédito");

		jlbNomeVendedor.setBounds(10, 20, 150, 30);
		jlbNomeFilme.setBounds(10, 60, 150, 30);
		jlbFormaPagamento.setBounds(10, 250, 150, 30);
		
		jlbValorTotalFilme.setBounds(380, 250, 150, 30);
		jlbValorPagoFilme.setBounds(380, 275, 150, 30);
		jlbValorTrocoFilme.setBounds(380, 300, 150, 30);
		
		jtfValorTotalFilme.setBounds(460, 250, 150, 30);
		jtfValorPagoFilme.setBounds(460, 275, 150, 30);
		jtfValorTrocoFilme.setBounds(460, 300, 150, 30);

		cboxVendedor.setBounds(160, 20,500, 30);
		cboxFilme.setBounds(160, 60, 360, 30);

		painelDeScroll.setBounds(0, 110, 685, 135);
		tabelaFilme.setBounds(0, 110, 685, 135);

		rbtDinheiro.setBounds(160, 255, 100, 24);
		rbtCheque.setBounds(160, 280, 100, 24);
		rbtDebito.setBounds(160, 305, 100, 24);
		rbtCredito.setBounds(160, 330, 146, 24);
		
		btnIncluirFilme.setBounds(540, 60, 120, 30);
		btnSalvarLocacao.setBounds(220, 370, 120, 30);
		btnCancelarLocacao.setBounds(350, 370, 120, 30);

		grpRadio.add(rbtDinheiro);
		grpRadio.add(rbtCheque);
		grpRadio.add(rbtDebito);
		grpRadio.add(rbtCredito);

		tabelaFilme.setEnabled(false);

		painelDaJanelaLocacao = (JPanel) janelaLocacao.getContentPane();
		painelDaJanelaLocacao.setLayout(null);
		
		cboxVendedor.setSelectedIndex(-1);
		cboxFilme.setSelectedIndex(-1);

		painelDaJanelaLocacao.add(painelDeScroll);
		painelDaJanelaLocacao.add(jlbNomeFilme);
		painelDaJanelaLocacao.add(jlbNomeVendedor);
		painelDaJanelaLocacao.add(jlbFormaPagamento);
		painelDaJanelaLocacao.add(jlbValorTotalFilme);
		painelDaJanelaLocacao.add(jlbValorPagoFilme);
		painelDaJanelaLocacao.add(jlbValorTrocoFilme);
		painelDaJanelaLocacao.add(jtfValorTotalFilme);
		painelDaJanelaLocacao.add(jtfValorPagoFilme);
		painelDaJanelaLocacao.add(jtfValorTrocoFilme);
		painelDaJanelaLocacao.add(cboxFilme);
		painelDaJanelaLocacao.add(cboxVendedor);
		painelDaJanelaLocacao.add(rbtDinheiro);
		painelDaJanelaLocacao.add(rbtCheque);
		painelDaJanelaLocacao.add(rbtDebito);
		painelDaJanelaLocacao.add(rbtCredito);
		painelDaJanelaLocacao.add(btnSalvarLocacao);
		painelDaJanelaLocacao.add(btnCancelarLocacao);
		painelDaJanelaLocacao.add(btnIncluirFilme);
		
		listarFilme();
		listarVendedor();
		
		btnCancelarLocacao.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				janelaLocacao.setVisible(false);
			}
		});
		
		btnSalvarLocacao.addActionListener(new SalvarLocacaoListener());
		btnIncluirFilme.addActionListener(new ListenerBotaoIncluir());

		janelaLocacao.setLocationRelativeTo(null);
		janelaLocacao.setVisible(true);
	}
	
	public void listarFilme() {
		cboxFilme.addItem("-Selecione um Filme-");
		try {
			Scanner leitor = new Scanner(new FileReader("saidaFilme.txt"));
			while (leitor.hasNext()) {
				Filme filme = new Filme();
				filme.setCodigo(Integer.parseInt(leitor.nextLine()));
				filme.setNome(leitor.nextLine()); 
				filme.setValor(Double.parseDouble(leitor.nextLine()));
				if (leitor.nextLine().equals("SIM") ) {
					filme.setDisponivel(true);
				}else {
					filme.setDisponivel(false);
				}
				if (leitor.nextLine().equals("SIM") ) {
					filme.setPromocao(true);
				}else {
					filme.setPromocao(false);
				}
				filme.setValorPromocao(Double.parseDouble(leitor.nextLine()));
				cboxFilme.addItem(filme.getNome());
				arrayListFilme.add(filme);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de entrada não encontrado");
		}
	}
	
	public void listarVendedor() {
		cboxVendedor.addItem("-Selecione um Vendedor-");
		try {
			Scanner leitor = new Scanner(new FileReader("saidaVendedor.txt"));
			while (leitor.hasNext()) {
				nomeVendedorEntrada = leitor.nextLine();
				leitor.nextLine();
				leitor.nextLine();
				leitor.nextLine();
				leitor.nextLine();
				leitor.nextLine();
				leitor.nextLine();
				cboxVendedor.addItem(nomeVendedorEntrada);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de entrada não encontrado");
		}
	}

	/**
	 * Método para adicionar uma linha na JTable
	 */
	public void adicionaLinha() {
		DefaultTableModel modelo = (DefaultTableModel) tabelaFilme.getModel();
		for (Filme f : arrayListFilme) {
			if (cboxFilme.getSelectedItem().equals(f.getNome())) {
				if (f.isDisponivel() == true) {
					this.disponivelFilme = "SIM";
				} else {
					this.disponivelFilme = "NAO";
				}
				if (f.isPromocao() == true) {
					this.promocaoFilme = "SIM";
					valorTotalFilme = valorTotalFilme + f.getValorPromocao();
				} else {
					this.promocaoFilme = "NAO";
					valorTotalFilme = valorTotalFilme + f.getValor();
				}
				arrayListFilmeLocado.add(f);
				modelo.addRow(new String[] { "" + f.getCodigo(),
						f.getNome().toUpperCase(), "R$ " + f.getValor(),
						this.disponivelFilme, this.promocaoFilme,
						"R$ " + f.getValorPromocao() });
				jtfValorTotalFilme.setText("R$ " + valorTotalFilme);
			}
		}
	}
	
	public void validarLocacao(){
		
		if (cboxVendedor.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "É necessário cadastrar um VENDEDOR");
		}else if (cboxVendedor.getSelectedItem().equals("-Selecione um Vendedor-")) {
			JOptionPane.showMessageDialog(null, "É necessário selecionar um VENDEDOR");
		} else {
			nomeVendedorSaida = "" + cboxVendedor.getSelectedItem();
		}
		
		if (arrayListFilmeLocado.size() == 0) {
			JOptionPane.showMessageDialog(null, "É necessário selecionar um FILME");
			validaLocacao = true;
		}
		
		if (rbtDinheiro.isSelected()) {
			formaPagamento += rbtDinheiro.getText();
		}
		if (rbtCheque.isSelected()) {
			formaPagamento += rbtCheque.getText();
		}
		if (rbtDebito.isSelected()) {
			formaPagamento += rbtDebito.getText();
		}
		if (rbtCredito.isSelected()) {
			formaPagamento += rbtCredito.getText();
		}
		if (formaPagamento.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe a forma de pagamento!");
			validaLocacao = true;
		}
		
		if (jtfValorPagoFilme.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o valor pago!");
			validaLocacao = true;
		}		
	}

	public class SalvarLocacaoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			validarLocacao();
			if (validaLocacao == false) {
				try {
					File arquivo = new File("saidaLocacao.txt");
					FileOutputStream arquivoOutput = new FileOutputStream(
							arquivo, true);
					PrintStream gravador = new PrintStream(arquivoOutput);
					gravador.println(nomeVendedorSaida.toUpperCase());
					for (Filme f: arrayListFilmeLocado) {
						gravador.println(f.getNome());
					}
					gravador.println(formaPagamento.toUpperCase());
					gravador.println(valorTotalFilme);
					gravador.println(jtfValorPagoFilme.getText());
					double valorTrocoFilme = (Double.parseDouble(jtfValorPagoFilme.getText()) - valorTotalFilme);
					jtfValorTrocoFilme.setText("R$ " + valorTrocoFilme);
					gravador.println(valorTrocoFilme);
					gravador.close();
					JOptionPane.showMessageDialog(null,
							"Locação efetuada com sucesso!");
					nomeVendedorSaida = "";
					formaPagamento = "";
				} catch (FileNotFoundException e) {
					System.out.println("Erro na gravação.");
				}
			}
		}
	}
	
	/**
	 * Classe para definir ação para o JButton INCLUIR
	 * @author Diego Munhoz
	 *
	 */
	public class ListenerBotaoIncluir implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			adicionaLinha();
		}
	}
	
}// fim da classe