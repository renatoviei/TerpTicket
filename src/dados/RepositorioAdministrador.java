package dados;

import beans.Administrador;

public class RepositorioAdministrador implements IRepositorioAdm {
	private Administrador[] usuarios;
	private int quanUsuarios;
	private static RepositorioAdministrador instance;

	public RepositorioAdministrador() {
		this.usuarios = new Administrador[100];
		this.quanUsuarios = 0;
	}
	
	public static RepositorioAdministrador getInstance() {
		if (instance == null) {
			instance = new RepositorioAdministrador();
		}
		return instance;
	}

	public Administrador[] getUsuarioAdm() {
		return usuarios;
	}

	public int getQuantUsuarios() {
		return quanUsuarios;
	}

	public int buscarIndiceLogin(String login) {
		int i = 0;
		boolean resposta = false;
		while (resposta != true && i < this.quanUsuarios) {
			if (login.equals(this.usuarios[i].getLogin())) {
				resposta = true;
			} else {
				i = i + 1;
			}
		}
		return i;

	}

	public Administrador buscarAdm(String login) {
		Administrador adm = null;
		if (login != null) {
			adm = usuarios[buscarIndiceLogin(login)];

		} else {
			System.out.println("Administrador não existe");
		}
		return adm;

	}

	public boolean cadastrar(Administrador usuario) {
		boolean resposta = true;
		if (usuario != null) {
			if (this.usuarios[quanUsuarios] == null) {
				usuarios[quanUsuarios] = usuario;
				quanUsuarios++;

			} else
				resposta = false;

		}
		return resposta;
	}

	public boolean remover(String login) {
		boolean resposta = true;
		int i = buscarIndiceLogin(login);

		if (i != this.quanUsuarios) {
			this.usuarios[i] = this.usuarios[this.quanUsuarios - 1];
			this.usuarios[this.quanUsuarios - 1] = null;
			this.quanUsuarios--;

		} else {
			resposta = false;
		}
		return resposta;
	}

	public boolean existe(String login) {
		boolean existe = false;
		int i = this.buscarIndiceLogin(login);
		if (i != quanUsuarios) {
			existe = true;

		}
		return existe;
	}

}
