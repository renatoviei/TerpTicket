package beans;

public class Cliente extends Pessoa {
	private long[] ingressos;
	private int next;

	public Cliente(String nome, String email, String login, String senha, int idade, long[] ingressos) {
		super(nome, email, login, senha, idade);
		this.setIngressos(ingressos);
		this.setNext(0);

	}

	public long[] getIngressos() {
		return ingressos;
	}

	public void setIngressos(long[] ingressos) {
		this.ingressos = ingressos;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public void carrinho(int quantIngressos, long codigo) {
		long[] carrinho = new long[quantIngressos];
		while (quantIngressos > 0) {
			carrinho[this.next] = codigo;
			quantIngressos--;
			this.next++;
		}
		this.ingressos = carrinho;

	}

}
