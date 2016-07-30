package br.com.petshop.teste;

import java.sql.Connection;

import br.com.petshop.util.ConnectionFactory;



public class TestaConnection {

	public static void main(String[] args) {
		try {
			//chamo a classe e o metodo
			Connection connection = new ConnectionFactory().getConnection();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
