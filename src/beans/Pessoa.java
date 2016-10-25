package beans;

public class Pessoa {
	private String nome;
	private String email;
	private String login;
	private long senha;
	private int idade;

	public Pessoa(String nome, String email, String login, long senha, int idade) {
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.idade = idade;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getSenha() {
		return senha;
	}

	public void setSenha(long senha) {
		this.senha = senha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
