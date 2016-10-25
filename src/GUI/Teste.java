package GUI;
import java.util.Scanner;

import beans.Administrador;
import beans.Cliente;
import dados.Fachada;

public class Teste {
	private static Scanner sc;
	private static Scanner sc1;
	private static Scanner sc2;
	
	public static void main(String [] args){
		
		char c = 0;
		
		sc = new Scanner(System.in);
		sc1 = new Scanner(System.in);
		sc2 = new Scanner(System.in);
		
		Fachada fachada = new Fachada();
		
		while(c != 's' || c!='S'){
	    
		System.out.println("---------------------------TerpTickets---------------------------\n\n"+
	                        "Digite um numero\n\n"+
	                        "1-Cadastrar-se\n"+
	                        "2-Fazer login\n"+
	                        "S-Sair\n");
		
		c = sc.next().charAt(0);
		
		switch(c){
		case '1': 
			     System.out.println("Digite um numero\n\n"+
		                            "1-Administrador\n"+
					                "2-Cliente\n");
			     c = sc.next().charAt(0);
				
			     switch(c){
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
			 System.out.println("Digite um numero\n"+
                     "1-Entrar como administrador\n"+
		             "2-Entrar como cliente");
			 
			 c = sc.next().charAt(0);
				
			 switch(c){
		     case '1':
					    System.out.println("Digite seu login: ");
					    String login = sc1.next();
					    
					    System.out.println("Digite sua senha: ");
					    String senha = sc1.next();
					    
					    if(fachada.loginAdm(login, senha)== true){
					    	
					    	System.out.println("Digite um numero\n\n"+
				                     "1-Criar evento\n"+
						             "2-Buscar evento\n"+
				                     "3-Remover conta\n");
					    	
					    	c = sc.next().charAt(0);
							
					    	switch(c){
							case 1:
								   
							        break;	   
							case 2:
						     
							        break;	   
							case 3:
							     
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
				    
				         if(fachada.loginCliente(login3, senha3) == true){
				    	 System.out.println("Digite um numero\n\n"+
			                                "1-Buscar evento\n"+
			                                "2-Remover conta\n");
				    	
				    	 c = sc.next().charAt(0);
						
				    	switch(c){
						case '1':
							   
						          break;	   
						case '2':
					     
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