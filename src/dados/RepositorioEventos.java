package dados;

import java.util.ArrayList;
import java.util.List;

import beans.Evento;

public class RepositorioEventos implements IRepositorioEventos {
	private List<Evento> eventos;
	private int quanEventos;
	private static RepositorioEventos instance;

	public RepositorioEventos() {
		this.eventos = new ArrayList<Evento>(100);
		this.quanEventos = 0;
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

	public int getQuantEventos() {
		return quanEventos;
	}

	public int buscarIndiceNome(String nome) {
		int i = 0;
		boolean resposta = false;
		while (resposta != true && i < this.quanEventos) {
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
			quanEventos++;

		} else {
			resposta = false;

		}
		return resposta;
	}

	public void remover(String nome) {

		if (existe(nome)) {

			this.eventos.remove(eventos.get(buscarIndiceNome(nome)));

		}
	}

	public boolean existe(String nome) {
		boolean existe = false;
		int i = this.buscarIndiceNome(nome);
		if (i != quanEventos) {
			existe = true;
		}

		return existe;
	}

}
