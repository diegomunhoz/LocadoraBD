package br.com.choice.locadorabd.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Diego Munhoz
 *
 */

public class TelaCadastraCliente {

	private JFrame janelaCadastroCliente;
	private JPanel painelDaJanelaCadastroCliente;

	private JLabel lblNomeCliente;
	private JLabel lblLocadouroCliente;
	private JLabel lblNumeroLogadouroCliente;
	private JLabel lblBairroCliente;
	private JLabel lblCidadeCliente;
	private JLabel lblEstadoCliente;
	private JLabel lblTelefoneCliente;
	private JLabel lblCpfCliente;
	private JLabel lblRgCliente;
	private JLabel lblIdadeCliente;
	private JLabel lblSexoCliente;
	private JTextField jtfNomeCliente;
	private JTextField jtfLogadouroCliente;
	private JTextField jtfNumeroLogadouroCliente;
	private JTextField jtfBairroCliente;
	private JTextField jtfCidadeCliente;
	private JComboBox cboxEstadoCliente;
	private JTextField jtfTelefoneCliente;
	private JTextField jtfCpfCliente;
	private JTextField jtfRgCliente;
	private JTextField jtfIdadeCliente;
	private JRadioButton rbtMaculinoCliente;
	private JRadioButton rbtFemininoCliente;
	private ButtonGroup grpSexoCliente;
	private JButton btnNovoCliente;
	private JButton btnSalvarCliente;
	private JButton btnCancelarCliente;
	private JButton btnSairCliente;

	private String[] estadoComps = { "-Selecione UF-", "SP", "PR", "RJ", "MG",
			"RN", "TO", "AM", "BA" };
	
	public TelaCadastraCliente() {
		iniciaTela();
	}

	public void iniciaTela() {

		// cria as instancias dos objetos da tela principal
		janelaCadastroCliente = new JFrame("CADASTRO DE CLIENTES");
		painelDaJanelaCadastroCliente = (JPanel) janelaCadastroCliente.getContentPane();

		// cria as instancias dos objetos da aba VENDEDOR
		lblNomeCliente = new JLabel("Nome:");
		lblLocadouroCliente = new JLabel("Endereço:");
		lblNumeroLogadouroCliente = new JLabel("Numero:");
		lblBairroCliente = new JLabel("Bairro:");
		lblCidadeCliente = new JLabel("Cidade:");
		lblEstadoCliente = new JLabel("Estado:");
		lblTelefoneCliente = new JLabel("Telefone:");
		lblCpfCliente = new JLabel("CPF:");
		lblRgCliente = new JLabel("RG:");
		lblIdadeCliente = new JLabel("Idade:");
		jtfNomeCliente = new JTextField();
		jtfLogadouroCliente = new JTextField();
		jtfNumeroLogadouroCliente = new JTextField();
		jtfBairroCliente = new JTextField();
		jtfCidadeCliente = new JTextField();
		cboxEstadoCliente = new JComboBox(estadoComps);
		jtfTelefoneCliente = new JTextField();
		jtfCpfCliente = new JTextField();
		jtfRgCliente = new JTextField();
		jtfIdadeCliente = new JTextField();
		rbtMaculinoCliente = new JRadioButton("Masculino");
		rbtFemininoCliente = new JRadioButton("Feminino");
		grpSexoCliente = new ButtonGroup();
		btnNovoCliente = new JButton("NOVO");
		btnSalvarCliente = new JButton("SALVAR");
		btnCancelarCliente = new JButton("CANCELAR");
		btnSairCliente = new JButton("SAIR");

		// contentPane
		painelDaJanelaCadastroCliente.setLayout(null);

		// Configura a janela
		janelaCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		janelaCadastroCliente.setSize(600, 360);
		janelaCadastroCliente.setLocationRelativeTo(null);
		janelaCadastroCliente.setVisible(true);
		
	}
	
	
}// fim da classe