package br.com.choice.locadorabd.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.choice.locadorabd.dao.VendedorDAO;
import br.com.choice.locadorabd.model.Vendedor;
import br.com.choice.locadorabd.util.ConnectionFactory;

/**
 * @author Diego Munhoz
 * 
 */
public class TelaExibeVendedor {

	private JFrame janelaExibeVendedor;
	private JPanel painelDaJanelaExibeVendedor;
	private JTable tabelaVendedor;
	private JButton btnSairVendedor;

	private JScrollPane painelDeScrollVendedor;

	private String nomeVendedor;
	private String areaVendaVendedor;
	private String cidadeVendedor;
	private String estadoVendedor;
	private String sexoVendedor;
	private String idadeVendedor;
	private String salarioVendedor;

	private String nomeArquivo = "saidaVendedor.txt";

	private String[] colunas = new String[] { "Nome", "Area de Venda",
			"Cidade", "Estado", "Sexo", "Idade", "Salario" };
	private String[][] dados = new String[][] { {} };

	public TelaExibeVendedor() {
		iniciaTelaExibeVendedor();
	}

	public void iniciaTelaExibeVendedor() {

		janelaExibeVendedor = new JFrame("Consulta de Vendedor");
		btnSairVendedor = new JButton("SAIR");

		painelDaJanelaExibeVendedor = (JPanel) janelaExibeVendedor
				.getContentPane();
		painelDaJanelaExibeVendedor.setLayout(null);

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tabelaVendedor = new JTable(modelo);

		tabelaVendedor.setEnabled(false);

		// Inserindo a tabela em um painel de scroll
		painelDeScrollVendedor = new JScrollPane(tabelaVendedor);
		painelDeScrollVendedor
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		painelDeScrollVendedor.setBounds(0, 0, 560, 310);
		tabelaVendedor.setBounds(0, 0, 500, 310);
		btnSairVendedor.setBounds(190, 320, 150, 30);

		painelDaJanelaExibeVendedor.add(painelDeScrollVendedor);
		painelDaJanelaExibeVendedor.add(btnSairVendedor);

		btnSairVendedor.addActionListener(new SairFrameListener());

		listarVendedor();

		janelaExibeVendedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaExibeVendedor.setSize(575, 400);
		janelaExibeVendedor.setLocationRelativeTo(null);
		janelaExibeVendedor.setVisible(true);
	}

	public class SairFrameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			janelaExibeVendedor.setVisible(false);
		}
	}

	public void listarVendedor() {
		DefaultTableModel m = (DefaultTableModel) tabelaVendedor.getModel();
		m.removeRow(0);
		Connection bd = ConnectionFactory.getConnection();
		try {
			VendedorDAO dao = new VendedorDAO(bd);
			List<Vendedor> vendedores = dao.buscarTodos();
			for (Vendedor vendedor : vendedores) {
				DefaultTableModel modelo = (DefaultTableModel) tabelaVendedor.getModel();
				modelo.addRow(new String[] { vendedor.getNome(), vendedor.getAreaVenda(),
						vendedor.getCidade(), vendedor.getEstado(), vendedor.getSexo(),
						"" + vendedor.getIdade(), "R$ " + vendedor.getSalario()});
				bd.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível exibir VENDEDORES.");
		}
	}

}// fim da classe