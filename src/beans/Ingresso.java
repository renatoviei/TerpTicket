package beans;

import java.io.Serializable;

public class Ingresso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long codigo;

	public Ingresso(long codigo) {

		this.codigo = codigo;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

}
