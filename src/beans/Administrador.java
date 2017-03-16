package beans;

import java.io.Serializable;

public class Administrador extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador(String nome, String email, String login, String senha, int idade) {
		super(nome, email, login, senha, idade);

	}
	
	

}
