package negocio;

import beans.Evento;
import dados.IRepositorioEventos;
import dados.RepositorioEventos;
import exceções.EvenBException;
import exceções.EventCException;

public class ControladorEventos implements IControladorEventos {
	private IRepositorioEventos repositorio;

	public ControladorEventos() {
		this.repositorio = RepositorioEventos.getInstance();
	}

	public boolean cadastrar(Evento event) throws EventCException {
		boolean resposta = false;

		if (event == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (!(this.repositorio.existe(event.getNome()))) {
				this.repositorio.cadastrar(event);
				resposta = true;
				System.out.println("Evento cadastrado com sucesso!!");
			} else {
				EventCException evenc = new EventCException(event);
				throw evenc;
			}
		}
		return resposta;
	}

	public Evento buscarEvento(String nome) throws EvenBException {
		Evento even = null;
		if (this.repositorio.buscarEvento(nome) == null) {
			EvenBException evenb = new EvenBException(nome);
			throw evenb;
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

}
