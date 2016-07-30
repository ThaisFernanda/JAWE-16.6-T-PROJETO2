package br.com.petshop.DAO;

import java.util.List;

public interface InterfaceDAO <T> {
	
	public void insere (T obj);
	
	//public void update (T obj);
	
	public void deleta (Integer id);
	
	public List<T> buscaTodos();
	
	public T busca (Integer id);
	
}
