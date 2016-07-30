package br.com.petshop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.DAO.InterfaceDAO;
import br.com.petshop.modelo.TipoAnimal;
import br.com.petshop.util.ConnectionFactory;
import br.com.petshop.util.ConstantesSistema;
import br.com.petshop.util.SQL;
import br.com.petshop.util.Util;

public class TipoAnimalDAO implements InterfaceDAO<TipoAnimal> {
	
	Util util = new Util();

	private Connection con;

	

		
	public TipoAnimalDAO(Connection con) {
		this.con = new ConnectionFactory().getConnection();
	}

	
	@Override
	public void insere(TipoAnimal tipo) {
		try {
			
			PreparedStatement stmt = con.prepareStatement(SQL.INSERE_TIPO_ANIMAL);
			stmt.setString(1, tipo.getTipo());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_INSERIR, e);
		}
		
	}

	@Override
	public void deleta(Integer id) {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL.REMOVE_TIPO_ANIMAL);
			
			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_DELETAR, e);
		}
		
	}

	@Override
	public List<TipoAnimal> buscaTodos() {
		List<TipoAnimal>list = new ArrayList<>();
		
		try {
			PreparedStatement stmt  = con.prepareStatement(SQL.CONSULTA_TODOS_TIPO_ANIMAL);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				TipoAnimal tipo = new TipoAnimal();
				
				tipo.setTipoAnimalID(rs.getInt("tipo__animal_id"));
				tipo.setTipo(rs.getString("tipo"));
				
				list.add(tipo);
				
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_BUSCA_TODOS, e);
		}
		return list;
	}

	@Override
	public TipoAnimal busca (Integer id) {
		TipoAnimal tipo = new TipoAnimal();
		
		try {
			PreparedStatement stmt = con.prepareStatement(SQL.CONSULTA_ANIMAL_TIPO_ID);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				tipo.setTipoAnimalID(rs.getInt("tipo__animal_id"));
				tipo.setTipo(rs.getString("tipo"));
				
			}
			
		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_BUSCAR_ID, e);
		}
		return tipo;
	}

}
