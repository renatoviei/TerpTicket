package negocio;

import beans.Cliente;
import exce��es.ClienteBException;
import exce��es.ClienteCException;

public interface IControladorCliente {

	abstract boolean cadastrar(Cliente clente) throws ClienteCException;

	abstract Cliente buscarCliente(String login) throws ClienteBException;

	abstract void remover(String login);

	abstract boolean loginCliente(String login, String senha);

}
