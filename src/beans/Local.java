package beans;

public class Local {
	private String casaDeShow;
	private String endereco;
	private String hora;   	//GALERA, USA O JAVA.TIME SE POSSIVEL, PQ ACHO Q ASSIM
	private String data;	//FICA FEIOSO

	public Local(String casaDeShow, String endereco, String hora, String data){
		this.casaDeShow = casaDeShow;
		this.endereco = endereco;
		this.hora = hora;
		this.data = data;
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
}
