package beans;

import beans.Banda;
import beans.Ingresso;
import beans.Local;

public class Evento {
	private String descriçao;
	private Local local;
	private Banda[] bandas;
	private Ingresso[] ingressos;

	public Evento(String descriçao, Local local, Banda[] bandas, Ingresso[] ingressos) {
		this.descriçao = descriçao;
		this.local = local;
		this.bandas = bandas;
		this.ingressos = ingressos;
	}

	public String getDescriçao() {
		return descriçao;
	}

	public Local getLocal() {
		return local;
	}

	public Banda[] getBandas() {
		return bandas;
	}

	public Ingresso[] getIngressos() {
		return ingressos;
	}

	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public void setBandas(Banda[] bandas) {
		this.bandas = bandas;
	}

	public void setIngressos(Ingresso[] ingressos) {
		this.ingressos = ingressos;
	}

}
