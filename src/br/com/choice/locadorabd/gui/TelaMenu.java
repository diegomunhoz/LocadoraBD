package br.com.choice.locadorabd.gui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

/**
 * Classe responsável por armazenar MENU_PRINCIPAL
 * @author Diego Munhoz
 * @since 20/02/2014
 */

public class TelaMenu {

	private JFrame janela;
	private JMenuBar barraMenu;
	private JMenu menuCadastro;
	private JMenu menuConsulta;
	private JMenu menuSair;
	private JMenuItem itemMenuCadastroFilme;
	private JMenuItem itemMenuCadastroVendedor;
	private JMenuItem itemMenuCadastroLocacao;
	private JMenuItem itemMenuConsultaFilme;
	private JMenuItem itemMenuConsultaVendedor;
	private JMenuItem itemMenuSair;

	public void inicia(){
		janela = new JFrame("LOCADORA");
		
		// criação da barra de menus
		barraMenu = new JMenuBar();
		
		// criação dos itens do menu
		menuCadastro = new JMenu("CADASTRO");
		menuConsulta = new JMenu("CONSULTA");
		menuSair = new JMenu("SAIR");
		itemMenuCadastroVendedor = new JMenuItem("Vendedor");
		itemMenuCadastroFilme = new JMenuItem("Filme");
		itemMenuCadastroLocacao = new JMenuItem("Locação");
		itemMenuConsultaVendedor= new JMenuItem("Vendedor");
		itemMenuConsultaFilme = new JMenuItem("Filme");
		itemMenuSair = new JMenuItem("Sair");
		
		// adiciona os menus à barra
		barraMenu.add(menuCadastro);
		barraMenu.add(menuConsulta);
		barraMenu.add(menuSair);
		menuCadastro.add(itemMenuCadastroVendedor);
		menuCadastro.add(itemMenuCadastroFilme);
		menuCadastro.add(itemMenuCadastroLocacao);
		menuConsulta.add(itemMenuConsultaVendedor);
		menuConsulta.add(itemMenuConsultaFilme);
		menuSair.add(itemMenuSair);
		
		itemMenuCadastroVendedor.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cadastroVendedorActionListener(evt);
			}
		});

		itemMenuCadastroFilme.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cadastroFilmeActionListener(evt);
			}
		});

		itemMenuCadastroLocacao.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cadastroLocacaoActionListener(evt);
			}
		});

		itemMenuConsultaFilme.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				consultaFilmeActionListener(evt);
			}
		});

		itemMenuConsultaVendedor.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				consultaVendedorActionListener(evt);
			}
		});

		itemMenuSair.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sairAplicacaoActionListener(evt);
			}
		});

		janela.setJMenuBar(barraMenu);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setVisible(true);

	}

	private static void cadastroLocacaoActionListener(ActionEvent evt){
		new TelaEfetuaLocacao();
	}

	private static void cadastroVendedorActionListener(ActionEvent evt){
		new TelaCadastraVendedor();
	}

	private static void cadastroFilmeActionListener(ActionEvent evt){
		new TelaCadastraFilme();		
	}

	private static void consultaVendedorActionListener(ActionEvent evt){
		new TelaExibeVendedor();
	}
	
	private static void consultaFilmeActionListener(ActionEvent evt){
		new TelaExibeFilme();
	}

	private static void sairAplicacaoActionListener(ActionEvent evt){
		System.exit(0);
	}

	public static void main(String[] args) {//inicio do método main
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TelaMenu().inicia();
	}//fim do main

}//fim da classe