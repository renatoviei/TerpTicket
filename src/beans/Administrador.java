package beans;

public class Administrador extends Pessoa {

	private Evento evento;

	public Administrador(String nome, String email, String login, long senha, int idade, Evento evento) {
		super(nome, email, login, senha, idade);
		this.evento = evento; 

	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
