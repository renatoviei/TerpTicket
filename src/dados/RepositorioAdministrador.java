package dados;

import beans.Administrador;

public class RepositorioAdministrador {
	private Administrador[] usuarios;
    private int quanUsuarios;
	
    public RepositorioAdministrador() {
		this.usuarios = new Administrador[100];
		this.quanUsuarios = 0;
	}

	public Administrador[] getUsuarioAdm() {
		return usuarios;
	}

	public int getQuantUsuarios() {
		return quanUsuarios;
	}
	
	public Administrador buscar(String nome){
		for (int i = 0; i < usuarios.length; i++) {
			if(usuarios[i].getNome().equals(nome)){
				Administrador usuario = usuarios[i];
				return usuario;
	}
  
		
  }
		return null;
	}
	public boolean inserir (Administrador usuario){
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



