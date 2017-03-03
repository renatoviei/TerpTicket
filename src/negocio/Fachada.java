package negocio;

import beans.Administrador;
import beans.Cliente;
import beans.Evento;

public class Fachada implements IFachada {
	private IControladorAdm controladorAdm;
	private IControladorCliente controladorCliente;
	private IControladorEventos controladorEvento;
	private static Fachada instance;

	public Fachada() {
		this.controladorAdm = new ControladorAdm();
		this.controladorCliente = new ControladorCliente();
		this.controladorEvento = new ControladorEventos();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public void cadastarAdm(Administrador adm) {
		controladorAdm.cadastrar(adm);
	}

	public void cadastarCliente(Cliente cliente) {
		controladorCliente.cadastrar(cliente);
	}

	public void cadastarEvento(Evento evento) {
		controladorEvento.cadastrar(evento);
	}

	public Administrador buscarAdm(String login) {
		return controladorAdm.buscarAdm(login);
	}

	public Cliente buscarCliente(String login) {
		return controladorCliente.buscarCliente(login);
	}

	public Evento buscarEvento(String nome) {
		return controladorEvento.buscarEvento(nome);
	}

	public boolean existe(String nome) {
		return controladorEvento.existe(nome);
	}

	public void removerAdm(String login) {
		controladorAdm.remover(login);
	}

	public void removerCliente(String login) {
		controladorCliente.remover(login);
	}

	public void removerEvento(String nome) {
		controladorEvento.remover(nome);
	}

	public boolean loginAdm(String login, String senha) {
		return controladorAdm.loginAdm(login, senha);
	}

	public boolean loginCliente(String login, String senha) {
		return controladorCliente.loginCliente(login, senha);
	}

}
