package br.com.loja.domain;

public class Cliente {
	private Long codigo;
	private String nome;
	private String endereco;
	private String contatos;

	public Long getCodigo() {
		return codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContatos() {
		return contatos;
	}

	public void setContatos(String contatos) {
		this.contatos = contatos;
	}

	public String getNome() {
		return nome;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		String saida = codigo + "-" + nome;
		return saida;
	}
}
