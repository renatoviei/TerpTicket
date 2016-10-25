package dados;
import beans.Cliente;

public class RepositorioCliente implements IRepositorioCliente{
	private Cliente [] usuarios;
    private int quanUsuarios;
	
    public RepositorioCliente(int tamanho) {
		this.usuarios = new Cliente[tamanho];
		this.quanUsuarios = 0;
	}

	public Cliente[] getUsuario() {
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
		System.out.println("Cliente não existe");
	}
			
		
  }
		return i;
		
	}
	
	public Cliente buscarCliente(String login){
		if(login !=null){
		Cliente cliente = usuarios[buscarIndiceLogin(login)];
		return cliente;
		}else{
			System.out.println("Cliente não existe");
		}
		return null;
		
	}
	
	public boolean cadastrar (Cliente usuario){
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
				System.out.println("Cliente removido com sucesso");
			    }
			else{
				resposta = false;
				System.out.println("Cliente não existe");
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
