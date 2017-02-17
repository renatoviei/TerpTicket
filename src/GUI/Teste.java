package GUI;

import java.util.Random;

import java.util.Scanner;
import beans.Administrador;
import beans.Cliente;
import beans.Evento;
import beans.Ingresso;
import beans.Local;
import dados.Fachada;
import dados.RepositorioAdministrador;
import dados.RepositorioEventos;

public class Teste {
	private static Scanner sc;
	private static Scanner sc1;

	public static void main(String[] args) {

		char cond = 0;
		sc = new Scanner(System.in);
		sc1 = new Scanner(System.in);
		Fachada fachada = new Fachada();

		while (cond != '3' || cond != '3') {

			System.out.println("---------------------------TerpTickets---------------------------\n\n"
					+ "Escolha uma opçao\n\n" + "1-Cadastrar-se\n" + "2-Fazer login\n" + "3-Sair\n");

			cond = sc.next().charAt(0);

			switch (cond) {
			case '1':
				System.out.println("Escolha uma opçao\n\n" + "1-Cadastrar administrador\n" + "2-Cadastrar cliente\n");
				char menu1 = sc.next().charAt(0);

				switch (menu1) {
				case '1':
					System.out.print("Digite seu nome: ");
					String nome = sc1.nextLine();

					System.out.print("Digite sua idade: ");
					int idade = sc1.nextInt();
					sc1.nextLine();
					System.out.print("Digite seu email: ");
					String email = sc1.nextLine();

					System.out.print("Crie seu login: ");
					String login = sc1.nextLine();

					System.out.print("Crie sua senha: ");
					String senha = sc1.nextLine();

					Administrador adm = new Administrador(nome, email, login, senha, idade);
					fachada.cadastarAdm(adm);
					RepositorioAdministrador adm1 = new RepositorioAdministrador();
					System.out.println(adm1.getUsuarioAdm());

					break;

				case '2':
					System.out.print("Digite seu nome: ");
					String nome1 = sc1.nextLine();

					System.out.print("Digite sua idade: ");
					int idade1 = sc1.nextInt();
					sc1.nextLine();
					System.out.print("Digite seu email: ");
					String email1 = sc1.nextLine();

					System.out.print("Crie seu login: ");
					String login1 = sc1.nextLine();

					System.out.print("Crie sua senha: ");
					String senha1 = sc1.nextLine();

					Cliente cliente = new Cliente(nome1, email1, login1, senha1, idade1, null);
					fachada.cadastarCliente(cliente);

					System.out.println("\nCliente criado!");
					break;

				default:
					System.out.println("\nOpção inválida");
				}
				break;

			case '2':
				System.out
						.println("\nEscolha uma opçao\n" + "\n1-Entrar como administrador\n" + "2-Entrar como cliente");

				char menu2 = sc.next().charAt(0);

				switch (menu2) {
				case '1':
					System.out.println("Digite seu login: ");
					String login = sc1.next();

					System.out.println("Digite sua senha: ");
					String senha = sc1.next();

					if (fachada.loginAdm(login, senha) == true) {

						System.out.println("\nEscolha uma opçao\n" + "\n1-Criar evento\n" + "2-Remover evento\n"
								+ "3-Remover conta\n");
					}
					char menu21 = sc.next().charAt(0);

					switch (menu21) {
					case '1':
						System.out.println("Digite o nome do evento: ");
						Scanner sc2 = new Scanner(System.in);
						String nomeDoEvento = sc2.nextLine();
						sc1.nextLine();

						System.out.println("Digite o preço do ingresso: ");
						int preco = sc1.nextInt();
						sc1.nextLine();

						System.out.println("Digite o nome da casa de shows: ");
						String casaDeShow = sc1.nextLine();

						System.out.println("Digite o endereço da casa de shows: ");
						String endereço = sc1.nextLine();

						System.out.println("Digite a data e horário do evento no seguinte modelo 'DD/MM/AA HH:MM': ");
						String dataHorario = sc1.nextLine();

						System.out.println("Digite a capacidade de lotação da casa: ");
						int capacidade = sc1.nextInt();
						sc1.nextLine();

						Local local = new Local(casaDeShow, endereço, dataHorario, capacidade);

						System.out.println("Digite a quantidade de bandas: ");
						int quantBandas = sc1.nextInt();
						sc1.nextLine();

						String[] bandas = new String[quantBandas];

						System.out.println("Digite os nomes das bandas: ");
						for (int i = 0; i < bandas.length; i++) {
							bandas[i] = sc1.nextLine();

						}
						Random radom = new Random();
						long codigo = 0;
						for (int i = 0; i < 10; i++) {
							codigo = radom.nextInt(1000000001);
							if (codigo >= 99999999) {
								break;
							}
						}
						Ingresso ingressos = new Ingresso(codigo);

						Evento evento = new Evento(nomeDoEvento, preco, local, bandas, ingressos);
						fachada.cadastarEvento(evento);

						System.out.println(fachada.buscarEvento(nomeDoEvento));
						System.out.println(fachada.buscarEvento(nomeDoEvento).getIngressos().getCodigo());
						break;
					case '2':
						System.out.println("Digite o nome do evento: ");
						String nome1 = sc1.nextLine();
						sc1.nextLine();

						fachada.removerEvento(nome1);
						RepositorioEventos repositorio1 = new RepositorioEventos();
						System.out.println(repositorio1.getEventos());

						break;
					case '3':
						fachada.removerAdm(login);
						RepositorioAdministrador adm2 = new RepositorioAdministrador();
						System.out.println(adm2.getQuantUsuarios());

						break;

					default:
						System.out.println("\nOpção invalida!");
					}

					break;
				case '2':

					System.out.println("Digite seu login: ");
					String login3 = sc1.next();

					System.out.println("Digite sua senha: ");
					String senha3 = sc1.next();

					if (fachada.loginCliente(login3, senha3) == true) {
						System.out.println(
								"\nEscolha uma opçao\n\n" + "1-Buscar evento\n" + "2-Remover conta\n" + "s-sair\n");

						char menu3 = sc.next().charAt(0);

						switch (menu3) {
						case '1':
							System.out.println("\nDigite o nome do evento: ");
							Scanner sc3 = new Scanner(System.in);
							String busca = sc3.nextLine();

							System.out.println("\n" + fachada.buscarEvento(busca));
							System.out.println(fachada.buscarEvento(busca).getIngressos().getCodigo());
							System.out.println("\nQuantidade de ingressos: "
									+ fachada.buscarEvento(busca).getLocal().getCapacidade());

							if (fachada.buscarEvento(busca).getLocal().getCapacidade() > 0) {

								System.out.println("\nQuantidade de ingressos que deseja comprar :");
								int quantIngressos = sc1.nextInt();
								int aux = fachada.buscarEvento(busca).getLocal().getCapacidade();

								fachada.buscarEvento(busca).getLocal().setCapacidade(aux - quantIngressos);
								System.out.println("\n" + fachada.buscarEvento(busca));

								System.out.println("\nQuantidade de ingressos: "
										+ fachada.buscarEvento(busca).getLocal().getCapacidade());
								System.out.println(
										"\nAgora escolha a forma de pagamento e obrigado por escolher a TerpTickets!");
							} else {
								System.out.println("\nIngressos esgotados!");
							}
							break;
						case '2':
							fachada.removerCliente(login3);

							break;
						case 's':
							break;
						default:
							System.out.println("Opção invalida!");
						}
					}
					break;

				default:
					System.out.println("\nOpção inválida");

				}
			case '3':
				sc.nextLine();
				break;
			default:
				System.out.println("Opção inválida!");

			}

		}
		System.out.println("Muito obrigado e volte sempre!");
	}
}