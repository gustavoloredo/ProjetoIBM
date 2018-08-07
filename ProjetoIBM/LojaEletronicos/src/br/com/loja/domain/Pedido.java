package br.com.loja.domain;

import br.com.loja.domain.Cliente;
import br.com.loja.domain.Pedido;

public class Pedido {
	public class Produto {
		private Long codigo;
		private Double preco;
		private Cliente cliente;
		private Pedido Produto;

		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
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

		public Pedido getProduto() {
			return Produto;
		}

		public void setProduto(Pedido produto) {
			Produto = produto;
		}

	}

}
