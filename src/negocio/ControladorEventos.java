package negocio;

import beans.Evento;
import dados.IRepositorioEventos;
import beans.Local;
import dados.RepositorioEventos;
import exceptions.IngInsuficienteException;

public class ControladorEventos implements IControladorEventos {
	private IRepositorioEventos repositorio;

	public ControladorEventos() {
		this.repositorio = RepositorioEventos.getInstance();
	}

	public boolean cadastrar(Evento event) throws NumberFormatException {
		boolean resposta = false;

		if (event == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {

			if (!(this.repositorio.existe(event.getNome()))) {

				this.repositorio.cadastrar(event);

				resposta = true;
				System.out.println("Evento cadastrado com sucesso!!");
			} else {
				NumberFormatException nfe = new NumberFormatException("Digite um numero");
				// NegcExceptions ngc = new NegcExceptions("ERRO! EVENTO JÁ
				// CADASTRADO. TENTE OUTRO.");
				// System.out.println("ERRO! EVENTO JÁ CADASTRADO. TENTE
				// OUTRO.");
				throw nfe;

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

	public void venderIngrClien(int quantIngressos, String busca) throws IngInsuficienteException {

		int aux = repositorio.buscarEvento(busca).getLocal().getCapacidade();
		if (quantIngressos > 0) {
			repositorio.buscarEvento(busca).getLocal().setCapacidade(aux - quantIngressos);
			System.out.println("\n" + repositorio.buscarEvento(busca));
			salvarEventos();
		} else {
			IngInsuficienteException iie = new IngInsuficienteException();
			throw iie;
		}
	}

	public void salvarEventos() {

		repositorio.salvarEventos();
	}

	public String[] retornaTudo() {
		return this.repositorio.retornaTudo();
	}

	public void atualiza(Evento even, String nome, int preco, Local local, String bandas) {
		repositorio.atualiza(even, nome, preco, local, bandas);
	}

}
