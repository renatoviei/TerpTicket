package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;

public class RepositorioCliente implements IRepositorioCliente, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Cliente> usuarios;

	private static RepositorioCliente instance;

	public RepositorioCliente() {
		this.usuarios = new ArrayList<Cliente>();

	}

	public static RepositorioCliente getInstance() {
		if (instance == null) {
			{
				if (ler() == null) {
					instance = new RepositorioCliente();
				} else {
					instance = (RepositorioCliente) ler();
				}
			}

		}
		return instance;
	}

	public List<Cliente> getUsuario() {
		return usuarios;
	}

	
	public void salvarCliente() {

		try {
			File f = new File("C:\\Users\\Renato\\git\\TerpTicket\\Arquivos\\RepositorioClien.dat");

			FileOutputStream fos = new FileOutputStream(f);

			ObjectOutputStream ous = new ObjectOutputStream(fos);

			ous.writeObject(instance);

			ous.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RepositorioCliente ler() {
		RepositorioCliente rep = null;
		try {

			File f = new File("C:\\Users\\Renato\\git\\TerpTicket\\Arquivos\\RepositorioClien.dat");

			FileInputStream fis = new FileInputStream(f);

			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			if (o != null) {
				rep = (RepositorioCliente) o;
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rep;

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
		this.salvarCliente();
		return resposta;
	}

	public boolean remover(String login) {
		boolean resposta = true;

		if (existe(login)) {

			this.usuarios.remove(buscarCliente(login));
		} else {
			resposta = false;
		}
		this.salvarCliente();
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
