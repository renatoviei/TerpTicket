package dados;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import beans.Administrador;

public class RepositorioAdministrador implements IRepositorioAdm, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Administrador> usuarios;

	private static RepositorioAdministrador instance;

	public RepositorioAdministrador() {
		this.usuarios = new ArrayList<Administrador>();

	}

	public static RepositorioAdministrador getInstance() {
		if (instance == null) {
			{
				if (ler() == null) {
					instance = new RepositorioAdministrador();
				} else {
					instance = (RepositorioAdministrador) ler();
				}
			}

		}
		return instance;
	}

	public List<Administrador> getUsuarioAdm() {
		return usuarios;
	}

	public void salvarAdm() {

		try {

			FileOutputStream fos = new FileOutputStream(
					"Arquivos\\RepositorioAdm.dat");

			ObjectOutputStream ous = new ObjectOutputStream(fos);

			ous.writeObject(instance);

			ous.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RepositorioAdministrador ler() {
		RepositorioAdministrador rep = null;
		try {

			File f = new File("Arquivos\\RepositorioAdm.dat");

			FileInputStream fis = new FileInputStream(f);

			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			if (o != null) {
				rep = (RepositorioAdministrador) o;
			}
			
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rep;

	}

	public Administrador buscarAdm(String login) {
		Administrador adm = null;
		if (login != null) {
			adm = this.usuarios.get(buscarIndiceLogin(login));

		}
		return adm;

	}

	public int buscarIndiceLogin(String login) {
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

	public boolean cadastrar(Administrador usuario) {
		boolean resposta = true;
		if (usuario != null) {

			this.usuarios.add(usuario);

		} else {
			resposta = false;

		}
		this.salvarAdm();
		return resposta;
	}

	public boolean remover(String login) {
		boolean resposta = true;

		if (existe(login)) {

			this.usuarios.remove(buscarAdm(login));

		} else {
			resposta = false;
		}
		this.salvarAdm();
		return resposta;
	}

	public boolean existe(String login) {
		boolean existe = false;
		int i = this.buscarIndiceLogin(login);
		if (i != this.usuarios.size()) {
			existe = true;

		}
		return existe;
	}

}
