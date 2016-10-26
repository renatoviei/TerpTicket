package GUI;

import java.util.Scanner;

import beans.Administrador;
import beans.Banda;
import beans.Cliente;
import beans.Evento;
import beans.Ingresso;
import beans.Local;
import dados.Fachada;

public class Teste {
	private static Scanner sc;
	private static Scanner sc1;
	private static Scanner sc2;

	public static void main(String[] args) {

		char c = 0;

		sc = new Scanner(System.in);
		sc1 = new Scanner(System.in);
		sc2 = new Scanner(System.in);

		Fachada fachada = new Fachada();

		while (c != 's' || c != 'S') {

			System.out.println("---------------------------TerpTickets---------------------------\n\n"
					+ "Digite um numero\n\n" + "1-Cadastrar-se\n" + "2-Fazer login\n" + "S-Sair\n");

			c = sc.next().charAt(0);

			switch (c) {
			case '1':
				System.out.println("Digite um numero\n\n" + "1-Administrador\n" + "2-Cliente\n");
				c = sc.next().charAt(0);

				switch (c) {
				case '1':
					System.out.println("Digite seu nome: ");
					String nome = sc1.nextLine();

					System.out.println("Digite sua idade: ");
					int idade = sc1.nextInt();

					System.out.println("Digite seu email: ");
					String email = sc1.next();

					System.out.println("Digite seu login: ");
					String login = sc1.next();

					System.out.println("Digite sua senha: ");
					String senha = sc1.next();

					Administrador adm = new Administrador(nome, email, login, senha, idade);
					fachada.cadastarAdm(adm);

					System.out.println("Administrador criado!");
					break;

				case '2':
					System.out.println("Digite seu nome: ");
					String nome1 = sc2.nextLine();

					System.out.println("Digite sua idade: ");
					int idade1 = sc2.nextInt();

					System.out.println("Digite seu email: ");
					String email1 = sc2.next();

					System.out.println("Digite seu login: ");
					String login1 = sc2.next();

					System.out.println("Digite sua senha: ");
					String senha1 = sc2.next();

					Cliente cliente = new Cliente(nome1, email1, login1, senha1, idade1, null);
					fachada.cadastarCliente(cliente);

					System.out.println("\nCliente criado!");
					break;

				default:
					System.out.println("\nOpção inválida");
				}

			case '2':
				System.out.println("Digite um numero\n" + "1-Entrar como administrador\n" + "2-Entrar como cliente");

				c = sc.next().charAt(0);

				switch (c) {
				case '1':
					System.out.println("Digite seu login: ");
					String login = sc1.next();

					System.out.println("Digite sua senha: ");
					String senha = sc1.next();

					if (fachada.loginAdm(login, senha) == true) {

						System.out.println("Digite um numero\n\n" + "1-Criar evento\n" + "2-Buscar evento\n"
								+ "3-Remover conta\n");

						c = sc.next().charAt(0);

						switch (c) {
						case '1':
							System.out.println("Digite a descrição do evento: ");
							String descricao = sc2.nextLine();

							System.out.println("Digite o local do evento e o endereço respectivamente: ");
							Local local = new Local(sc2.nextLine(), sc2.nextLine());

							System.out.println("Digite a quantidade de bandas do evento: ");
							int quantidadeBandas = sc2.nextInt();
							Banda[] bandas = new Banda[quantidadeBandas];

							System.out.println("Digite os nomes das bandas e os seus generos respectivamente: ");
							for (int i = 0; i < quantidadeBandas; i++) {
								bandas[i].setNome(sc2.next());
								bandas[i].setGenero(sc2.next());
							}

							System.out.println("Digite a quantidade de ingressos a ser vendido: ");
							int quantidadeIngressos = sc2.nextInt();
							Ingresso[] ingressos = new Ingresso[quantidadeIngressos];

							System.out.println("Digite o preço, a sensura e a descricao do ingresso: ");
							double preco = sc2.nextDouble();
							String censura = sc2.nextLine();
							String descricaoIngresso = sc2.nextLine();
							for (int i = 0; i < quantidadeIngressos; i++) {
								ingressos[i].setPreco(preco);
								ingressos[i].setCensura(censura);
								ingressos[i].setTipo(descricaoIngresso);
								ingressos[i].setCodigo(i);
							}

							System.out.println("Digite a data e a hora do envento: ");
							String hora = sc2.next();
							String data = sc2.nextLine();

							fachada.cadastarEvento(new Evento(descricao, local, bandas, ingressos, hora, data));

							break;
						case 2:
							System.out.println("Digite o nome do evento que deseja buscar: ");
							String nomeEvento = sc2.next();
							fachada.buscarEvento(nomeEvento);
							break;
						case 3:
							fachada.removerAdm(login);

							break;
						default:
							System.out.println("\nOpção invalida!");
						}
					}
					break;
				case '2':

					System.out.println("Digite seu login: ");
					String login3 = sc2.next();

					System.out.println("Digite sua senha: ");
					String senha3 = sc2.next();

					if (fachada.loginCliente(login3, senha3) == true) {
						System.out.println("Digite um numero\n\n" + "1-Buscar evento\n" + "2-Remover conta\n");

						c = sc.next().charAt(0);

						switch (c) {
						case '1':
							System.out.println("Digite o nome do evento que deseja buscar: ");
							String nomeEvento = sc2.next();
							fachada.buscarEvento(nomeEvento);
							if (fachada.existe(nomeEvento) == true) {
								System.out.println(nomeEvento);
							}

							break;
						case '2':
							System.out.println("Digite a conta a ser removida");
							String login4 = sc2.next();
							fachada.buscarCliente(login4);
							if (fachada.existe(login4) == true) {
								fachada.removerCliente(login4);
								System.out.println("Usuario removido com sucesso!");
							} else {
								System.out.println("Usuário não existe!");
							}
							break;
						default:
							System.out.println("Opção invalida!");

						}
					}
					break;

				default:
					System.out.println("\nOpção inválida");

				}

			}

			System.out.println("Fim de programa!");

		}
	}
}