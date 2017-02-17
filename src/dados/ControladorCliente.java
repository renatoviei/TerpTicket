package dados;

import beans.Cliente;
import java.util.Scanner;

public class ControladorCliente implements IControladorCliente {
	private IRepositorioCliente repositorio;
	private Scanner sc;

	public ControladorCliente() {
		this.repositorio = new RepositorioCliente();
	}

	public boolean cadastrar(Cliente cliente) {
		boolean resposta = false;
		if (cliente == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (!(this.repositorio.existe(cliente.getLogin()))) {
				this.repositorio.cadastrar(cliente);
				System.out.println("cliente cadastrado com sucesso! ");
				resposta = true;
			} else {
				System.out.println("ERRO! LOGIN JÁ CADASTRADO! ");
			}
		}
		return resposta;
	}

	public Cliente buscarCliente(String login) {
		return this.repositorio.buscarCliente(login);
	}

	public void remover(String login) {
		sc = new Scanner(System.in);
		boolean x = false;
		while (x == false) {
			System.out.println("Digite sua senha:");
			String s = sc.nextLine();
			Cliente aux = buscarCliente(login);
			if (s.equals(aux.getSenha())) {
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
			System.out.println("LOGIN NÃO REALIZADO!");
		}
		return logado;
	}
}