package br.com.choice.locadorabd.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.choice.locadorabd.dao.FilmeDAO;
import br.com.choice.locadorabd.model.Filme;
import br.com.choice.locadorabd.util.ConnectionFactory;

/**
 * Classe responsável por armazenar atributos e métodos da tela CADASTRO_FILME
 * 
 * @author Diego Munhoz
 * @since 20/02/2014
 */

public class TelaCadastraFilme {

	// variáveis do frame principal
	private JFrame janelaCadastroFilme;
	private JPanel painelDaJanela;

	private JLabel codigoFilme;
	private JLabel nomeFilme;
	private JLabel valorFilme;
	private JLabel disponivelFilme;
	private JLabel promocaoFilme;
	private JLabel valorPromocaoFilme;
	private JLabel generoFilme;
	private JTextField jtfCodigoFilme;
	private JTextField jtfNomeFilme;
	private JTextField jtfValorFilme;
	private JTextField jtfValorPromocaoFilme;
	private JButton novoFilme;
	private JButton salvarFilme;
	private JButton cancelarFilme;
	private JButton sairFilme;
	private JRadioButton rbtDisponivelSim;
	private JRadioButton rbtDisponivelNao;
	private JRadioButton rbtPromocaoSim;
	private JRadioButton rbtPromocaoNao;
	private ButtonGroup grpDisponivel;
	private ButtonGroup grpPromocao;
	private JCheckBox cbFiccao;
	private JCheckBox cbAcao;
	private JCheckBox cbTerror;
	private JCheckBox cbComedia;
	private JCheckBox cbOutro;

	// variáveis auxiliares
	private boolean validaFilme = false;
	private double valorFilmeConvertido;
	private double valorPromocionalFilmeConvertido;
	private int codigoConvertido;
	private String respostaGenero = "";
	private String flagDisponivelFilme = "";
	private String flagPromocaoFilme = "";

	/**
	 * Método construtor
	 */
	public TelaCadastraFilme() {
		iniciaTela();
	}

	/**
	 * Método responsável por inicar tela de Cadastro de Filme
	 */
	public void iniciaTela() {
		// cria as instancias
		janelaCadastroFilme = new JFrame("CADASTRO DE FILME");
		painelDaJanela = (JPanel) janelaCadastroFilme.getContentPane();

		// cria as instancias dos objetos da aba FILME
		codigoFilme = new JLabel("Código:");
		nomeFilme = new JLabel("Nome:");
		valorFilme = new JLabel("Valor:");
		disponivelFilme = new JLabel("Disponível:");
		promocaoFilme = new JLabel("Promoção:");
		valorPromocaoFilme = new JLabel("Valor Promoção:");
		generoFilme = new JLabel("Gênero:");
		jtfCodigoFilme = new JTextField();
		jtfNomeFilme = new JTextField();
		jtfValorFilme = new JTextField();
		jtfValorPromocaoFilme = new JTextField();
		novoFilme = new JButton("NOVO");
		salvarFilme = new JButton("SALVAR");
		cancelarFilme = new JButton("CANCELAR");
		sairFilme = new JButton("SAIR");
		cbAcao = new JCheckBox("Ação");
		cbComedia = new JCheckBox("Comédia");
		cbFiccao = new JCheckBox("Ficção");
		cbTerror = new JCheckBox("Terror");
		cbOutro = new JCheckBox("Outro");
		rbtDisponivelSim = new JRadioButton();
		rbtDisponivelNao = new JRadioButton();
		rbtPromocaoSim = new JRadioButton();
		rbtPromocaoNao = new JRadioButton();
		grpDisponivel = new ButtonGroup();
		grpPromocao = new ButtonGroup();

		// Define as Label's dos JRadionButton
		rbtDisponivelSim.setText("Sim");
		rbtDisponivelNao.setText("Nao");
		rbtPromocaoSim.setText("Sim");
		rbtPromocaoNao.setText("Nao");

		// define localização dos componentes de FILMES
		codigoFilme.setBounds(20, 20, 80, 20);
		nomeFilme.setBounds(20, 50, 40, 20);
		valorFilme.setBounds(20, 80, 90, 20);
		disponivelFilme.setBounds(20, 110, 90, 20);
		promocaoFilme.setBounds(20, 140, 90, 20);
		valorPromocaoFilme.setBounds(20, 170, 100, 20);
		generoFilme.setBounds(20, 200, 50, 20);
		jtfCodigoFilme.setBounds(120, 17, 420, 25);
		jtfNomeFilme.setBounds(120, 47, 420, 25);
		jtfValorFilme.setBounds(120, 77, 420, 25);
		rbtDisponivelSim.setBounds(120, 107, 50, 25);
		rbtDisponivelNao.setBounds(180, 107, 50, 25);
		rbtPromocaoSim.setBounds(120, 137, 50, 25);
		rbtPromocaoNao.setBounds(180, 137, 50, 25);
		jtfValorPromocaoFilme.setBounds(120, 167, 420, 25);
		cbAcao.setBounds(120, 197, 50, 24);
		cbFiccao.setBounds(175, 197, 58, 24);
		cbTerror.setBounds(238, 197, 58, 24);
		cbComedia.setBounds(301, 197, 73, 24);
		cbOutro.setBounds(380, 197, 55, 24);
		novoFilme.setBounds(115, 250, 150, 30);
		salvarFilme.setBounds(115, 250, 150, 30);
		cancelarFilme.setBounds(285, 250, 150, 30);
		sairFilme.setBounds(285, 250, 150, 30);

		// adiciona os botões ao grupo da aba FILME
		grpDisponivel.add(rbtDisponivelSim);
		grpDisponivel.add(rbtDisponivelNao);
		grpPromocao.add(rbtPromocaoSim);
		grpPromocao.add(rbtPromocaoNao);

		// Insere os componentes na primeira aba
		painelDaJanela.add(codigoFilme);
		painelDaJanela.add(nomeFilme);
		painelDaJanela.add(valorFilme);
		painelDaJanela.add(disponivelFilme);
		painelDaJanela.add(promocaoFilme);
		painelDaJanela.add(valorPromocaoFilme);
		painelDaJanela.add(generoFilme);
		painelDaJanela.add(jtfCodigoFilme);
		painelDaJanela.add(jtfNomeFilme);
		painelDaJanela.add(jtfValorFilme);
		painelDaJanela.add(rbtDisponivelSim);
		painelDaJanela.add(rbtDisponivelNao);
		painelDaJanela.add(rbtPromocaoSim);
		painelDaJanela.add(rbtPromocaoNao);
		painelDaJanela.add(jtfValorPromocaoFilme);
		painelDaJanela.add(novoFilme);
		painelDaJanela.add(salvarFilme);
		painelDaJanela.add(cancelarFilme);
		painelDaJanela.add(sairFilme);
		painelDaJanela.add(cbAcao);
		painelDaJanela.add(cbFiccao);
		painelDaJanela.add(cbTerror);
		painelDaJanela.add(cbComedia);
		painelDaJanela.add(cbOutro);

		// Aciona os métodos dos JButton de FILME
		novoFilme.addActionListener(new NovoFilmeListener());
		salvarFilme.addActionListener(new CadastroFilmeListener());
		cancelarFilme.addActionListener(new CancelarListener());
		sairFilme.addActionListener(new SairSistemaListener());

		// contentPane
		painelDaJanela.setLayout(null);

		bloquearTelaFilme();

		// Configura a janela
		janelaCadastroFilme.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaCadastroFilme.setSize(600, 360);
		janelaCadastroFilme.setLocationRelativeTo(null);
		janelaCadastroFilme.setVisible(true);

	}// fim do método inicia()

	/**
	 * Classe responsável por criar ActionListener para os JButton cancelar das
	 * abas de FILME e VENDEDOR
	 */
	public class CancelarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			limparTelaFilme();
			bloquearTelaFilme();
		}
	}

	/**
	 * Classe responsável por criar ActionListener para o JButton novo da aba
	 * FILME, desbloqueando a tela e permitindo o preenchimento dos atributos de
	 * FILME.
	 */
	public class NovoFilmeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			liberarTelaFilme();
		}
	}

	/**
	 * Classe responsável por criar ActionListener para o JButton salvar da aba
	 * FILME, salvando o objeto FILME com todos os seus atributos
	 */
	public class CadastroFilmeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			validarFilme();
			if (validaFilme == false) {
				Connection bd = ConnectionFactory.getConnection();
				Filme vo = new Filme();
				vo.setCodigo(codigoConvertido);
				vo.setNome(jtfNomeFilme.getText().toUpperCase());
				vo.setValor(valorFilmeConvertido);
				if (flagDisponivelFilme.toUpperCase().equals("SIM")) {
					vo.setDisponivel(true);
				} else {
					vo.setDisponivel(false);
				}
				if (flagPromocaoFilme.toUpperCase().equals("SIM")) {
					vo.setPromocao(true);
				} else {
					vo.setPromocao(false);
				}
				vo.setValorPromocao(valorPromocionalFilmeConvertido);
				vo.setGenero(respostaGenero);
				try {
					FilmeDAO dao = new FilmeDAO(bd);
					dao.inserir(vo);
					JOptionPane.showMessageDialog(null,
							"Filme gravado com sucesso.");
					flagDisponivelFilme = "";
					flagPromocaoFilme = "";
					valorFilmeConvertido = 0;
					valorPromocionalFilmeConvertido = 0;
					codigoConvertido = 0;
					limparTelaFilme();
					bloquearTelaFilme();
					bd.close();
				} catch (SQLException e) {
					JOptionPane
							.showMessageDialog(null, "Erro ao inserir filme");
				}
			}
		}
	}

	/**
	 * Classe responsável por criar ActionListener para o JButton sair do JFrame
	 * CONSULTA_FILME
	 */
	public class SairSistemaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			janelaCadastroFilme.setVisible(false);
		}
	}

	/**
	 * Método responsável por validar os dados digitados no JTextField da aba
	 * FILME
	 */
	public void validarFilme() {
		if (jtfCodigoFilme.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe o valor do filme, campo obrigatório");
			jtfCodigoFilme.grabFocus();
			validaFilme = true;
		} else {
			try {
				codigoConvertido = Integer.parseInt(jtfCodigoFilme.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Código inválido, digite novamente");
				jtfCodigoFilme.grabFocus();
				validaFilme = true;
			}
		}
		if (jtfNomeFilme.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe o nome do filme, campo obrigatório.");
			jtfNomeFilme.grabFocus();
			validaFilme = true;
		}
		if (jtfValorFilme.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe o valor do filme, campo obrigatório");
			jtfValorFilme.grabFocus();
			validaFilme = true;
		} else {
			try {
				valorFilmeConvertido = Double.parseDouble(jtfValorFilme
						.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Valor inválido, digite novamente");
				jtfValorFilme.grabFocus();
				validaFilme = true;
			}
		}
		if (rbtDisponivelSim.isSelected()) {
			flagDisponivelFilme += rbtDisponivelSim.getText().toUpperCase();
		}
		if (rbtDisponivelNao.isSelected()) {
			flagDisponivelFilme += rbtDisponivelNao.getText().toUpperCase();
		}
		if (flagDisponivelFilme == "") {
			JOptionPane.showMessageDialog(null,
					"Informe a disponibilidade do filme <SIM> ou <NÃO>.");
			validaFilme = true;
		}
		if (rbtPromocaoSim.isSelected()) {
			flagPromocaoFilme += rbtPromocaoSim.getText().toUpperCase();
		}
		if (rbtPromocaoNao.isSelected()) {
			flagPromocaoFilme += rbtPromocaoNao.getText().toUpperCase();
		}
		if (flagPromocaoFilme == "") {
			JOptionPane.showMessageDialog(null,
					"Informe promoção do filme <SIM> ou <NÃO>.");
			validaFilme = true;
		}
		if (jtfValorPromocaoFilme.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe o valor promocional, campo obrigatório.");
			jtfValorPromocaoFilme.grabFocus();
			validaFilme = true;
		} else {
			try {
				valorPromocionalFilmeConvertido = Double
						.parseDouble(jtfValorPromocaoFilme.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Valor promocional inválido, campo obrigatório.");
				jtfValorPromocaoFilme.grabFocus();
				validaFilme = true;
			}
		}
		if (cbAcao.isSelected()) {
			respostaGenero += "AÇÃO ";
		}
		if (cbFiccao.isSelected()) {
			respostaGenero += "FICÇÃO ";
		}
		if (cbTerror.isSelected()) {
			respostaGenero += "TERROR ";
		}
		if (cbComedia.isSelected()) {
			respostaGenero += "COMÉDIA ";
		}
		if (cbOutro.isSelected()) {
			respostaGenero += "OUTRO ";
		}
		if (respostaGenero == null) {
			validaFilme = true;
			JOptionPane.showMessageDialog(null,
					"Informe o gênero, campo obrigatório");
		}
	}

	/**
	 * Método responsável por bloquear a aba FILME
	 */
	public void bloquearTelaFilme() {
		jtfCodigoFilme.setEditable(false);
		jtfNomeFilme.setEditable(false);
		jtfValorFilme.setEditable(false);
		jtfValorPromocaoFilme.setEditable(false);
		salvarFilme.setVisible(false);
		novoFilme.setVisible(true);
		sairFilme.setVisible(true);
		cancelarFilme.setVisible(false);
		cbAcao.setEnabled(false);
		cbComedia.setEnabled(false);
		cbFiccao.setEnabled(false);
		cbOutro.setEnabled(false);
		cbTerror.setEnabled(false);
		rbtDisponivelSim.setEnabled(false);
		rbtDisponivelNao.setEnabled(false);
		rbtPromocaoNao.setEnabled(false);
		rbtPromocaoSim.setEnabled(false);
	}

	/**
	 * Método responsável por liberar a aba FILME
	 */
	public void liberarTelaFilme() {
		jtfCodigoFilme.setEditable(true);
		jtfNomeFilme.setEditable(true);
		jtfValorFilme.setEditable(true);
		jtfValorPromocaoFilme.setEditable(true);
		jtfCodigoFilme.grabFocus();
		salvarFilme.setVisible(true);
		novoFilme.setVisible(false);
		cancelarFilme.setVisible(true);
		sairFilme.setVisible(false);
		cbAcao.setEnabled(true);
		cbComedia.setEnabled(true);
		cbFiccao.setEnabled(true);
		cbOutro.setEnabled(true);
		cbTerror.setEnabled(true);
		rbtDisponivelSim.setEnabled(true);
		rbtDisponivelNao.setEnabled(true);
		rbtPromocaoSim.setEnabled(true);
		rbtPromocaoNao.setEnabled(true);
	}

	/**
	 * Método responsável por limpar os dados da aba FILME
	 */
	public void limparTelaFilme() {
		jtfCodigoFilme.setText("");
		jtfNomeFilme.setText("");
		jtfValorFilme.setText("");
		jtfValorPromocaoFilme.setText("");
		cbAcao.setSelected(false);
		cbComedia.setSelected(false);
		cbFiccao.setSelected(false);
		cbOutro.setSelected(false);
		cbTerror.setSelected(false);
		rbtDisponivelSim.setSelected(false);
		rbtDisponivelNao.setSelected(false);
		rbtPromocaoSim.setSelected(false);
		rbtPromocaoNao.setSelected(false);
	}

}// fim da classe