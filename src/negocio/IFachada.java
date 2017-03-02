package negocio;

import beans.Administrador;
import beans.Cliente;
import beans.Evento;
import exce��es.AdmBException;
import exce��es.AdmCException;
import exce��es.ClienteBException;
import exce��es.ClienteCException;
import exce��es.EvenBException;
import exce��es.EventCException;

public interface IFachada {

	abstract void cadastarAdm(Administrador adm) throws AdmCException;

	abstract void cadastarCliente(Cliente cliente) throws ClienteCException;

	abstract void cadastarEvento(Evento evento) throws EventCException;

	abstract Administrador buscarAdm(String login) throws AdmBException;

	abstract Cliente buscarCliente(String login) throws ClienteBException;

	abstract Evento buscarEvento(String nome) throws EvenBException;

	abstract void removerAdm(String login);

	abstract void removerCliente(String login);

	abstract void removerEvento(String nome);

	abstract boolean loginAdm(String login, String senha);

	abstract boolean loginCliente(String login, String senha);

}
