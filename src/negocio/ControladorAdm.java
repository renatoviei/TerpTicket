package negocio;

import beans.Administrador;
import dados.IRepositorioAdm;
import dados.RepositorioAdministrador;

import java.util.Scanner;

public class ControladorAdm implements IControladorAdm {
	private IRepositorioAdm repositorio;
	private Scanner sc;

	public ControladorAdm() {
		this.repositorio = RepositorioAdministrador.getInstance();
	}

	public boolean cadastrar(Administrador adm) {

		boolean resposta = false;
		if (adm == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (this.repositorio.existe(adm.getLogin()) == false) {
				this.repositorio.cadastrar(adm);
				System.out.println("Administrador criado com sucesso!");
				resposta = true;
			} else {
				System.out.println("ERRO! LOGIN JÁ CADASTRADO. TENTE OUTRO");
			}
		}
		return resposta;
	}

	public Administrador buscarAdm(String login) {
		Administrador adm = null;
		if (this.repositorio.buscarAdm(login) == null) {
			System.out.println("Administrador nao existe");
		} else {
			adm = repositorio.buscarAdm(login);
		}
		return adm;
	}

	public void remover(String login) {

		boolean x = false;

		while (x == false) {
			sc = new Scanner(System.in);
			System.out.println("Digite sua senha:");
			String s = sc.next();
			Administrador aux = null;

			aux = buscarAdm(login);

			if (s.equals(aux.getSenha())) {
				this.repositorio.remover(login);
				x = true;
				System.out.println("Administrador removido");
			} else {
				System.out.println("SENHA ERRADA, DIGITE NOVAMENTE");
			}
		}

	}

	public boolean loginAdm(String login, String senha) {

		boolean logado = false;

		if (repositorio.existe(login) && repositorio.buscarAdm(login).getSenha().equals(senha)) {
			logado = true;
			System.out.println("\nLogin realizado!");
		} else {
			System.out.println("LOGIN NÃO REALIZADO. CONTA NAO EXISTE!");
		}
		return logado;
	}
	
	public void salvarAdm(){
		repositorio.salvarAdm();
	}

}
