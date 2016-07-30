package br.com.petshop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.DAO.InterfaceDAO;
import br.com.petshop.modelo.Animal;
import br.com.petshop.modelo.Pessoa;
import br.com.petshop.modelo.TipoAnimal;
import br.com.petshop.util.ConnectionFactory;
import br.com.petshop.util.ConstantesSistema;
import br.com.petshop.util.SQL;
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

			PreparedStatement stmt = con.prepareStatement(SQL.INSERE_ANIMAL);

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
			PreparedStatement stmt = con.prepareStatement(SQL.REMOVE_ANIMAL);

			stmt.setInt(1, idAnimal);

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_DELETAR, e);
		}

	}

	@Override
	public List<Animal> buscaTodos() {
		List<Animal> list = new ArrayList<>();
		try {
			PreparedStatement stmt = con.prepareStatement(SQL.CONSULTA_TODOS_ANIMAL);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				Animal animal = new Animal();
				TipoAnimal tipo = new TipoAnimal();

				animal.setAnimalID(rs.getInt("animal_id"));
				animal.setNomeAnimal(rs.getString("nome"));
				//buscando dono
				pessoa.setIdCliente(rs.getInt("id_dono"));
				animal.setDono(pessoa);

				tipo.setTipoAnimalID(rs.getInt("id_tipo_animal"));
				animal.setTipoAnimal(tipo);


				list.add(animal);

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
	public Animal busca(Integer id) {
		Animal animal = new Animal();
		Pessoa pessoa = new Pessoa();
		TipoAnimal tipo = new TipoAnimal();

		try {
			PreparedStatement stmt =  con.prepareStatement(SQL.CONSULTA_ANIMAL_ID);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				animal.setAnimalID(rs.getInt("animal_id"));
				animal.setNomeAnimal(rs.getString("nome"));
				//buscando dono
				pessoa.setIdCliente(rs.getInt("id_dono"));
				animal.setDono(pessoa);

				tipo.setTipoAnimalID(rs.getInt("id_tipo_animal"));
				animal.setTipoAnimal(tipo);

			}
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_BUSCAR_ID, e);
		}
		return animal;
	}


	public List<Animal> buscaPorTipoAnimal (Integer idTipoAnimal){
		List<Animal>tipos = new ArrayList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(SQL.CONSULTA_ANIMAL_TIPO_ID);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Animal animal = new Animal();
				TipoAnimal tipo = new TipoAnimal();
				
				tipo.setTipoAnimalID(rs.getInt("id_tipo_animal"));
				animal.setTipoAnimal(tipo);
				
				tipos.add(animal);
				
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_BUSCAR_ID, e);
		}
		
		return tipos;
		
	}
	 
	public List<Animal> buscaPorTipoDono (Integer idPessoa){
		List<Animal>donos = new ArrayList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(SQL.CONSULTA_ANIMAL_TIPO_DONO);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Animal animal = new Animal();
				Pessoa pessoa = new Pessoa();
				
				pessoa.setIdCliente(rs.getInt("id_dono"));
				animal.setDono(pessoa);
				
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_BUSCAR_ID, e);
		}
		return donos;
		
	}
	
	public List<Animal> buscaPorTipoDono (String cpf){
		List<Animal>donos = new  ArrayList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(SQL.CONSULTA_ANIMAL_TIPO_DONO_CPF);
			
			stmt.setString(1, cpf);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Animal animal = new Animal();
				Pessoa pessoa = new Pessoa();
				
				pessoa.setCpf(rs.getString("id_dono"));
				animal.setDono(pessoa);
				
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			util.trataErro(ConstantesSistema.MSG_ERRO_BUSCAR_ID, e);
		}
		
		return donos;
		
	}


}

