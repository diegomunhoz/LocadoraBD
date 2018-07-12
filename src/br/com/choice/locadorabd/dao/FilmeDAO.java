package br.com.choice.locadorabd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.choice.locadorabd.model.Filme;

public class FilmeDAO {
	
	private Connection bd;
	
	public FilmeDAO(Connection bd){
		this.bd = bd;
	}
	
	public void inserir(Filme filme) throws SQLException{
		String sql = "insert into filme(codigo, nome, genero, valor, disponivel, promocao, valor_promocao) values (?,?,?,?,?,?,?)";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setInt(1, filme.getCodigo());
		comando.setString(2, filme.getNome());
		comando.setString(3, filme.getGenero());
		comando.setDouble(4, filme.getValor());
		if (filme.isDisponivel() == true) {
			comando.setString(5, "SIM");
		}else {
			comando.setString(5, "NAO");
		}
		if (filme.isPromocao() == true) {
			comando.setString(6, "SIM");
		}else {
			comando.setString(6, "NAO");
		}
		comando.setDouble(7, filme.getValorPromocao());
		comando.execute();
		bd.close();
	}

	public List<Filme> buscarTodos() throws SQLException{
		String sql = "select * from filme order by nome";
		PreparedStatement comando = bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Filme> listaFilmes = new ArrayList<Filme>();
		
		while (cursor.next()) {
			//Aluno aluno = new Aluno();
			//aluno.setNome(cursor.getString("nome"));
			//aluno.setIdade(cursor.getInt("idade"));
			//aluno.setCidade(cursor.getString("cidade"));
			//listaAlunos.add(aluno);
		}
		return listaFilmes;
	}
	
}//fim da classe