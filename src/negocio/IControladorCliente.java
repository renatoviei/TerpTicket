package negocio;

import beans.Cliente;
import exceções.ClienteBException;
import exceções.ClienteCException;

public interface IControladorCliente {

	abstract boolean cadastrar(Cliente clente) throws ClienteCException;

	abstract Cliente buscarCliente(String login) throws ClienteBException;

	abstract void remover(String login);

	abstract boolean loginCliente(String login, String senha);

}
