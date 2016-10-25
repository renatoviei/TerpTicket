package dados;
import beans.Evento;

public class RepositorioEventos implements IRepositorioEventos {
	private Evento [] eventos;
    private int quanEventos;
	
    public RepositorioEventos(int tamanho){
		this.eventos = new Evento[tamanho];
		this.quanEventos = 0;
	}

	public Evento[] getEventos() {
		return eventos;
	}

	public int getQuantEventos() {
		return quanEventos;
	}
	
	public int buscarIndiceNome(String nome){
		int i;
		for (i = 0; i < eventos.length; i++) {
			if(eventos[i].getDescriçao().equals(nome)){
				break;
				
	}else{
		System.out.println("evento não existe");
	}
			
		
  }
		return i;
		
	}
	
	public Evento buscarEvento(String nome){
		if(nome !=null){
		Evento evento = eventos[buscarIndiceNome(nome)];
		return evento;
		}else{
			System.out.println("Evento não existe");
		}
		return null;
		
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

	public boolean remover(String desc ){
		boolean resposta = true;
		int i = buscarIndiceNome(desc);
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
			System.out.println("Administrador existe!");
		} else {
			System.out.println("Administrador não existe!");
		}
		return existe;
	}
}



