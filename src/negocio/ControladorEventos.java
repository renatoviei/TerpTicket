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
				System.out.println("ERRO! EVENTO JÁ CADASTRADO. TENTE OUTRO.");
			}
		}
		return resposta;
	}

	public Evento buscarEvento(String nome) {
		Evento even = null;
		if (this.repositorio.buscarEvento(nome) == null) {
			System.out.println("Evento não existe");
		} else {
			even = repositorio.buscarEvento(nome);
		}
		return even;
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

	public void venderIngrClien(int quantIngressos, String busca) {

		int aux = repositorio.buscarEvento(busca).getLocal().getCapacidade();

		repositorio.buscarEvento(busca).getLocal().setCapacidade(aux - quantIngressos);
		System.out.println("\n" + repositorio.buscarEvento(busca));
        salvarEventos();
	}

	public void salvarEventos() {

		repositorio.salvarEventos();
	}

}
