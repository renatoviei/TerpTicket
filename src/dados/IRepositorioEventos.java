package dados;

import beans.Evento;
import beans.Ingresso;
import beans.Local;

public interface IRepositorioEventos {

	Evento buscarEvento(String nome);

	boolean cadastrar(Evento even);

	void remover(String nome);

	boolean existe(String nome);

	void salvarEventos();

	public String[] retornaTudo();

	void atualiza(Evento even, String nome, int preco, Local local, String bandas);
}
