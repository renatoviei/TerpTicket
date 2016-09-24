package beans;

import beans.Banda;
import beans.Ingresso;
import beans.Local;

public class Evento {
	private String descriçao;
	private Local local;
	private Banda[] bandas;
	private Ingresso[] ingressos;
	private String hora;   	//GALERA, USA O JAVA.TIME SE POSSIVEL, PQ ACHO Q ASSIM
	private String data;	//FICA FEIOSO

	public Evento(String descriçao, Local local, Banda[] bandas, Ingresso[] ingressos, String hora, String data) {
		this.descriçao = descriçao;
		this.local = local;
		this.bandas = bandas;
		this.ingressos = ingressos;
		this.hora = hora;
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
