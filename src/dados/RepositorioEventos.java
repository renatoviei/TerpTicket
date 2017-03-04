package dados;

import java.util.ArrayList;
import java.util.List;

import beans.Evento;

public class RepositorioEventos implements IRepositorioEventos {
	private List<Evento> eventos;

	private static RepositorioEventos instance;

	public RepositorioEventos() {
		this.eventos = new ArrayList<Evento>();

	}

	public static RepositorioEventos getInstance() {
		if (instance == null) {
			instance = new RepositorioEventos();
		}
		return instance;
	}

	public List<Evento> getEventos() {
		return eventos;
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
		return resposta;
	}

	public void remover(String nome) {

		if (existe(nome)) {

			this.eventos.remove(buscarEvento(nome));

		}
	}

	public boolean existe(String nome) {
		boolean existe = false;
		int i = this.buscarIndiceNome(nome);
		if (i != this.eventos.size()) {
			existe = true;
		}

		return existe;
	}

}
