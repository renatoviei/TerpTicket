package negocio;

import beans.Administrador;
import beans.Cliente;
import beans.Evento;
import exceções.AdmBException;
import exceções.AdmCException;
import exceções.ClienteBException;
import exceções.ClienteCException;
import exceções.EvenBException;
import exceções.EventCException;

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

	public void cadastarAdm(Administrador adm) throws AdmCException {
		controladorAdm.cadastrar(adm);
	}

	public void cadastarCliente(Cliente cliente) throws ClienteCException {
		controladorCliente.cadastrar(cliente);
	}

	public void cadastarEvento(Evento evento) throws EventCException {
		controladorEvento.cadastrar(evento);
	}

	public Administrador buscarAdm(String login) throws AdmBException {
		return controladorAdm.buscarAdm(login);
	}

	public Cliente buscarCliente(String login) throws ClienteBException {
		return controladorCliente.buscarCliente(login);
	}

	public Evento buscarEvento(String nome) throws EvenBException {
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
