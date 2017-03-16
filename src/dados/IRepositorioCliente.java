package dados;

import beans.Cliente;

public interface IRepositorioCliente {

	Cliente buscarCliente(String login);

	boolean cadastrar(Cliente usuario);

	boolean remover(String login);

	boolean existe(String nome);
    
	void salvarCliente(); 
}
