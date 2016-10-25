package dados;

import beans.Administrador;
import beans.Cliente;
import beans.Evento;

public interface IFachada {
	
	  abstract void cadastarAdm(Administrador adm);
	   
	  abstract  void cadastarCliente(Cliente cliente);
	   
	  abstract  void cadastarEvento(Evento evento);
	   
	  abstract Administrador buscarAdm(String login);
	   
	  abstract Cliente buscarCliente(String login);
	   
	  abstract Evento buscarEvento(String nome);
	   
	  abstract void removerAdm(String login);
	   
	  abstract void removerCliente(String login);
	   
	  abstract void removerEvento(String nome);
	  
	  abstract boolean loginAdm(String login, String senha);
	  
	  abstract boolean loginCliente(String login, String senha);
	
}
