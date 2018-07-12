package br.com.choice.locadorabd.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.VetoableChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.choice.locadorabd.dao.VendedorDAO;
import br.com.choice.locadorabd.model.Vendedor;
import br.com.choice.locadorabd.util.ConnectionFactory;

/**
 * @author Diego Munhoz
 * 
 */

public class TelaCadastraVendedor {

	// variáveis auxiliares
	private boolean validaVendodor = false;
	private int idadeConvertida;
	private double salarioConvertido;
	private String flagSexoVendedor = "";

	// variáveis do frame principal
	private JFrame janelaCadastroVendedor;
	private JPanel painelDaJanelaCadastroVendedor;

	// variáveis da tela de VENDEDOR
	private JLabel nomeVendedor;
	private JLabel areaVenda;
	private JLabel cidade;
	private JLabel estado;
	private JLabel sexo;
	private JLabel idade;
	private JLabel salario;
	private JTextField jtfNomeVendedor;
	private JTextField jtfAreaVenda;
	private JTextField jtfCidade;
	private JComboBox cboxEstado;
	private JTextField jtfIdade;
	private JTextField jtfSalario;
	private JRadioButton rbtMaculinoVendedor;
	private JRadioButton rbtFemininoVendedor;
	private ButtonGroup grpSexoVendedor;
	private JButton novoVendedor;
	private JButton salvarVendedor;
	private JButton cancelarVendedor;
	private JButton sairVendedor;

	private String[] estadoComps = { "-Selecione UF-", "SP", "PR", "RJ", "MG",
			"RN", "TO", "AM", "BA" };

	public TelaCadastraVendedor() {
		iniciaTelaCadastroVendedor();
	}

	public void iniciaTelaCadastroVendedor() {

		// cria as instancias dos objetos da tela principal
		janelaCadastroVendedor = new JFrame("MENU PRINCIPAL");
		painelDaJanelaCadastroVendedor = (JPanel) janelaCadastroVendedor
				.getContentPane();

		// cria as instancias dos objetos da aba VENDEDOR
		nomeVendedor = new JLabel("Nome:");
		areaVenda = new JLabel("Area de Venda:");
		cidade = new JLabel("Cidade:");
		estado = new JLabel("Estado:");
		sexo = new JLabel("Sexo:");
		idade = new JLabel("Idade:");
		salario = new JLabel("Salario:");
		jtfNomeVendedor = new JTextField();
		jtfAreaVenda = new JTextField();
		jtfCidade = new JTextField();
		cboxEstado = new JComboBox(estadoComps);
		jtfIdade = new JTextField();
		jtfSalario = new JTextField();
		rbtMaculinoVendedor = new JRadioButton("Masculino");
		rbtFemininoVendedor = new JRadioButton("Feminino");
		grpSexoVendedor = new ButtonGroup();
		novoVendedor = new JButton("NOVO");
		salvarVendedor = new JButton("SALVAR");
		cancelarVendedor = new JButton("CANCELAR");
		sairVendedor = new JButton("SAIR");

		// define localização dos componentes de VENDEDOR
		nomeVendedor.setBounds(20, 20, 40, 20);
		areaVenda.setBounds(20, 50, 90, 20);
		cidade.setBounds(20, 80, 60, 20);
		estado.setBounds(20, 110, 60, 20);
		sexo.setBounds(20, 140, 40, 20);
		idade.setBounds(20, 170, 40, 20);
		salario.setBounds(20, 200, 50, 20);
		jtfNomeVendedor.setBounds(120, 17, 420, 25);
		jtfAreaVenda.setBounds(120, 47, 420, 25);
		jtfCidade.setBounds(120, 77, 420, 25);
		cboxEstado.setBounds(120, 107, 300, 25);
		rbtMaculinoVendedor.setBounds(120, 137, 80, 25);
		rbtFemininoVendedor.setBounds(220, 137, 80, 25);
		jtfIdade.setBounds(120, 167, 420, 25);
		jtfSalario.setBounds(120, 197, 420, 25);
		novoVendedor.setBounds(115, 250, 150, 30);
		salvarVendedor.setBounds(115, 250, 150, 30);
		cancelarVendedor.setBounds(285, 250, 150, 30);
		sairVendedor.setBounds(285, 250, 150, 30);

		// adiciona os botões ao grupo da aba VENDEDOR
		grpSexoVendedor.add(rbtMaculinoVendedor);
		grpSexoVendedor.add(rbtFemininoVendedor);

		// Insere os componentes na segunda aba
		painelDaJanelaCadastroVendedor.add(nomeVendedor);
		painelDaJanelaCadastroVendedor.add(areaVenda);
		painelDaJanelaCadastroVendedor.add(cidade);
		painelDaJanelaCadastroVendedor.add(estado);
		painelDaJanelaCadastroVendedor.add(sexo);
		painelDaJanelaCadastroVendedor.add(idade);
		painelDaJanelaCadastroVendedor.add(salario);
		painelDaJanelaCadastroVendedor.add(jtfNomeVendedor);
		painelDaJanelaCadastroVendedor.add(jtfAreaVenda);
		painelDaJanelaCadastroVendedor.add(jtfCidade);
		painelDaJanelaCadastroVendedor.add(cboxEstado);
		painelDaJanelaCadastroVendedor.add(rbtMaculinoVendedor);
		painelDaJanelaCadastroVendedor.add(rbtFemininoVendedor);
		painelDaJanelaCadastroVendedor.add(jtfIdade);
		painelDaJanelaCadastroVendedor.add(jtfSalario);
		painelDaJanelaCadastroVendedor.add(novoVendedor);
		painelDaJanelaCadastroVendedor.add(salvarVendedor);
		painelDaJanelaCadastroVendedor.add(cancelarVendedor);
		painelDaJanelaCadastroVendedor.add(sairVendedor);

		// Aciona os métodos dos JButton de VENDEDOR
		novoVendedor.addActionListener(new NovoVendedorListener());
		salvarVendedor.addActionListener(new CadastroVendedorListener());
		cancelarVendedor.addActionListener(new CancelarListener());
		sairVendedor.addActionListener(new SairSistemaListener());

		bloquearTelaVendedor();

		// contentPane
		painelDaJanelaCadastroVendedor.setLayout(null);

		// Configura a janela
		janelaCadastroVendedor
				.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		janelaCadastroVendedor.setSize(600, 360);
		janelaCadastroVendedor.setLocationRelativeTo(null);
		janelaCadastroVendedor.setVisible(true);

	}

	/**
	 * Classe responsável por criar ActionListener para o JButton sair das abas
	 * FILME e VENDEDOR encerrando a execução do programa
	 */
	public class SairSistemaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			janelaCadastroVendedor.setVisible(false);
		}
	}

	/**
	 * Classe responsável por criar ActionListener para os JButton cancelar das
	 * abas de FILME e VENDEDOR
	 */
	public class CancelarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			limparTelaVendedor();
			bloquearTelaVendedor();
		}
	}

	/**
	 * Classe responsável por criar ActionListener para o JButton salvar da aba
	 * VENDEDOR, salvando o objeto VENDEDOR com todos os seus atributos
	 */
	public class CadastroVendedorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			validarVendedor();
			if (validaVendodor == false) {
				Connection bd = ConnectionFactory.getConnection();
				Vendedor vendedor = new Vendedor();
				vendedor.setNome(jtfNomeVendedor.getText().toUpperCase());
				vendedor.setAreaVenda(jtfAreaVenda.getText().toUpperCase());
				vendedor.setCidade(jtfCidade.getText().toUpperCase());
				vendedor.setEstado("" + cboxEstado.getSelectedItem());
				vendedor.setSexo(flagSexoVendedor);
				vendedor.setIdade(idadeConvertida);
				vendedor.setSalario(salarioConvertido);
				try {
					VendedorDAO dao = new VendedorDAO(bd);
					dao.inserir(vendedor);
					JOptionPane.showMessageDialog(null,
							"Vendedor salvo com sucesso!");
					flagSexoVendedor = "";
					limparTelaVendedor();
					bloquearTelaVendedor();
				} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir vendedor!");
				}
			}
		}
	}

	/**
	 * Classe responsável por criar ActionListener para o JButton novo da aba
	 * VENDEDOR, desbloqueando a tela e permitindo o preenchimento dos atributos
	 * de VENDEDOR.
	 */
	public class NovoVendedorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			liberarTelaVendedor();
		}
	}

	/**
	 * Método responsável por validar os dados digitados no JTextField da aba
	 * VENDEDOR
	 */
	public void validarVendedor() {
		if (jtfNomeVendedor.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe o nome, campo obrigatório.");
			jtfNomeVendedor.grabFocus();
			validaVendodor = true;
		}
		if (jtfAreaVenda.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe a Area de Venda, campo obrigatório.");
			jtfAreaVenda.grabFocus();
			validaVendodor = true;
		}
		if (jtfCidade.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe a cidade, campo obrigatório.");
			jtfCidade.grabFocus();
			validaVendodor = true;
		}
		if (cboxEstado.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,
					"Informe o estado, campo obrigatório.");
			validaVendodor = true;
		}
		if (rbtMaculinoVendedor.isSelected()) {
			flagSexoVendedor += rbtMaculinoVendedor.getText().toUpperCase();
		}
		if (rbtFemininoVendedor.isSelected()) {
			flagSexoVendedor += rbtFemininoVendedor.getText().toUpperCase();
		}
		if (flagSexoVendedor == "") {
			JOptionPane.showMessageDialog(null, "Informe o sexo do vendedor.");
			validaVendodor = true;
		}
		if (jtfIdade.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe a idade, campo obrigatório");
			jtfIdade.grabFocus();
			validaVendodor = true;
		} else {
			try {
				idadeConvertida = Integer.parseInt(jtfIdade.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Idade inválida, digite novamente");
				jtfIdade.grabFocus();
				validaVendodor = true;
			}
		}
		if (jtfSalario.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Informe o salario, campo obrigatório");
			jtfSalario.grabFocus();
			validaVendodor = true;
		} else {
			try {
				salarioConvertido = Double.parseDouble(jtfSalario.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Salário inválido, digite novamente");
				jtfSalario.grabFocus();
				validaVendodor = true;
			}
		}
	}

	/**
	 * Método responsável por bloquear a aba VENDEDOR
	 */
	public void bloquearTelaVendedor() {
		jtfNomeVendedor.setEditable(false);
		jtfAreaVenda.setEditable(false);
		jtfCidade.setEditable(false);
		cboxEstado.setEnabled(false);
		jtfIdade.setEditable(false);
		jtfSalario.setEditable(false);
		salvarVendedor.setVisible(false);
		rbtMaculinoVendedor.setEnabled(false);
		rbtFemininoVendedor.setEnabled(false);
		novoVendedor.setVisible(true);
		sairVendedor.setVisible(true);
		cancelarVendedor.setVisible(false);
	}

	/**
	 * Método responsável por liberar a aba VENDEDOR
	 */
	public void liberarTelaVendedor() {
		jtfNomeVendedor.setEditable(true);
		jtfAreaVenda.setEditable(true);
		jtfCidade.setEditable(true);
		cboxEstado.setEnabled(true);
		jtfIdade.setEditable(true);
		jtfSalario.setEditable(true);
		jtfNomeVendedor.grabFocus();
		rbtMaculinoVendedor.setEnabled(true);
		rbtFemininoVendedor.setEnabled(true);
		salvarVendedor.setVisible(true);
		novoVendedor.setVisible(false);
		cancelarVendedor.setVisible(true);
		sairVendedor.setVisible(false);
	}

	/**
	 * Método responsável por limpar os dados da aba VENDEDOR
	 */
	public void limparTelaVendedor() {
		jtfNomeVendedor.setText("");
		jtfAreaVenda.setText("");
		jtfCidade.setText("");
		cboxEstado.setSelectedIndex(0);
		jtfIdade.setText("");
		jtfSalario.setText("");
		rbtMaculinoVendedor.setSelected(false);
		rbtFemininoVendedor.setSelected(false);
	}

}// fim da classe