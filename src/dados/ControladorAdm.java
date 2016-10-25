package dados;
import beans.Administrador;
import java.util.Scanner;

public class ControladorAdm implements IControladorAdm {
	private IRepositorioAdm repositorio;
	private Scanner sc;

	public ControladorAdm() {
		this.repositorio = new RepositorioAdministrador();
	}

	public boolean cadastrar(Administrador adm) {
		
		boolean resposta = false;
		if (adm == null) {
			System.out.println("PARAMETRO INVALIDO");
		} else {
			if (this.repositorio.existe(adm.getLogin()) == false) {
				this.repositorio.cadastrar(adm);

				resposta = true;
			} else {
				System.out.println("ERRO! LOGIN JÁ CADASTRADO! (ADMINISTRADOR)");
			}
		}
		return resposta;
	}
	
	public Administrador buscarAdm(String login) {
		return this.repositorio.buscarAdm(login);
	}
	
	public void remover(String login) {
		
		sc = new Scanner(System.in);
		boolean x = false;
		
		while (x == false) {
			
			System.out.println("Digite sua senha:");
			String s = sc.nextLine();
			Administrador aux = buscarAdm(login);
			System.out.println("ADM REMOVIDO");
			
			if (s == aux.getSenha()) {
				this.repositorio.remover(login);
				x = true;
			} else {
				System.out.println("SENHA ERRADA, DIGITE NOVAMENTE");
			}
		}

	}
	
	public boolean loginAdm(String login, String senha) {
		
		boolean logado = false;
		
		if (repositorio.existe(login) && repositorio.buscarAdm(login).getSenha().equals(senha)) {
			logado = true;
			System.out.println("LOGIN REALIZADO COM SUCESSO");
		} else {
			System.out.println("LOGIN NÃO REALIZADO");
		}
		return logado;
	}

}
