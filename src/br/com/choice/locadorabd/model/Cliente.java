package br.com.choice.locadorabd.model;

public class Cliente {

	private String nome;
	private String locadouro;
	private int numeroLogadouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String cpf;
	private String rg;
	private String sexo;
	private byte idade;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocadouro() {
		return locadouro;
	}
	public void setLocadouro(String locadouro) {
		this.locadouro = locadouro;
	}
	public int getNumeroLogadouro() {
		return numeroLogadouro;
	}
	public void setNumeroLogadouro(int numeroLogadouro) {
		this.numeroLogadouro = numeroLogadouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public byte getIdade() {
		return idade;
	}
	public void setIdade(byte idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}// fim da classe