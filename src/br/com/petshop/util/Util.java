package br.com.petshop.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Util {

	public void trataErro(String mensagem, Exception ex){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.err.println(dateFormat.format(System.currentTimeMillis())+ mensagem + ex.toString());

	}
}
