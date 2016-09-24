package dados;
import beans.Cliente;

public class RepositorioCliente {
	private Cliente [] usuarios;
    private int quanUsuarios;
	
    public RepositorioCliente() {
		this.usuarios = new Cliente[100];
		this.quanUsuarios = 0;
	}

	public Cliente[] getUsuario() {
		return usuarios;
	}

	public int getQuantUsuarios() {
		return quanUsuarios;
	}
	
	public Cliente buscar(String nome){
		for (int i = 0; i < usuarios.length; i++) {
			if(usuarios[i].getNome().equals(nome)){
				Cliente usuario = usuarios[i];
				return usuario;
	}
  
		
  }
		return null;
	}
	public boolean inserir (Cliente usuario){
		boolean aux = true;
		    if( usuario != null){
			if (this.usuarios[quanUsuarios] == null) {
		     usuarios[quanUsuarios] = usuario;
			quanUsuarios++;
			    
		}
			else
				aux = false;
				
    }
		return aux;
	}

	public boolean remover(String nome ){
		boolean aux = true;
		int i;
		for (i = 0; i < usuarios.length; i++) {
			if(this.usuarios[i].getNome().equals(nome))
				break;
		}
			if (i != this.quanUsuarios){
				this.usuarios[i] = this.usuarios[this.quanUsuarios - 1];
				this.usuarios[this.quanUsuarios - 1] = null;
				this.quanUsuarios--;
			    }
			else{
				aux = false;
	 }
		return aux;
	}
	

}
