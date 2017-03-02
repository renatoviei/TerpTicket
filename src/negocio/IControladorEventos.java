package negocio;

import beans.Evento;
import exceções.EvenBException;
import exceções.EventCException;

public interface IControladorEventos {

	public abstract boolean cadastrar(Evento event) throws EventCException;

	public abstract Evento buscarEvento(String nome) throws EvenBException;

	public abstract void remover(String nome);

	public abstract boolean existe(String nome);

}
