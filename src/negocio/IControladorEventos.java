package negocio;

import beans.Evento;
import exce��es.EvenBException;
import exce��es.EventCException;

public interface IControladorEventos {

	public abstract boolean cadastrar(Evento event) throws EventCException;

	public abstract Evento buscarEvento(String nome) throws EvenBException;

	public abstract void remover(String nome);

	public abstract boolean existe(String nome);

}
