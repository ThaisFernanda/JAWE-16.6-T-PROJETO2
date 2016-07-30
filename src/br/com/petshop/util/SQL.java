package br.com.petshop.util;

public class SQL {
	
	public static final String
	INSERE_CONTATO = "INSERT INTO contato(nome, email, endereco, data_nasc) VALUES (?,?,?,?)";
	
	public static final String//USAR O SELECT * FROM... É UMA MÁ PRATICA VC PERDE O CONTROLE DO QUE ESTA SENDO 
	//RETORNADO NA QUERY
	CONSULTA_TODOS_CONTATOS = "SELECT CONTATO_ID, NOME, EMAIL,ENDERECO, DATA_NASC FROM CONTATO";
	
	public static final String
	REMOVE_CONTATO = "DELETE FROM CONTATO WHERE CONTATO_ID =?";
	
	public static final String
	CONSULTA_CONTATO_POR_ID = "SELECT CONTATO_ID, NOME, EMAIL,ENDERECO, DATA_NASC FROM CONTATO WHERE CONTATO_ID = ?";

}
