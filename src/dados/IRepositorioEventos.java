package dados;

import beans.Evento;

public interface IRepositorioEventos {

	int buscarIndiceNome(String nome);
	
	Evento buscarEvento(String nome);
	
	boolean cadastrar (Evento even);
	
	boolean remover(String desc );
}
