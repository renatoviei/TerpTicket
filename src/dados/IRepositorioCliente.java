package dados;

import beans.Cliente;

public interface IRepositorioCliente {

	Cliente buscarCliente(String login);

	boolean cadastrar(Cliente usuario);

	boolean remover(String nome);

	boolean existe(String nome);
}
