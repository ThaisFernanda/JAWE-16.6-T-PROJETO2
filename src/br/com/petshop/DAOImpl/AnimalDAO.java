package br.com.petshop.DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;


import br.com.petshop.DAO.InterfaceDAO;
import br.com.petshop.modelo.Animal;
import br.com.petshop.util.ConnectionFactory;
import br.com.petshop.util.ConstantesSistema;
import br.com.petshop.util.Util;

public class AnimalDAO implements InterfaceDAO<Animal> {
	
	Util util = new Util();
	
	private Connection con;

	public AnimalDAO() {
		
		this.con = new ConnectionFactory().getConnection();
	}


	@Override
	public void insere (Animal animal) {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL);
			
			stmt.setString(1, animal.getNomeAnimal());
			stmt.setInt(2, animal.getDono().getIdCliente());
			stmt.setInt(3, animal.getTipoAnimal().getTipoAnimalID());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_INSERIR, e);
		}
		
	}


	@Override
	public void deleta(Integer idAnimal) {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL);
			
			stmt.setInt(1, idAnimal);
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
				util.trataErro(ConstantesSistema.MSG_ERRO_DELETAR, e);
		}
		
	}

	@Override
	public List<Animal> recuperaTodos() {
		List<Animal> list = new ArrayList<>();
		try {
			PreparedStatement stmt = con.prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Animal animal = new Animal();
				animal.setAnimalID(rs.getInt("animal_id"));
				animal.setNomeAnimal(rs.getString("nome"));
				//animal.setDono(rs.getInt("id_dono"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public T recupera(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

