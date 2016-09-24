package dados;

import beans.Evento;

public class RepositorioEventos {
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
	
	public Evento buscar(String desc){
		for (int i = 0; i < eventos.length; i++) {
			if(eventos[i].getDescriçao() == desc ){
				Evento evento = eventos[i];
				return evento;
	}
  
		
  }
		return null;
	}
	public boolean inserir (Evento even){
		boolean aux = true;
		    if( eventos != null){
			if (this.eventos[quanEventos] == null) {
		     eventos[quanEventos] = even;
			quanEventos++;
			    
		}
			else
				aux = false;
				
    }
		return aux;
	}

	public boolean remover(String desc ){
		boolean aux = true;
		int i;
		for (i = 0; i < eventos.length; i++) {
			if(this.eventos[i].getDescriçao() == desc)
				break;
		}
			if (i != this.quanEventos){
				this.eventos[i] = this.eventos[this.quanEventos - 1];
				this.eventos[this.quanEventos - 1] = null;
				this.quanEventos--;
			    }
			else{
				aux = false;
	 }
		return aux;
	}
	

}



