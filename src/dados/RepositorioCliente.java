package dados;
import beans.Cliente;

public class RepositorioCliente {
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
	
	public int buscarIndiceNome(String nome){
		int i;
		for (i = 0; i < usuarios.length; i++) {
			if(usuarios[i].getNome().equals(nome)){
				break;
				
	}else{
		System.out.println("Cliente não existe");
	}
			
		
  }
		return i;
		
	}
	
	public Cliente buscarCliente(String nome){
		if(nome !=null){
		Cliente cliente = usuarios[buscarIndiceNome(nome)];
		return cliente;
		}else{
			System.out.println("Cliente não existe");
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
		int i = buscarIndiceNome(nome);
		
			if (i != this.quanUsuarios){
				this.usuarios[i] = this.usuarios[this.quanUsuarios - 1];
				this.usuarios[this.quanUsuarios - 1] = null;
				this.quanUsuarios--;
				System.out.println("Cliente removido com sucesso");
			    }
			else{
				aux = false;
				System.out.println("Cliente não existe");
	 }
		return aux;
	}
}
