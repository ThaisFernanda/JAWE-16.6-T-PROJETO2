package br.com.petshop.util;

public class SQL {

	//CRUD PESSOA
	public static final String
	INSERE_PESSOA = "INSERT INTO cliente( nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
	public static final String
	REMOVE_PESSOA ="DELETE FROM cliente WHERE cliente_id = ?";
	public static final String
	CONSULTA_TODOS_CONTATOS = "SELECT cliente_id, nome, cpf, telefone, email FROM petshop.cliente";
	public static final String
	CONSULTA_PESSOA_ID = "SELECT cliente_id, nome, cpf, telefone, email FROM cliente WHERE cliente_id = ?";
	public static final String
	CONSULTA_PESSOA_CPF = "SELECT cliente_id, nome, cpf, telefone, email FROM petshop.cliente WHERE cpf = ?";
	
	//CRUD ANIMAL
	public static final String
	INSERE_ANIMAL = "INSERT INTO petshop.animal (nome, id_dono, id_tipo_animal) VALUES (?,?,?)";
	public static final String
	REMOVE_ANIMAL = "DELETE FROM petshop.animal WHERE animal_id = ?";
	public static final String
	REMOVE_ANIMAL_ID_DONO = "DELETE FROM animal WHERE id_dono = ?";
	public static final String
	CONSULTA_TODOS_ANIMAL= "SELECT animal_id, nome, id_dono, id_tipo_animal FROM petshop.animal";
	public static final String
	CONSULTA_ANIMAL_ID = "SELECT animal_id, nome, id_dono, id_tipo_animal FROM petshop.animal WHERE animal_id = ?";
	public static final String
	CONSULTA_ANIMAL_TIPO_ANIMAL = "SELECT animal_id, nome, id_dono, id_tipo_animal FROM petshop.animal WHERE id_tipo_animal = ?";
	public static final String
	CONSULTA_ANIMAL_TIPO_DONO = "SELECT animal_id, nome, id_dono, id_tipo_animal FROM petshop.animal WHERE id_dono = ?";
	public static final String
	CONSULTA_ANIMAL_TIPO_DONO_CPF = "SELECT animal_id, nome, id_dono, id_tipo_animal FROM petshop.animal WHERE id_dono = (SELECT cliente_id FROM cliente WHERE cpf = ?)";
	
	//CRUD TIPO ANIMAL
	public static final String
	INSERE_TIPO_ANIMAL ="INSERT INTO tipo_animal(tipo) VALUES (?)";
	public static final String
	REMOVE_TIPO_ANIMAL ="DELETE FROM tipo_animal WHERE tipo_animal_id = ?";
	public static final String
	CONSULTA_TODOS_TIPO_ANIMAL ="SELECT tipo_animal_id, tipo FROM tipo_animal";
	public static final String
	CONSULTA_ANIMAL_TIPO_ID="SELECT tipo_animal_id, tipo FROM tipo_animal WHERE tipo_animal_id = ?";


}


