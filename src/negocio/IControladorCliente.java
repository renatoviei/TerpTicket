package negocio;

import beans.Cliente;

public interface IControladorCliente {

	abstract boolean cadastrar(Cliente clente);

	abstract Cliente buscarCliente(String login);

	abstract void remover(String login);

	abstract boolean loginCliente(String login, String senha);

}
