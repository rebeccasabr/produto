package br.com.produto.exception;


public abstract class NegocioException extends Exception {
	public static final int FILA_SIS_WEB = 0;
	public static final int FILA_PRODUCAO = 1;

	public NegocioException(String msg) {
		super(msg);
	}
	
	public String getTextoARS() {
		String texto = "";
		texto += this.getMessage();
		return texto;
	}
	
	public abstract int getFila();
	
	public abstract String getSeveridade();
}
