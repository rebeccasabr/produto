package br.com.produto.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;


public class DataManager {
	private static DataManager dm = null;
	
	public static DataManager getInstance() {
		if (dm == null) {
			dm = new DataManager();
		}
		return dm;
	}
	
	private DataManager() {
		
	}

	//log datahora produ��o
	  public GregorianCalendar getCalendar() {
		  
	      SimpleTimeZone pdt = new SimpleTimeZone(-3 * 60 * 60 * 1000,"GMT-03:00");
	      
	      // Seta as regras para o hor�rio de ver�o Brasileiro
	      // Come�ando no primeiro domingo ap�s o dia primeiro
	      pdt.setStartRule(Calendar.NOVEMBER, 1, Calendar.SUNDAY,0);
	      // Terminando no �ltimo domingo do m�s de Fevereiro
	      pdt.setEndRule(Calendar.FEBRUARY, -1, Calendar.SUNDAY,0);
	      
	      TimeZone.setDefault(pdt);
	      
	      // Instanciando um GregorianCalendar com com a time zone de BSB
	      // e levando em considera��o as regras do hor�rio de ver�o.
	      GregorianCalendar cal = new GregorianCalendar(pdt);
	      
	      return cal;
	  }
	  
	  public static final java.sql.Date dateToSqlDate (java.util.Date data) {
		if(data != null){  
			java.sql.Date dataSql = new java.sql.Date(data.getTime());
			return dataSql;
		}else return null;
	}
}
