package beans;

public class Local {
	private String casaDeShow;
	private String endereco;
	
	
	public Local(String casaDeShow, String endereco, String hora, String data){
		this.casaDeShow = casaDeShow;
		this.endereco = endereco;
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

	
}
