package br.com.loja.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.domain.Cliente;

@ManagedBean(name = "MBCliente")
@ViewScoped
public class ClienteBean {
	private ListDataModel<Cliente> itens;

	public ListDataModel<Cliente> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Cliente> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquida() {
		try {
			ClienteDAO dao = new ClienteDAO();
			ArrayList<Cliente> lista = dao.listarCliente();
			itens = new ListDataModel<Cliente>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
