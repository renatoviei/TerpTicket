package negocio;

import beans.Administrador;

public interface IControladorAdm {

	abstract boolean cadastrar(Administrador adm);

	abstract Administrador buscarAdm(String login);

	abstract void remover(String login);

	abstract boolean loginAdm(String login, String senha);
	
	abstract void salvarAdm();

}
