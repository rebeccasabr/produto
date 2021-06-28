package br.com.produto.exception;


public class NaoGravouArquivoException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public NaoGravouArquivoException(String msg) {
		super(msg);
	}
	
	public int getFila() {
		return FILA_SIS_WEB;
	}

	public String getSeveridade() {
		return "3";
	}
	
}
