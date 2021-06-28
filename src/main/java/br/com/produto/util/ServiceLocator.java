/**
 * Projeto: ASAP - Sistema de Reconcilia��o Ativa (SRA)
 * 
 * Tipo : ServiceLocator
 */
package br.com.produto.util;

import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;




public class ServiceLocator {
	
    private static ServiceLocator instance = null;

    private Context context;
    private HashMap cache;

    /* Cria uma nova instancia do ServiceLocator */
    private ServiceLocator() throws Exception {
        try {
            context = new InitialContext();
            cache = new HashMap();
        }
        catch ( Exception e ) {        	
            throw new Exception( e.getMessage() );
        }
    }

    /* Cria a inst�ncia de ServiceLocator */
	static {
		try {
			instance = new ServiceLocator();
		}
		catch ( Exception e ) {
			System.err.println( "Erro ao instanciar ServiceLocator: " + e.getMessage() );
		}
	}

    /**
     * Retorna a inst�ncia da classe.
     * 
     * @return ServiceLocator Instancia de <code>ServiceLocator</code>.
     */
    public static ServiceLocator getInstance() {
        return instance;
    }

    /**
     * Procura por um servi�o ou recurso.
     * 
     * @param uri URI para localiza��o do servi�o ou recurso.
     * @return Object Servi�o ou recurso encontrado.
     * @throws Exception se ocorrer algum erro.
     */
    @SuppressWarnings(value = "unchecked")
    public Object lookup( String uri ) throws Exception {
        Object resource = null;

        try {
            if ( cache.containsKey( uri ) )
                return cache.get( uri );

            resource = context.lookup( uri );
            cache.put( uri, resource );
        }
        catch ( Exception e ) {        	
        	e.printStackTrace();
            throw new Exception( e );    
        }  

        return resource;
    }
}