package br.com.petshop.util;

public class SQL {
	
	public static final String
	INSERE_CONTATO = "INSERT INTO petshop.cliente( nome, cpf, telefone, email) values (?, ?, ?, ?)";
	public static final String
	REMOVE_CONTATO ="DELETE FROM petshop.cliente WHERE cliente_id = ?";
	public static final String
	CONSULTA_TODOS_CONTATOS = "SELECT CONTATO_ID, NOME, EMAIL,ENDERECO, DATA_NASC FROM CONTATO";
	
	
}


