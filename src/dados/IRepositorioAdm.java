package dados;

import beans.Administrador;

public interface IRepositorioAdm {

	Administrador buscarAdm(String login);

	boolean cadastrar(Administrador usuario);

	boolean remover(String nome);

	boolean existe(String nome);
	
	void salvarAdm();

}
