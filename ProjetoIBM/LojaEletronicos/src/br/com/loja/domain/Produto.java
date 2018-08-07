package br.com.loja.domain;

import br.com.loja.domain.Cliente;

public class Produto {
	private Long codigo;
	private String nome;
	private Double preco;
	private Cliente cliente;
	private Long quantidade;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;

	}

	@Override
	public String toString() {
		String saida = codigo + "-" + nome;
		return saida;
	}
}