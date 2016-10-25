package dados;
import beans.Administrador;


public class RepositorioAdministrador implements IRepositorioAdm {
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
	
	public int buscarIndiceLogin(String login){
		int i;
		for (i = 0; i < usuarios.length; i++) {
			if(usuarios[i].getLogin().equals(login)){
				break;
				
	}else{
		System.out.println("Administrador não existe");
	}
			
		
  }
		return i;
		
	}
	
	public Administrador buscarAdm(String login){
		if(login !=null){
		Administrador adm = usuarios[buscarIndiceLogin(login)];
		return adm;
		}else{
			System.out.println("Administrador não existe");
		}
		return null;
		
	}
	public boolean cadastrar (Administrador usuario){
		boolean resposta = true;
		    if( usuario != null){
			if (this.usuarios[quanUsuarios] == null) {
		     usuarios[quanUsuarios] = usuario;
			quanUsuarios++;
			    
		}
			else
			  resposta = false;
				
    }
		return resposta;
	}

	public boolean remover(String login ){
		boolean resposta = true;
		int i = buscarIndiceLogin(login); 
		
			if (i != this.quanUsuarios){
				this.usuarios[i] = this.usuarios[this.quanUsuarios - 1];
				this.usuarios[this.quanUsuarios - 1] = null;
				this.quanUsuarios--;
			    }
			else{
				resposta = false;
	 }
		return resposta;
	}
	
	public boolean existe(String login) {
		boolean existe = false;
		int i = this.buscarIndiceLogin(login);
		if (i != quanUsuarios) {
			existe = true;
			System.out.println("Administrador existe!");
		} else {
			System.out.println("Administrador não existe!");
		}
		return existe;
	}
	

}



