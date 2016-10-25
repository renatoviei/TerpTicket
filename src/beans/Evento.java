package beans;

import java.util.Arrays;

import beans.Banda;
import beans.Ingresso;
import beans.Local;

public class Evento {
	private String nome;
	private Local local;
	private Banda[] bandas;
	private Ingresso[] ingressos;
	private String hora;   	//GALERA, USA O JAVA.TIME SE POSSIVEL, PQ ACHO Q ASSIM
	private String data;	//FICA FEIOSO

	public Evento(String descriçao, Local local, Banda[] bandas, Ingresso[] ingressos, String hora, String data) {
		this.nome = descriçao;
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

	public String getNome() {
		return nome;
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

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Evento [nome=" + nome + ", local=" + local + ", bandas=" + Arrays.toString(bandas) + ", ingressos="
				+ Arrays.toString(ingressos) + ", hora=" + hora + ", data=" + data + "]";
	}

}
