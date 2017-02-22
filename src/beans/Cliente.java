package beans;

public class Cliente extends Pessoa {
	private long[] ingressos;

	public Cliente(String nome, String email, String login, String senha, int idade, long[] ingressos) {
		super(nome, email, login, senha, idade);
		this.setIngressos(ingressos);

	}

	public long[] getIngressos() {
		return ingressos;
	}

	public void setIngressos(long[] ingressos) {
		this.ingressos = ingressos;
	}

}
