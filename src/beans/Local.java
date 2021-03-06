package beans;

import java.io.Serializable;

public class Local implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String casaDeShow;
	private String endereco;
	private String dataHorario;
	private int capacidade;

	public Local(String casaDeShow, String endereco, String dataHorario, int capacidade) {
		super();
		this.casaDeShow = casaDeShow;
		this.endereco = endereco;
		this.dataHorario = dataHorario;
		this.capacidade = capacidade;
	}

	public String getCasaDeShow() {
		return casaDeShow;
	}

	public void setCasaDeShow(String casaDeShow) {
		this.casaDeShow = casaDeShow;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataHorario() {
		return dataHorario;
	}

	public void setDataHorario(String dataHorario) {
		this.dataHorario = dataHorario;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return "\nLocal do evento: " + casaDeShow + "\nEndereco: " + endereco + "\nInicio: " + dataHorario
				+ "\nIngressos restantes: " + capacidade +"\n";
	}

}