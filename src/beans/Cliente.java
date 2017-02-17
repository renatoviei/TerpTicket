package beans;

public class Cliente extends Pessoa {
	private Ingresso[] ingressos;

	public Cliente(String nome, String email, String login, String senha, int idade, Ingresso[] ingresso) {
		super(nome, email, login, senha, idade);
		this.setIngressos(ingresso);

	}

	public Ingresso[] getIngressos() {
		return ingressos;
	}

	public void setIngressos(Ingresso[] ingressos) {
		this.ingressos = ingressos;
	}

}
