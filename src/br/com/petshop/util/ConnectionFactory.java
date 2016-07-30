package br.com.petshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
		private static final String URL = "jdbc:mysql://localhost/petshop";
		private static final String USER = "root";
		private static final String PASS = "";
		
		private final Util util = new Util();
		
		public Connection getConnection(){
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection(URL,USER,PASS);
				System.out.println("Conexao estabelecida com Sucesso!");
			} catch (SQLException e) {
				util.trataErro(ConstantesSistema.MSG_ERRO_CONNECTION_0001, e);
				
			}catch (Exception e) {
				util.trataErro(ConstantesSistema.MSG_ERRO_CONNECTION_0002, e);
			}
			return con;
		}
}
