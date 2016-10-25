package dados;
import beans.Evento;


public class ControladorEventos implements IControladorEventos {
	private IRepositorioEventos repositorio;

	public ControladorEventos() {
		this.repositorio = new RepositorioEventos();
	}
	
	public boolean cadastrar(Evento event) {
		boolean resposta = false;
		
		if (event == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (!(this.repositorio.existe(event.getNome()))) {
				this.repositorio.cadastrar(event);

				resposta = true;
			} else {
				System.out.println("ERRO! LOGIN JÁ CADASTRADO! (ADMINISTRADOR)");
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
			} else {
				System.out.println("PARAMETRO INVALIDO, DIGITE NOVAMENTE");
			}
		}

	}
	
}
