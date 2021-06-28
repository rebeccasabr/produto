package br.com.produto.util;


import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;



/**
 * Classe utilit�ria do sistea
 * @author p595793
 *
 */
public final class VotacaoUtil {

	/**
	 * Converte o objeto passado em uma String, se esta for nulo, o valor 
	 * retornado ser� nulo
	 * @param valor O valor a ser transformado
	 * @return O valor no formato de string
	 */
	public static String toString(Object valor) {
		
		return valor == null ? null : valor.toString();
	}
	
	/**
	 * Verifica se uma determinada cole��o est� vazia
	 * @param colecao A cole��o a ser verificada
	 * @return Um boolean indicando se a cole��o est� vazia ou n�o
	 */
	public static boolean ehVazio(Collection<?> colecao) {
		
		return colecao == null || colecao.isEmpty();
	}
	
	/**
	 * Retorna a quantidade de elementos da cole��o.
	 * 
	 * @param colecao Cole��o a ser medida.
	 * 
	 * @return Quantidade de elementos da cole��o.
	 */
	public static int getTamanho(Collection<?> colecao) {
		return !ehVazio(colecao) ? colecao.size() : 0;
	}
	

	
	/**
	 * Imprime a pilha de exce��o
	 * @param excecao A exce��o a ser impressa
	 * @param printer O PrintWriter para a impress�o da exce��o
	 */
	public static void imprimirStackTrace(Throwable excecao, 
			PrintWriter printer) {

		if (excecao!=null) {
			Throwable causa = excecao.getCause();
			if (causa != null) {
				printer.println(excecao.getMessage());
				printer.println("<br/>");
				printer.println("<br/>");
				imprimirStackTrace(causa, printer);
			}else {
				excecao.printStackTrace(printer);
			}
		}	
	}
	
	public static int getIntervaloTimeMillis(int intervalo, long semente){
	
		Random rand = new Random(semente);
		int valor = rand.nextInt(intervalo);
		return valor;
	}	
	
	/**
	 * Verifica se um dado valor est� preenchido com um valor diferente de zero
	 * @param valor O valor a ser verificado
	 * @return Um boolean informando se o valor est� preenchido
	 */
	public static boolean isValorZerado(BigDecimal valor) {
		return valor == null || valor.doubleValue() == BigDecimal.ZERO.doubleValue();
	}
	
	/**
	 * Verifica se um dado valor est� preenchido com um valor diferente de zero
	 * @param valor O valor a ser verificado
	 * @return Um boolean informando se o valor est� preenchido
	 */
	public static boolean isValorZerado(Integer valor) {
		return valor == null || valor == 0;
	}
	
	/**
	 * Verifica se dois objetos s�o iguais. Se ambos forem null o retorno � 
	 * true.
	 * @param valor1 O primeiro valor para a verifica��o
	 * @param valor2 O segundo valor para a verifica��o
	 * @return Um boolean indicando se os campos s�o iguaiss
	 */
	public static boolean isCamposIguais(Object valor1, Object valor2) {
		
		if (valor1 == null && valor2 == null) {
			return true;
		}
		return valor1 != null && valor1.equals(valor2);
	}

	/**
	 * Retorno true apenas que os valores forem identicos, retornando FALSE se forem NULL.
	 * @param valor1
	 * @param valor2
	 * @return
	 */
	public static boolean isMesmoNumero(BigDecimal valor1, BigDecimal valor2) {
		
		if (valor1 == null && valor2 == null) {
			return true;
		}

		if (valor1 == null || valor2 == null) {
			return false;
		}
		
		return valor1.compareTo(valor2) == 0;
	}
	
	public static boolean isMesmoNumero(Integer valor1, Integer valor2) {
		
		return isCamposIguais(valor1, valor2);
	}	

	
	/**
	 * Soma os dois valores, retorna o valor != null ou, caso n�o haja, retorna BigDecimao = 0;  
	 * @param numero
	 * @param add
	 * @return
	 */
	public static BigDecimal soma(BigDecimal numero, BigDecimal add){
		if(numero != null && add != null){
			return numero.add(add);
		}else if(numero != null){
			return numero;
		}else if(add != null){
			return add;
		}else{
			return new BigDecimal(0);
		}
	}
	
	public static BigDecimal subtrai(BigDecimal numero, BigDecimal sub){
		if (sub != null){
			return soma(numero, sub.negate());
		} else{
			return soma(numero, null);
		}
	}	
	

	/**
	 * metodo que gera o digito verificador pelo m�dulo 11
	 * 
	 * @param numProposta
	 * @return
	 */
	public static Integer geraDigitoVerificadorMod11(String valor) {
		if (valor == null) {
			return null;
		}
		Integer DV = new Integer(0);
		long soma = 0;
		int multiplicador = 2;
		for (int i = valor.length()-1; i >= 0; i--) {
			soma += Long.parseLong(String.valueOf(valor.charAt(i)))
					* multiplicador;
			multiplicador++;
			if (multiplicador == 10) {
				multiplicador = 2;
			}
		}

		long resto = soma % 11;
		if (resto == 0 || resto == 1) {
			DV = new Integer(0);
		} else {
			DV = new Integer(new Long(11 - resto).toString());
		}

		return DV;
	}

	/**
	 * Verifica se um determinado array est� vazio
	 * @param dados O array que deseja verificar
	 * @return Um boolean indicando se o array est� vazio ou n�o
	 */
	public static boolean ehVazio(Object[] dados) {
		return dados == null || dados.length == 0;
	}

	
	/**
	 * Auxiliar que verifica a equidade de dois objetos tratando valores nulos.
	 * Caso ambos os valores sejam nulos, o retorno � <code>true</code>.
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static boolean equals(Object o1, Object o2){
		if ((o1 == null && o2 != null) || (o1 != null && o2 == null)){
			return false;
		}
		if (o1 == null && o2 == null){
			return true;
		}
		return o1.equals(o2);
	}
	
	/**
	 * Auxiliar que verifica a equidade de duas strings tratando valores nulos.
	 * Caso ambos os valores sejam nulos, o retorno � <code>true</code>.
	 * 
	 * @param texto1
	 * @param texto2
	 * @return
	 */
	public static boolean equalsString(String texto1, String texto2){
		if ((texto1 == null && texto2 != null) || (texto1 != null && texto2 == null)){
			return false;
		}
		if (texto1 == null && texto2 == null){
			return true;
		}
		return texto1.trim().equals(texto2.trim());
	}
	
	public static boolean isCorrespondenteCaixaAqui(String username) {
		return username.contains("@");
	}

	public static boolean isMaiorIgualZero(BigDecimal valor) {
		return valor != null && valor.compareTo(BigDecimal.ZERO) >= 0;
	}
	
	public static boolean isMaiorZero(BigDecimal valor) {
		return valor != null && valor.compareTo(BigDecimal.ZERO) > 0;
	}
	
	public static boolean isZero(BigDecimal valor) {
		return valor == null || valor.equals(BigDecimal.ZERO);
	}
	
	/**
	 * Retorna o elemento da posi��o especificada do array
	 * caso a posi��o n�o exista, retorna null
	 * 
	 * @param array Array de objetos
	 * @param posicao Posi��o no array
	 * 
	 * @return Elemento do array na posi��o especificada
	 */
	public static <T> T getElementoArray(T[] array, int posicao) {
		if (array != null && array.length > posicao) {
			return array[posicao];
		}
		return null;
	}
	
	/**
	 * Retorna o elemento da posi��o especificada da lista
	 * caso a posi��o n�o exista, retorna null
	 * 
	 * @param lista Lista de objetos
	 * @param posicao Posi��o na lista
	 * 
	 * @return Elemento da lista na posi��o especificada
	 */
	public static <T> T getElementoLista(List<T> lista, int posicao) {
		if (lista != null && lista.size() > posicao) {
			return lista.get(posicao);
		}
		return null;
	}	

	
	/**
	 * Verifica se o array cont�m o elemento passado
	 * 
	 * @param array Array de objetos
	 * @param posicao Valor a ser verificado se existe no array
	 * 
	 * @return <code>True</code> caso o elemento exista no array,
	 * <code>False</code> caso contr�rio.
	 */
	public static boolean arrayContemElemento(Object[] array, Object valor) {
		if (valor != null) {
			if (!ehVazio(array)) {
				for (Object object : array) {
					if (object.equals(valor)) {
						return true;
					}
				}
			}
		}
		return false;
	}	


	/*
	 * Compara dois valores e retorna o maior
	 */
	public static BigDecimal maiorValor(BigDecimal valor1, BigDecimal valor2) {
		BigDecimal retorno = null;
		if (valor1!=null) {
			retorno = valor1;
		}
		if (valor2!=null) {
			if (retorno==null || (valor2.compareTo(retorno)>0)) {
				retorno = valor2;
			}
		}
		return retorno;
	}


	public static BigDecimal menorValor(BigDecimal valor1, BigDecimal valor2) {
		BigDecimal retorno = null;
		if (valor1 != null) {
			retorno = valor1;
		}
		if (valor2 != null) {
			if (retorno == null || (valor2.compareTo(retorno) < 0)) {
				retorno = valor2;
			}
		}
		return retorno;
	}
	
	public static List<String> quebraTamanhoMensagem(String descricaoMensagem, int tamanhoQuebra) {
		String descTmp = "";
		List<String> list = new ArrayList<String>();
		if (descricaoMensagem != null && descricaoMensagem.length() > tamanhoQuebra) {
			int count = 0;
			for (int i = 0; i < descricaoMensagem.length(); i++) {
				count++;
				descTmp += descricaoMensagem.charAt(i);
				if (count == tamanhoQuebra || i == descricaoMensagem.length() - 1) {
					list.add(descTmp);
					descTmp = "";
					count = 0;
				}
			}
		} else {
			list.add(descricaoMensagem);
		}
		return list;
	}
	
	public static boolean isValidUTF8( byte[] input ) {
        CharsetDecoder cs = Charset.forName("UTF-8").newDecoder();
        try {
            cs.decode(ByteBuffer.wrap(input));
            return true;
        }
        catch(CharacterCodingException e){
            return false;
        }       
    }
	
	/**
     * Verifica se um dado valor est� preenchido com um valor diferente de zero
     * @param valor O valor a ser verificado
     * @return Um boolean informando se o valor est� preenchido
     */
	public static boolean isValorZerado(Number number){
		return number == null || number.doubleValue() == BigDecimal.ZERO.doubleValue();
	}

	public static void main(String[] args) {
		System.out.println(BigDecimal.TEN.pow(3).add(BigDecimal.TEN.pow(2).add(BigDecimal.TEN.pow(2))));
		System.out.println(quebraTamanhoMensagem("12345678901122334455", 18));
	}

}