package negocio;

import beans.Evento;
import dados.IRepositorioEventos;
import dados.RepositorioEventos;

public class ControladorEventos implements IControladorEventos {
	private IRepositorioEventos repositorio;

	public ControladorEventos() {
		this.repositorio = RepositorioEventos.getInstance();
	}

	public boolean cadastrar(Evento event) {
		boolean resposta = false;

		if (event == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (!(this.repositorio.existe(event.getNome()))) {
				this.repositorio.cadastrar(event);
				resposta = true;
				System.out.println("Evento cadastrado com sucesso!!");
			} else {
				System.out.println("EVENTO JÁ CADASTRADO!");
			}
		}
		return resposta;
	}

	public Evento buscarEvento(String nome) {

		return this.repositorio.buscarEvento(nome);
	}

	public void remover(String nome) {

		boolean x = false;
		while (x == false) {

			if (nome != null) {
				this.repositorio.remover(nome);
				x = true;
				System.out.println("Evento removido com sucesso!");
			} else {
				System.out.println("NOME INVALIDO, DIGITE NOVAMENTE");
			}
		}

	}

	public boolean existe(String nome) {
		return this.repositorio.existe(nome);
	}

}
