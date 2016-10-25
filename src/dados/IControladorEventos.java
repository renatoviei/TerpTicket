package dados;

import beans.Evento;

public interface IControladorEventos {
	
	abstract public boolean cadastrar(Evento event);
	
	abstract public Evento buscarEvento(String nome);
	
	abstract public void remover(String nome);

}
