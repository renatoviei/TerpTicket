package dados;

import beans.Evento;

public interface IRepositorioEventos {

	Evento buscarEvento(String nome);
	
	boolean cadastrar (Evento even);
	
	boolean remover(String desc );
	
	boolean existe(String nome);
}
