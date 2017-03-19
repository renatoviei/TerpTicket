package negocio;

import beans.Cliente;
import dados.IRepositorioCliente;
import dados.RepositorioCliente;

public class ControladorCliente implements IControladorCliente {
	private IRepositorioCliente repositorio;

	public ControladorCliente() {
		this.repositorio = RepositorioCliente.getInstance();
	}

	public boolean cadastrar(Cliente cliente) {
		boolean resposta = false;
		if (cliente == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (!(this.repositorio.existe(cliente.getLogin()))) {
				this.repositorio.cadastrar(cliente);
				System.out.println("Cliente cadastrado com sucesso! ");
				resposta = true;
			} else {
				System.out.println("ERRO! LOGIN JÁ CADASTRADO. TENTE OUTRO. ");
			}
		}
		return resposta;
	}

	public Cliente buscarCliente(String login) {
		Cliente clien = null;
		if (this.repositorio.buscarCliente(login) == null) {
			System.out.println("Cliente nao existe");
		} else {
			clien = repositorio.buscarCliente(login);
		}
		return clien;
	}

	public void remover(String login) {

		boolean x = false;
		while (x == false) {

			Cliente aux = null;

			aux = buscarCliente(login);

			if (login.equals(aux.getLogin())) {
				this.repositorio.remover(login);
				x = true;
				System.out.println("Cliente removido com sucesso!");
			} else {
				System.out.println("Senha errada, digite novamente");
			}
		}
	}

	public boolean loginCliente(String login, String senha) {
		boolean logado = false;
		if (repositorio.existe(login) && repositorio.buscarCliente(login).getSenha().equals(senha)) {

			logado = true;
			System.out.println("Login realizado com sucesso!");
		} else {
			System.out.println("LOGIN NÃO REALIZADO. CONTA NAO EXISTE!");
		}
		return logado;
	}

	public void salvarCliente() {

		repositorio.salvarCliente();
	}

}