package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import beans.Evento;
import beans.Local;

public class RepositorioEventos implements IRepositorioEventos, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Evento> eventos;

	private static RepositorioEventos instance;

	public RepositorioEventos() {
		this.eventos = new ArrayList<Evento>();

	}

	public static RepositorioEventos getInstance() {
		if (instance == null) {
			{
				if (ler() == null) {
					instance = new RepositorioEventos();
				} else {
					instance = (RepositorioEventos) ler();
				}
			}

		}
		return instance;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void salvarEventos() {

		try {
			File f = new File("Arquivos\\RepositorioEven.dat");

			FileOutputStream fos = new FileOutputStream(f);

			ObjectOutputStream ous = new ObjectOutputStream(fos);

			ous.writeObject(instance);

			ous.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RepositorioEventos ler() {
		RepositorioEventos rep = null;
		try {

			File f = new File("Arquivos\\RepositorioEven.dat");

			FileInputStream fis = new FileInputStream(f);

			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			if (o != null) {
				rep = (RepositorioEventos) o;
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rep;

	}

	public int buscarIndiceNome(String nome) {
		int i = 0;
		boolean resposta = false;
		while (resposta != true && i < this.eventos.size()) {
			if (nome.equals(this.eventos.get(i).getNome())) {
				resposta = true;
			} else {
				i = i + 1;
			}
		}
		return i;

	}

	public Evento buscarEvento(String nome) {
		Evento evento = null;
		if (nome != null) {
			evento = this.eventos.get(buscarIndiceNome(nome));

		}
		return evento;

	}

	public boolean cadastrar(Evento even) {
		boolean resposta = true;
		if (eventos != null) {

			this.eventos.add(even);

		} else {
			resposta = false;

		}
		this.salvarEventos();
		return resposta;
	}

	public void remover(String nome) {

		if (existe(nome)) {

			this.eventos.remove(buscarEvento(nome));

		}
		this.salvarEventos();
	}

	public boolean existe(String nome) {
		boolean existe = false;
		int i = this.buscarIndiceNome(nome);
		if (i != this.eventos.size()) {
			existe = true;
		}

		return existe;
	}
	
	public String[] retornaTudo() {
		String[] lista = new String[eventos.size() + 1];
		for (int i = 0; i < eventos.size(); i++) {
			lista[i] = eventos.get(i).getNome();
		}
		return lista;
	}
	
	public void atualiza(Evento even, String nome, int preco, Local local, String bandas) {
		if (existe(nome)) {
			even.setNome(nome);
			even.setPreco(preco);
			even.setLocal(local);
			even.setBandas(bandas);
		}

		this.salvarEventos();
	}

}
