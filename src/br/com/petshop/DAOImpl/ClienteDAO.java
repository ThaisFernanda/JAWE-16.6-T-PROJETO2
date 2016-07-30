package br.com.petshop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.DAO.InterfaceDAO;
import br.com.petshop.modelo.Pessoa;
import br.com.petshop.util.ConnectionFactory;
import br.com.petshop.util.ConstantesSistema;
import br.com.petshop.util.SQL;



public class ClienteDAO implements InterfaceDAO<Pessoa>{

	private Connection con;
	
	public ClienteDAO() {
		con = new ConnectionFactory().getConnection();
	}
	
	@Override
	public void insere(Pessoa cliente) {
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(SQL.INSERE_PESSOA);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			
			stmt.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao tentar inserir o cliente");
			e.printStackTrace();
		} finally {
			ConstantesSistema.encerrarConexoes(stmt, con);			
		}
	}

	@Override
	public void deleta(Integer id) {
		PreparedStatement stmt = null;
		PreparedStatement stmtAnimal = null;
		try {
			stmtAnimal = con.prepareStatement(SQL.REMOVE_ANIMAL_ID_DONO);
			stmtAnimal.setInt(1, id);
			stmtAnimal.execute();
			stmt = con.prepareStatement(SQL.REMOVE_PESSOA);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao tentar remover o cliente");
			e.printStackTrace();
		} finally {
			ConstantesSistema.encerrarConexoes(stmt, con);			
		}	
	}

	@Override
	public List<Pessoa> buscaTodos() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List <Pessoa> lista = new ArrayList<>();
		try {
			stmt =con.prepareStatement(SQL.CONSULTA_TODOS_CONTATOS);
			rs = stmt.executeQuery();
			while (rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setIdCliente(rs.getInt("cliente_id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setTelefone(rs.getString("telefone"));
				
				lista.add(pessoa);
			}
		
		} catch (Exception e) {
			System.out.println("Erro ao buscar todos os clientes");
			e.printStackTrace();
		} finally {
			ConstantesSistema.encerrarConexoes(stmt, con);		
		}
	return lista;
	}

	@Override
	public Pessoa busca(Integer id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pessoa pessoa = new Pessoa();
		try {
			
			stmt =con.prepareStatement(SQL.CONSULTA_PESSOA_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()){
				pessoa.setIdCliente(rs.getInt("cliente_id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setTelefone(rs.getString("telefone"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar os clientes");
			e.printStackTrace();
		} finally {
			ConstantesSistema.encerrarConexoes(stmt, con);
		}
		
	return pessoa;
	}
	
	public Pessoa buscaCPF(Integer cpf) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pessoa pessoa = new Pessoa();
		try {
			
			stmt =con.prepareStatement(SQL.CONSULTA_PESSOA_CPF);
			stmt.setInt(1, cpf);
			rs = stmt.executeQuery();
			if(rs.next()){
				pessoa.setIdCliente(rs.getInt("cliente_id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setTelefone(rs.getString("telefone"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar os clientes");
			e.printStackTrace();
		} finally {
			ConstantesSistema.encerrarConexoes(stmt, con);		
		}
	return pessoa;
	}
	
}
