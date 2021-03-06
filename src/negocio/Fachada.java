package negocio;

import beans.Administrador;
import beans.Cliente;
import beans.Evento;
import beans.Local;
import exceptions.IngInsuficienteException;
import exceptions.NegcExceptions;

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

	public void cadastarEvento(Evento evento)throws NegcExceptions, NumberFormatException {
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

	public void venderIngrClien(int quantIngressos, String busca) throws IngInsuficienteException {
		controladorEvento.venderIngrClien(quantIngressos, busca);
	}

	public void salvarAdm() {
		controladorAdm.salvarAdm();
	}

	public void salvarCliente() {
		controladorCliente.salvarCliente();
	}

	public void salvarEventos() {
		controladorEvento.salvarEventos();
	}

	public String[] retornaTudo() {
		return this.controladorEvento.retornaTudo();
	}
	public void atualiza(Evento even, String nome, int preco, Local local, String bandas){
		controladorEvento.atualiza(even, nome, preco, local, bandas);
	}
}
