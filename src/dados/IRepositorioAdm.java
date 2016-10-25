package dados;

import beans.Administrador;

public interface IRepositorioAdm {
	
	int buscarIndiceNome(String nome);
	
	Administrador buscarAdm(String nome);
	
	boolean cadastrar(Administrador usuario);

	boolean remover(String nome );

}
