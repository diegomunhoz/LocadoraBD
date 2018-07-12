package br.com.choice.locadorabd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.choice.locadorabd.model.Vendedor;

public class VendedorDAO {
	
	private Connection bd;
	
	public VendedorDAO(Connection bd){
		this.bd = bd;
	}
	
	public void inserir(Vendedor vendedor) throws SQLException{
		String sql = "insert into vendedor(nome, area_venda, cidade, estado, sexo, idade, salario) values (?,?,?,?,?,?,?)";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, vendedor.getNome());
		comando.setString(2, vendedor.getAreaVenda());
		comando.setString(3, vendedor.getCidade());
		comando.setString(4, vendedor.getEstado());
		comando.setString(5, vendedor.getSexo());
		comando.setInt(6, vendedor.getIdade());
		comando.setDouble(7, vendedor.getSalario());
		comando.execute();
		bd.close();
	}

	public List<Vendedor> buscarTodos() throws SQLException{
		String sql = "select * from vendedor order by nome";
		PreparedStatement comando = bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
		while (cursor.next()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(cursor.getString("nome"));
			vendedor.setAreaVenda(cursor.getString("area_venda"));
			vendedor.setCidade(cursor.getString("cidade"));
			vendedor.setEstado(cursor.getString("estado"));
			vendedor.setEstado(cursor.getString("sexo"));
			vendedor.setIdade(cursor.getInt("idade"));
			vendedor.setSalario(cursor.getDouble("salario"));
		}
		System.out.println("chesad");
		return listaVendedor;
	}
	
}//fim da classe