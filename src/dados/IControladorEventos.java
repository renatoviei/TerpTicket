package dados;

import beans.Evento;

public interface IControladorEventos {

	public abstract boolean cadastrar(Evento event);

	public abstract Evento buscarEvento(String nome);

	public abstract void remover(String nome);

	public abstract boolean existe(String nome);

}
