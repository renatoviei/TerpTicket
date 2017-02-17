package dados;

import beans.Cliente;

public class RepositorioCliente implements IRepositorioCliente {
	private Cliente[] usuarios;
	private int quanUsuarios;

	public RepositorioCliente() {
		this.usuarios = new Cliente[100];
		this.quanUsuarios = 0;
	}

	public Cliente[] getUsuario() {
		return usuarios;
	}

	public int getQuantUsuarios() {
		return quanUsuarios;
	}

	public int buscarIndiceCliente(String login) {
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

	public Cliente buscarCliente(String login) {
		if (login != null) {
			Cliente cliente = usuarios[buscarIndiceCliente(login)];
			return cliente;
		}
		return null;

	}

	public boolean cadastrar(Cliente usuario) {
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
		int i = buscarIndiceCliente(login);

		if (i != this.quanUsuarios) {
			this.usuarios[i] = this.usuarios[this.quanUsuarios - 1];
			this.usuarios[this.quanUsuarios - 1] = null;
			this.quanUsuarios--;
		}

		return resposta;
	}

	public boolean existe(String login) {
		boolean existe = false;
		int i = this.buscarIndiceCliente(login);
		if (i != quanUsuarios) {
			existe = true;
		}
		return existe;
	}
}
