package br.com.produto.util;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;


public final class PropertiesReader {
	public static final String CHAVE_LOCALIDADE = "parametroLocalidade";
	public static final String CHAVE_LOGRADOURO = "parametroLogradouro";
	public static final String CHAVE_PREDIO = "parametroPredio";
	public static final String ARQ_PARAM = "arqParam.properties";
	
	private static Hashtable resources;

	private static PropertiesReader instancia = null;

	private String path;

	/**
	 * Construtor no args
	 * Inicializa a Hash.
	 */
	private PropertiesReader() {
		resources = new Hashtable();
	}

	/**
	 * M�todo usa o padr�o Singleton
	 * @return A instancia �nica da classe
	 */
	public static PropertiesReader getInstance() {
		if (instancia == null) {
			instancia = new PropertiesReader();
			instancia.path = "";
		}
		return instancia;
	}

	/**
	 * Retorna path do arquivo de properties
	 * @return path do arquivo de properties
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Seta o path do arquivo de properties
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * M�todo que recupera o valor de um parametro
	 * de um arquivo .properties
	 * Recebe o nome do arquivo e o nome da propriedade.
	 * Por motivo de organizacao, atualmente obriga-se que
	 * seja criada uma pasta "properties" na raiz de "src"
	 * onde dever�o ser jogados os .properties.
	 * @param arquivo Nome do Arquivo
	 * @param parametro Nome do parametro
	 * @return Valor do parametro no arquivo
	 */
	public String getProperty(String arquivo, String parametro) {
		String retorno = null;

		try {
			Properties prop = getResouceBundle(arquivo);
			if (prop == null) {
				return "";
			}
			retorno = (String) prop.getProperty(parametro);
			System.out.println("param[" + parametro + "]" + ", retorno["
					+ retorno + "]");
			if (retorno == null) {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	/**
	 * Retorna propriedade de acordo com par�metro passado
	 * @param parametro
	 * @param args
	 * @return  propriedade de acordo com par�metro passado
	 */
	public String getProperty(String parametro, String[] args) {
		String retorno = null;
		try {
			retorno = getProperty("arqParam", parametro);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					try {
						String chaveAtual = args[i];
						String indice = retorno.substring(0, retorno
								.indexOf("({0})"));
						String aux = retorno.substring(
								retorno.indexOf("({0})") + 5, retorno.length());
						indice += chaveAtual + aux;
						retorno = indice;
					} catch (Exception e) {
						//nao fa�o nada
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	/**
	 * Equivalente ao m�todo getProperty(String arquivo, String parametro)
	 * Recebe apenas o nome do parametro, e considera o aquivo .properties
	 * default como sendo arqParam.properties. 
	 * Usa o getProperty(String arquivo, String parametro).
	 * @param parametro Nome do parametro a ser recuperado.
	 * @return Valor do parametro.
	 */
	public String getProperty(String parametro) {
		String retorno = null;
		try {
			retorno = getProperty("arqParam", parametro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	/**
	 * M�todo que recupera o PropertyResourceBundle
	 * que ser� usado pelos metodos de recuperar o valor do parametro.
	 * @param arquivo Nome do Arquivo
	 * @return PropertyResourceBundle
	 * @throws Exception Erro Inesperado
	 */
	@SuppressWarnings(value = "unchecked")
	private Properties getResouceBundle(String arquivo) throws Exception {
		Properties prop = (Properties) resources.get(arquivo);
		if (prop == null) {
			//pega arquivo via url
			java.net.URL url = ClassLoader.getSystemResource(arquivo);
			if (url != null) {
				prop = new Properties();
				prop.load(url.openStream());
				resources.put(arquivo, prop);
				return prop;
			}
		}
		if (prop == null) {
			//pega default via url
			java.net.URL url = ClassLoader
					.getSystemResource("arqParam.properties");
			if (url != null) {
				prop = new Properties();
				prop.load(url.openStream());
				resources.put(arquivo, prop);
			}
		}
		return prop;
	}

	/**
	 * Retorna o arquivo de properties. Este m�todo foi criado para 
	 * a visualiza��o dos valores dos atributos no properties a partir
	 * do jsp de gerenciador de property.
	 * @param arquivo Nome do Arquivo a ser retornado
	 * @return Properties.
	 * @throws Exception Exce��o gen�rica.
	 */
	public Properties getArquivoProperty(String arquivo) throws Exception {
		Properties prop = getResouceBundle(arquivo);

		return prop;
	}

	/**
	 * Retorna o arquivo de properties. Este m�todo foi criado para 
	 * a visualiza��o dos valores dos atributos no properties a partir
	 * do jsp de gerenciador de property.
	 * @return Properties.
	 * @throws Exception Exce��o gen�rica.
	 */
	public Properties getArquivoProperty() throws Exception {
		Properties prop = getResouceBundle("arqParam");

		return prop;
	}

	/**
	 * Metodo que recarrega o arquivo especificado
	 * @param arquivo Nome do Arquivo
	 */
	public static void reloadArquivo(String arquivo) {
		resources.remove(arquivo);
	}

	public static void main(String[] args) throws IOException {
		java.net.URL url = ClassLoader.getSystemResource("arqParam.properties");
		Properties prop = new Properties();
		prop.load(url.openStream());
		//    resources.put(arquivo, prop);      
		System.out.println("url: " + prop.getProperty("url"));
	}

}