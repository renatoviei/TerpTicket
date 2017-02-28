package dados;

import beans.Evento;

public interface IRepositorioEventos {

	Evento buscarEvento(String nome);

	boolean cadastrar(Evento even);

	void remover(String nome);

	boolean existe(String nome);
}
