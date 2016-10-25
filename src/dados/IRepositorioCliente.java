package dados;

import beans.Cliente;

public interface IRepositorioCliente {
	
	int buscarIndiceNome(String nome);
	
	Cliente buscarCliente(String nome);
	
	boolean cadastrar (Cliente usuario);

	boolean remover(String nome );
}
