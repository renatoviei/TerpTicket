package negocio;

import beans.Administrador;
import beans.Cliente;
import beans.Evento;
import exceptions.IngInsuficienteException;
import exceptions.NegcExceptions;

public interface IFachada {

	abstract void cadastarAdm(Administrador adm);

	abstract void cadastarCliente(Cliente cliente);

	abstract void cadastarEvento(Evento evento)throws NegcExceptions, NumberFormatException;

	abstract Administrador buscarAdm(String login);

	abstract Cliente buscarCliente(String login);

	abstract Evento buscarEvento(String nome);

	abstract void removerAdm(String login);

	abstract void removerCliente(String login);

	abstract void removerEvento(String nome);

	abstract boolean loginAdm(String login, String senha);

	abstract boolean loginCliente(String login, String senha);

	abstract void venderIngrClien(int quantIngressos, String busca)throws IngInsuficienteException;

	abstract void salvarAdm();

	abstract void salvarCliente();

	abstract void salvarEventos();

	public String[] retornaTudo();
}
