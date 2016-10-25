package beans;

public class Ingresso  {
	
	private int codigo;
	private double preco;
	private String censura;
	private String descricao;

	public Ingresso(int codigo, double preco, String censura, String tipo) {

		this.codigo = codigo;
		this.preco = preco;
		this.censura = censura;
		this.descricao = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCensura() {
		return censura;
	}

	public void setCensura(String censura) {
		this.censura = censura;
	}

	public String getTipo() {
		return descricao;
	}

	public void setTipo(String tipo) {
		this.descricao = tipo;
		
		
	}


}
