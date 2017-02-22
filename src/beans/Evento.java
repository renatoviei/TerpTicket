package beans;

import java.util.Arrays;
import beans.Ingresso;
import beans.Local;

public class Evento {
	private String nome;
	private int preco;
	private Local local;
	private String[] bandas;
	private Ingresso ingressos;

	public Evento(String nome, int preco, Local local, String[] bandas, Ingresso ingressos) {
		this.nome = nome;
		this.preco = preco;
		this.local = local;
		this.bandas = bandas;
		this.ingressos = ingressos;

	}

	public String getNome() {
		return nome;
	}

	public int getPreco() {
		return preco;
	}

	public Local getLocal() {
		return local;
	}

	public String[] getBandas() {
		return bandas;
	}

	public Ingresso getIngressos() {
		return ingressos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public void setBandas(String[] bandas) {
		this.bandas = bandas;
	}

	public void setIngressos(Ingresso ingressos) {
		this.ingressos = ingressos;
	}

	@Override
	public String toString() {
		return "Evento: " + nome + "\nPreço: R$ " + preco + ",00" + local + "Bandas: " + Arrays.toString(bandas);
	}

}
