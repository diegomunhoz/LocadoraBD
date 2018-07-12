package br.com.choice.locadorabd.model;

public class Vendedor {//inicio da classe
	
	private String nome;
	private String areaVenda;
	private String cidade;
	private String estado;
	private String sexo;
	private int idade;
	private double salario;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAreaVenda() {
		return areaVenda;
	}
	public void setAreaVenda(String areaVenda) {
		this.areaVenda = areaVenda;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

}//fim da classe 