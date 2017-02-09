package dados;
import java.util.Arrays;

import beans.Evento;

public class RepositorioEventos implements IRepositorioEventos {
	private Evento [] eventos;
    private int quanEventos;
  
	
    public RepositorioEventos(){
		this.eventos = new Evento[100];
		this.quanEventos = 0;
	}

	public Evento[] getEventos() {
		return eventos;
	}

	public int getQuantEventos() {
		return quanEventos;
	}
	
	
	public int buscarIndiceNome(String login){
		int i = 0;
		boolean resposta = false;
		while (resposta != true && i < this.quanEventos) {
			if (login.equals(this.eventos[i].getNome())) {
				resposta = true;
			} else {
				i = i + 1;
			}
		}
		return i;
		
	}
	
	public Evento buscarEvento(String nome){
		Evento evento = null;
		if(nome != null){
	    evento = eventos[buscarIndiceNome(nome)];
		
		}else{
			System.out.println("Evento não existe");
		}
		return evento;
		
	}
	public boolean cadastrar (Evento even){
		boolean resposta = true;
		    if( eventos != null){
			if (this.eventos[quanEventos] == null) {
		     eventos[quanEventos] = even;
			quanEventos++;
			    
		}
			else
				resposta = false;
				
    }
		return resposta;
	}

	public boolean remover(String nome ){
		boolean resposta = true;
		int i = buscarIndiceNome(nome);
			if (i != this.quanEventos){
				this.eventos[i] = this.eventos[this.quanEventos - 1];
				this.eventos[this.quanEventos - 1] = null;
				this.quanEventos--;
			    }
			else{
				resposta = false;
	 }
		return resposta;
	}
	
	public boolean existe(String nome) {
		boolean existe = false;
		int i = this.buscarIndiceNome(nome);
		if (i != quanEventos) {
			existe = true;
		} 
		
		return existe;
	}

	@Override
	public String toString() {
		return "RepositorioEventos [eventos=" + Arrays.toString(eventos) + "]";
	}
	
}


