package br.com.petshop.teste;

import java.util.List;

import br.com.petshop.DAOImpl.ClienteDAO;
import br.com.petshop.modelo.Pessoa;

public class TestaCliente {

	public static void main(String[] args) {

		//Pessoa pessoa = new Pessoa();
		ClienteDAO dao = new ClienteDAO();
		
		/*cliente.setNome("Gustavo Pereira de Lima");
		cliente.setEmail("guplima@gmail.com");
		cliente.setCpf("12345678900");
		cliente.setTelefone("28282828");
		*/
		//dao.insere(cliente);
		
		//dao.deleta(4);
		
		List<Pessoa> lista = dao.buscaTodos();
		
		for (Pessoa pessoa : lista) {
			System.out.println("ID: "+ pessoa.getIdCliente());
			System.out.println("Nome: "+ pessoa.getNome());
			System.out.println("Email: "+ pessoa.getEmail());
			System.out.println("CPF: "+ pessoa.getCpf());
			System.out.println("Telefone: "+ pessoa.getTelefone());
			System.out.println("***********************************");
		}
		
	}

}
