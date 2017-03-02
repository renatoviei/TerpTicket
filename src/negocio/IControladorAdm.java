package negocio;

import beans.Administrador;
import exce��es.AdmBException;
import exce��es.AdmCException;

public interface IControladorAdm {

	abstract boolean cadastrar(Administrador adm) throws AdmCException;

	abstract Administrador buscarAdm(String login) throws AdmBException;

	abstract void remover(String login);

	abstract boolean loginAdm(String login, String senha);

}
