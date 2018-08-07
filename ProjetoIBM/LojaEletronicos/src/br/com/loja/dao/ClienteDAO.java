package br.com.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.domain.Cliente;
import br.com.loja.domain.Produto;
import br.com.loja.factory.ConexaoFactory;

public class ClienteDAO {
	public void salvarCliente(Cliente f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Cliente ");
		sql.append("(nome) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());

		comando.executeUpdate();
	}

	public void salvarProduto(Produto f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Produto ");
		sql.append("(nome) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());

		comando.executeUpdate();
	}

	public void excluirCliente(Cliente f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM cliente ");
		sql.append("WHERE codigo = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();

	}

	public void excluirProduto(Produto f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produto ");
		sql.append("WHERE codigo = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();

	}

	public void editar(Cliente f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produto ");
		sql.append("SET nome = ? ");
		sql.append("WHERE codigo = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setLong(2, f.getCodigo());

		comando.executeUpdate();
	}

	public Cliente buscarPorCodigoCliente(Cliente c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome ");
		sql.append("FROM cliente");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Cliente retorno = null;
		if (resultado.next()) {
			retorno = new Cliente();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setNome(resultado.getString("nome"));
		}

		return retorno;
	}

	public Produto buscarPorCodigoProduto(Produto c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome ");
		sql.append("FROM Produto");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Produto retorno = null;
		if (resultado.next()) {
			retorno = new Produto();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setNome(resultado.getString("nome"));
		}

		return retorno;
	}

	public ArrayList<Cliente> listarCliente() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome ");
		sql.append("FROM cliente ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		while (resultado.next()) {
			Cliente f = new Cliente();
			f.setCodigo(resultado.getLong("codigo"));
			f.setNome(resultado.getString("nome"));

			lista.add(f);
		}

		return lista;

	}

	public ArrayList<Produto> listarProduto() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome ");
		sql.append("FROM produto ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();

		while (resultado.next()) {
			Produto f = new Produto();
			f.setCodigo(resultado.getLong("codigo"));
			f.setNome(resultado.getString("nome"));

			lista.add(f);
		}

		return lista;

	}

	public ArrayList<Cliente> buscarPorNomeCliente(Cliente f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome ");
		sql.append("FROM cliente ");
		sql.append("WHERE nome LIKE ? ");
		sql.append("ORDER BY cliente ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getNome() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		while (resultado.next()) {
			Cliente item = new Cliente();
			item.setCodigo(resultado.getLong("codigo"));
			item.setNome(resultado.getString("nome"));

			lista.add(item);
		}

		return lista;
	}

	public ArrayList<Cliente> buscarPorNomeProduto(Produto f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome ");
		sql.append("FROM produto ");
		sql.append("WHERE nome LIKE ? ");
		sql.append("ORDER BY produto ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getNome() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		while (resultado.next()) {
			Cliente item = new Cliente();
			item.setCodigo(resultado.getLong("codigo"));
			item.setNome(resultado.getString("nome"));

			lista.add(item);
		}

		return lista;
	}

	public static void main(String[] args) {
		/*
		 * Cliente f1 = new Cliente(); f1.setNome("Nome 1"); Cliente f2 = new Cliente
		 * (); f2.setNome("Nome 2");
		 * 
		 * ClienteDAO cdao = new ClienteDAO(); try { cdao.salvarCliente(f1);
		 * cdao.salvarCliente(f2); System.out.println("Cliente salvos com sucessos"); }
		 * catch (SQLException e) {
		 * System.out.println("Ocorreu erro ao salvar cliente"); e.printStackTrace(); }
		 */
		/*
		 * Cliente f1 = new Cliente(); Cliente f2 = new Cliente(); f1.setCodigo(2L);
		 * f2.setCodigo(4L); ClienteDAO cdao = new ClienteDAO (); try {
		 * cdao.excluirCliente(f1); cdao.excluirCliente(f2);
		 * System.out.println("Cliente excluidos com sucesso"); } catch (SQLException e)
		 * { System.out.println("Erro ao deletar Cliente"); e.printStackTrace(); }
		 */

		/*
		 * Cliente f1 = new Cliente(); f1.setCodigo(3L); f1.setNome("Nome 3");
		 * 
		 * ClienteDAO cdao = new ClienteDAO (); try { cdao.editar(f1);
		 * System.out.println("Cliente editado com sucesso"); } catch (SQLException e) {
		 * System.out.println("Problema ao editar Cliente"); e.printStackTrace(); }
		 */

		/*Cliente c1 = new Cliente();
		c1.setCodigo(3L);
		Cliente c2 = new Cliente();
		c1.setCodigo(1L);

		ClienteDAO cdao = new ClienteDAO();

		try {
			Cliente c3 = cdao.buscarPorCodigoCliente(c1);
			Cliente c4 = cdao.buscarPorCodigoCliente(c2);
			System.out.println("Resultado 1:" + c3);
			System.out.println("Resultado 2:" + c4);
		} catch (SQLException e) {
			System.out.println("Erro ao procurar um dos Clientes");
			e.printStackTrace();
		}*/
		/*
		 * ClienteDAO cdao = new ClienteDAO(); try { ArrayList<Cliente> lista =
		 * cdao.listarCliente();
		 * 
		 * for(Cliente f : lista) { System.out.println("Resultado "+ f); } } catch
		 * (SQLException e) {
		 * System.out.println("Ocorreu um erro ao tentar lista Clientes");
		 * e.printStackTrace(); }
		 */

		/*
		 * Cliente f1 = new Cliente(); f1.setNome("1"); ClienteDAO cdao = new
		 * ClienteDAO(); try { ArrayList<Cliente> lista = cdao.buscarPorNomeCliente(f1);
		 * 
		 * for(Cliente f : lista) { System.out.println("Resultado "+ f); }
		 * 
		 * } catch (SQLException e) {
		 * System.out.println("Ocorreu erro ao tentar pesquuisar um Cliente");
		 * e.printStackTrace(); }
		 */

	}
}
