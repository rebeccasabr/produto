package br.com.produto.exception;


public class ProcessamentoException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public ProcessamentoException(String msg) {
		super(msg);
	}
	
	public int getFila() {
		return FILA_SIS_WEB;
	}

	public String getSeveridade() {
		return "3";
	}
	
}
