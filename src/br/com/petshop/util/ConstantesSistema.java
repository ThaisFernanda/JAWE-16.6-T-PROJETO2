package br.com.petshop.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConstantesSistema {
	
	public static final String MSG_ERRO_CONNECTION_0001 = "001 - Problema ao tentar criar uma nova conexao - Erro";
	public static final String MSG_ERRO_CONNECTION_0002 = "002 - Erro ao tentar criar uma nova conexao - Erro";
	
	//ERROS DAO
	public static final String MSG_ERRO_DAO_0001 = "001 - Erro ao tentar BUSCAR POR ID - Erro";
	public static final String MSG_ERRO_DAO_0002 = "002 - Erro ao tentar BUSCAR TODOS - Erro";
	public static final String MSG_ERRO_INSERIR = "003 - Erro ao tentar INSERIR - Erro";
	public static final String MSG_ERRO_DELETAR = "004 - Erro ao tentar REMOVER - Erro";
	
	//ERROS WEB
	public static final String MSG_ERRO_WEB_0001 = "001 - Erro ao tentar INSERIR DATA- Erro";
	
	//ENCERRAR CONEXÔES
	public static void encerrarConexoes(PreparedStatement stmt, Connection con){
		
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao tentar encerrar as conexões");
			e.printStackTrace();
		}
		
	}
}
