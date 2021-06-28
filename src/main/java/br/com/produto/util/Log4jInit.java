/*
 * Created on 26/02/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.com.produto.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Log4jInit {

	public static void init() {
				
		Properties p = new Properties();
		  try {
		    java.net.URL url = ClassLoader.getSystemResource("log4j.properties");
		    p = new Properties();
		    p.load(url.openStream());		
		   // PropertyConfigurator.configure(p);	
			System.out.println("Inicializou o log4j!");
			
		  } catch(FileNotFoundException fnfex) {
			System.out.println("Nao foi possivel abrir o arquivo de configuracao do log");
		  } catch(IOException ioex) {
			System.out.println("Nao foi possivel carregar os parametros de configuracao");
		  }
	}

}
