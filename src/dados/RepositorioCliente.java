package dados;

import java.util.ArrayList;
import java.util.List;

import beans.Cliente;

public class RepositorioCliente implements IRepositorioCliente {
	private List<Cliente> usuarios;

	private static RepositorioCliente instance;

	public RepositorioCliente() {
		this.usuarios = new ArrayList<Cliente>();

	}

	public static RepositorioCliente getInstance() {
		if (instance == null) {
			instance = new RepositorioCliente();
		}
		return instance;
	}

	public List<Cliente> getUsuario() {
		return usuarios;
	}

	public int buscarIndiceCliente(String login) {
		int i = 0;
		boolean resposta = false;
		while (resposta != true && i < this.usuarios.size()) {
			if (login.equals(this.usuarios.get(i).getLogin())) {
				resposta = true;
			} else {
				i = i + 1;
			}
		}
		return i;

	}

	public Cliente buscarCliente(String login) {
		Cliente cliente = null;
		if (login != null) {
			cliente = this.usuarios.get(buscarIndiceCliente(login));

		}
		return cliente;

	}

	public boolean cadastrar(Cliente usuario) {
		boolean resposta = true;
		if (usuario != null) {

			this.usuarios.add(usuario);

		} else {
			resposta = false;

		}
		return resposta;
	}

	public boolean remover(String login) {
		boolean resposta = true;

		if (existe(login)) {

			this.usuarios.remove(buscarCliente(login));
		} else {
			resposta = false;
		}

		return resposta;
	}

	public boolean existe(String login) {
		boolean existe = false;
		int i = this.buscarIndiceCliente(login);
		if (i != this.usuarios.size()) {
			existe = true;
		}
		return existe;
	}

}
