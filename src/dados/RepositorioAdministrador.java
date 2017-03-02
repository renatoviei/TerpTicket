package dados;

import java.util.ArrayList;
import java.util.List;

import beans.Administrador;

public class RepositorioAdministrador implements IRepositorioAdm {
	private List<Administrador> usuarios;
	private int quanUsuarios;
	private static RepositorioAdministrador instance;

	public RepositorioAdministrador() {
		this.usuarios = new ArrayList<Administrador>(100);
		this.quanUsuarios = 0;
	}

	public static RepositorioAdministrador getInstance() {
		if (instance == null) {
			instance = new RepositorioAdministrador();
		}
		return instance;
	}

	public List<Administrador> getUsuarioAdm() {
		return usuarios;
	}

	public int getQuantUsuarios() {
		return quanUsuarios;
	}

	public int buscarIndiceLogin(String login) {
		int i = 0;
		boolean resposta = false;
		while (resposta != true && i < this.quanUsuarios) {
			if (login.equals(this.usuarios.get(i).getLogin())) {
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
			adm = this.usuarios.get(buscarIndiceLogin(login));

		}
		return adm;

	}

	public boolean cadastrar(Administrador usuario) {
		boolean resposta = true;
		if (usuario != null) {

			this.usuarios.add(usuario);
			quanUsuarios++;

		} else {
			resposta = false;

		}
		return resposta;
	}

	public boolean remover(String login) {
		boolean resposta = true;

		if (existe(login)) {

			this.usuarios.remove(buscarAdm(login));

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
