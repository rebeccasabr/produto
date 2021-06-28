package br.com.produto.util;

import java.io.ByteArrayInputStream;




public class ReaderXML {	
	
	
	/**
	 * @param xml
	 * @return
	 */
	private static String limpaXml(String xml) {
		int iPos = xml.indexOf("<![CDATA[");
		int fPos = xml.indexOf("]]></conteudo>");
		if (iPos > 0) {
			xml = xml.substring(iPos+9, fPos);				
		}
		return xml;
	}
	
	
	
	/**
	 * @param xml
	 * @return
	 * Criado pelo Fabio tira as tags inicias para localidade
	 */
	
	private static String limpaXmlVitriaIn(String xmlVitriIn) {
		//int iPos = xmlVitriIn.indexOf("[CDATA[ <?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		int iPos = xmlVitriIn.indexOf("[CDATA[");
		int fPos = xmlVitriIn.indexOf("]]>");
		if (iPos > 0) {
			//xmlVitriIn = xmlVitriIn.substring(iPos+51, fPos);
			xmlVitriIn = xmlVitriIn.substring(iPos+7, fPos);				
		}
		//log.info("XML limpo: " + xmlVitriIn);
		return xmlVitriIn;
	}
	
	
	private static String limpaXmlVitriaInCabecalho(String xmlVitriInCabecalho) {
		int iPos = xmlVitriInCabecalho.indexOf("<?xml version=\"1.0\" encoding=\"UTF-8\"?><mensagem>");
		int fPos = xmlVitriInCabecalho.indexOf("</mensagem>");
		if (iPos > 0) {
			xmlVitriInCabecalho = xmlVitriInCabecalho.substring(iPos+25, fPos);				
		}
		return xmlVitriInCabecalho;
	}
	
	
	
	
	private static String limpaXmlVitriaInCabecalhoPredio(String xmlVitriInCabecalho) {
		int iPos = xmlVitriInCabecalho.indexOf("<cabecalho>");
		int fPos = xmlVitriInCabecalho.indexOf("</cabecalho>");
		if (iPos > 0) {
			xmlVitriInCabecalho = xmlVitriInCabecalho.substring(iPos, fPos+12);				
		}
		return xmlVitriInCabecalho;
	}
	
	
	
	
	
	private static String limpaXmlVitriaInCabecalhoLogradouro(String xmlVitriInCabecalho) {
		int iPos = xmlVitriInCabecalho.indexOf("<cabecalho>");
		int fPos = xmlVitriInCabecalho.indexOf("</cabecalho>");
		if (iPos > 0) {
			xmlVitriInCabecalho = xmlVitriInCabecalho.substring(iPos, fPos+12);				
		}
		return xmlVitriInCabecalho;
	}
	
	
	
	
	/**
	 * @param xml
	 * @return
	 * Criado pelo Fabio tira as tags inicias para predio
	 */
	private static String limpaXmlVitriaInPredio(String xmlVitriIn) {
		int iPos = xmlVitriIn.indexOf("<conteudo>");
		int fPos = xmlVitriIn.indexOf("]]>");
		if (iPos > 0) {
			xmlVitriIn = xmlVitriIn.substring(iPos+62, fPos);				
		}
		return xmlVitriIn;
	}
	
	
	
	/**
	 * @param xml
	 * @return
	 * Criado pelo Fabio tira as tags inicias para lagradouro
	 */	
	private static String limpaXmlVitriaInLogradouro(String xmlVitriInLogradouro) {
		int iPos = xmlVitriInLogradouro.indexOf("<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		int fPos = xmlVitriInLogradouro.indexOf("]]>");
		if (iPos > 0) 
		{
			xmlVitriInLogradouro = xmlVitriInLogradouro.substring(iPos+47, fPos);				
		}
		return xmlVitriInLogradouro;
	}
		
	
	public static void main(String[] args) {
		ReaderXML readerXML = new ReaderXML();
		
		String xml = "<?xml version=\"1.0\" standalone=\'yes\'?>" + 
				"<mensagem>" + 
				"  <cabecalho>" + 
				"	<empresa>BRT</empresa>" + 
				"	<sistema>PVC</sistema>" + 
				"	<processo>RELREPATUINFLOG</processo>" + 
				"	<data>14/05/2008</data>" + 
				"	<identificador_requisicao>3</identificador_requisicao>" + 
				"  </cabecalho>" + 
				"  <conteudo>" + 
				"   <root>" + 
				"  	<acao>update</acao>" + 
				"    <codigo_retorno>3</codigo_retorno> " + 
				"    <numero_do_case>3</numero_do_case> 		" + 
				"  	<logradouro_de>" + 
				"        <indicativo_ultimo_logradouro_DE>DE</indicativo_ultimo_logradouro_DE>" + 
				"	  		<codigo_logradouro_DE>1</codigo_logradouro_DE>" + 
				"	  		<codigo_localidade_DE>49652</codigo_localidade_DE>" + 
				"	  		<tipo_logradouro_DE>DE</tipo_logradouro_DE>" + 
				"	  		<nome_logradouro_DE>DE</nome_logradouro_DE>" + 
				"	  		<nome_bairro_DE>DE</nome_bairro_DE>" + 
				"        <grupos_correspondencias_de>" + 
				"					<grupo_correspondencia_de>" + 
				"						<indicativo_numeracao_par_impar_DE>DE</indicativo_numeracao_par_impar_DE> " + 
				"						<numero_faixa_inicia_DE>DE</numero_faixa_inicia_DE> " + 
				"						<numero_faixa_final_DE>DE</numero_faixa_final_DE>" + 
				"						<numero_cep_DE>DE</numero_cep_DE> " + 
				"						<codigo_carteiro_DE>33</codigo_carteiro_DE> " + 
				"						<nome_regiao_DE>DE</nome_regiao_DE> " + 
				"						<codigo_cdd_DE>33</codigo_cdd_DE>					" + 
				"						<codigo_estacao_DE>DE</codigo_estacao_DE>				" + 
				"					</grupo_correspondencia_de>" + 
				"			  </grupos_correspondencias_de>" + 
				"			  <dado_lista_de>" + 
				"					<codigo_localidade_lista_DE>DE</codigo_localidade_lista_DE>" + 
				"					<nome_localidade_lista_DE>DE</nome_localidade_lista_DE> " + 
				"					<codigo_bairro_lista_DE>DE</codigo_bairro_lista_DE>" + 
				"					<codigo_setor_lista_DE>DE</codigo_setor_lista_DE>" + 
				"					<codigo_logradouro_lista_DE>DE</codigo_logradouro_lista_DE>" + 
				"					<endereco_complementar_lista_DE>DE</endereco_complementar_lista_DE>" + 
				"					<data_alteracao_lista_DE>14/05/2008</data_alteracao_lista_DE>" + 
				"					<matricula_alteracao_lista_DE>DE</matricula_alteracao_lista_DE>" + 
				"					<nome_logradouro_lista_DE>DE</nome_logradouro_lista_DE>" + 
				"					<nome_bairro_lista_DE>DE</nome_bairro_lista_DE>                    " + 
				"			  </dado_lista_de>  " + 
				"        <grupo_facilidade_rede_de>" + 
				"				  <grupos>" + 
				"					  <grupo>				  		<indica_numeracao_par_impar_endereco_rede_DE>DE</indica_numeracao_par_impar_endereco_rede_DE> " + 
				"					  	<limite_inferior_endereco_rede_DE>DE</limite_inferior_endereco_rede_DE>" + 
				"						  <limite_superior_endereco_rede_DE>DE</limite_superior_endereco_rede_DE> " + 
				"  						<tipo_complemento1_DE>DE</tipo_complemento1_DE>  " + 
				"	  					<indica_fora_atb_rede_DE>DE</indica_fora_atb_rede_DE>  " + 
				"		  				<indica_endereco_rede_DE>DE</indica_endereco_rede_DE>   " + 
				"	            <codigo_micro_area_servico_DE>DE</codigo_micro_area_servico_DE>" + 
				"	            <codigo_micro_area_reparo_DE>DE</codigo_micro_area_reparo_DE> " + 
				"	            <codigo_micro_area_tup_DE>DE</codigo_micro_area_tup_DE>			" + 
				"					  </grupo>" + 
				"				  </grupos>      " + 
				"          <localiza_planta_rede_DE>DE</localiza_planta_rede_DE>" + 
				"			  </grupo_facilidade_rede_de>" + 
				"        <grupo_wimax_de>	" + 
				"          <indica_abrangencia_wimax_de>DE</indica_abrangencia_wimax_de>" + 
				"		  		<grupos>" + 
				"			   		<grupo>" + 
				"				   		<indica_comercializacao_wx_DE>DE</indica_comercializacao_wx_DE> " + 
				"			   			<informa_complemento_wx_DE>DE</informa_complemento_wx_DE>" + 
				"					   	<informa_faixa_inicial_wx_DE>DE</informa_faixa_inicial_wx_DE>  " + 
				"   						<informa_faixa_final_wx_DE>DE</informa_faixa_final_wx_DE>   " + 
				"		  				<informa_modalidade_wx_DE>DE</informa_modalidade_wx_DE>" + 
				"			  		</grupo>" + 
				"  				</grupos>" + 
				"	  	  </grupo_wimax_de>" + 
				"    		<outro_de>" + 
				"				  <nomes_foneticos_de>" + 
				"				    <nome_fonetico_de>" + 
				"							<nome_fonetico_logradouro_DE>DE</nome_fonetico_logradouro_DE>" + 
				"				    </nome_fonetico_de>			" + 
				"				  </nomes_foneticos_de>" + 
				"		  		<indicativo_existencia_predio_DE>DE</indicativo_existencia_predio_DE>" + 
				"			  	<indicativo_existencia_complemento_DE>DE</indicativo_existencia_complemento_DE>" + 
				"  				<indicativo_existencia_fachada_DE>DE</indicativo_existencia_fachada_DE>" + 
				"	  			<codigo_estacao_ruralvan_DE>DE</codigo_estacao_ruralvan_DE>" + 
				"		  		<indicativo_registro_excluido_DE>DE</indicativo_registro_excluido_DE>" + 
				"			  	<data_atualizacao_DE>14/05/2008</data_atualizacao_DE>				" + 
				"  				<codigos_complementos_logradouro_DE>" + 
				"	  				<codigo_complemento_logradouro_DE>DE</codigo_complemento_logradouro_DE>" + 
				"		  		</codigos_complementos_logradouro_DE>				" + 
				"  				<indica_caixa_complemento_fac_DE>DE</indica_caixa_complemento_fac_DE>" + 
				"	  			<data_alteracao_CMR_DE>14/05/2008</data_alteracao_CMR_DE>" + 
				"		   		<matricula_alteracao_CMR_DE>DE</matricula_alteracao_CMR_DE>" + 
				"  				<matricula_DE>DE</matricula_DE>" + 
				"	  			<indica_logradouro_FAC_DE>DE</indica_logradouro_FAC_DE>" + 
				"		  		<indica_situacao_comercializacao_DE>DE</indica_situacao_comercializacao_DE>" + 
				"			  	<indica_numeracao_irregular_DE>DE</indica_numeracao_irregular_DE>" + 
				"  				<indica_endereco_correspondencia_DE>DE</indica_endereco_correspondencia_DE>" + 
				"	  			<indica_bloqueio_DE>DE</indica_bloqueio_DE> " + 
				"		  		<indica_fora_concessao_DE>DE</indica_fora_concessao_DE>" + 
				"				  <indica_fase_migracao_DE>DE</indica_fase_migracao_DE>" + 
				"  				<data_migracao_DE>14/05/2008</data_migracao_DE>" + 
				"	  			<hora_migracao_DE>5:00</hora_migracao_DE>" + 
				"  				<elemento_aglutinacao_DE>DE</elemento_aglutinacao_DE>" + 
				"	  			<data_qualificacao_DE>DE</data_qualificacao_DE>" + 
				"	  		</outro_de>" + 
				"   </logradouro_de>" + 
				"   <logradouro_para>" + 
				"        <indicativo_ultimo_logradouro_PARA>PARA</indicativo_ultimo_logradouro_PARA>" + 
				"	  		<codigo_logradouro_PARA>1</codigo_logradouro_PARA>" + 
				"	  		<codigo_localidade_PARA>49652</codigo_localidade_PARA>" + 
				"	  		<tipo_logradouro_PARA>PARA</tipo_logradouro_PARA>" + 
				"	  		<nome_logradouro_PARA>PARA</nome_logradouro_PARA>" + 
				"	  		<nome_bairro_PARA>PARA</nome_bairro_PARA>" + 
				"        <grupos_correspondencias_para>" + 
				"					<grupo_correspondencia_para>" + 
				"						<indicativo_numeracao_par_impar_PARA>PARA</indicativo_numeracao_par_impar_PARA> " + 
				"						<numero_faixa_inicia_PARA>PARA</numero_faixa_inicia_PARA> " + 
				"						<numero_faixa_final_PARA>PARA</numero_faixa_final_PARA>" + 
				"						<numero_cep_PARA>PARA</numero_cep_PARA> " + 
				"						<codigo_carteiro_PARA>33</codigo_carteiro_PARA> " + 
				"						<nome_regiao_PARA>PARA</nome_regiao_PARA> " + 
				"						<codigo_cdd_PARA>PARA</codigo_cdd_PARA>					" + 
				"						<codigo_estacao_PARA>PARA</codigo_estacao_PARA>				" + 
				"					</grupo_correspondencia_para>" + 
				"			  </grupos_correspondencias_para>" + 
				"			  <dado_lista_para>" + 
				"					<codigo_localidade_lista_PARA>PARA</codigo_localidade_lista_PARA>" + 
				"					<nome_localidade_lista_PARA>PARA</nome_localidade_lista_PARA> " + 
				"					<codigo_bairro_lista_PARA>PARA</codigo_bairro_lista_PARA>" + 
				"					<codigo_setor_lista_PARA>PARA</codigo_setor_lista_PARA>" + 
				"					<codigo_logradouro_lista_PARA>PARA</codigo_logradouro_lista_PARA>" + 
				"					<endereco_complementar_lista_PARA>PARA</endereco_complementar_lista_PARA>" + 
				"					<data_alteracao_lista_PARA>14/05/2008</data_alteracao_lista_PARA>" + 
				"					<matricula_alteracao_lista_PARA>PARA</matricula_alteracao_lista_PARA>" + 
				"					<nome_logradouro_lista_PARA>PARA</nome_logradouro_lista_PARA>" + 
				"					<nome_bairro_lista_PARA>PARA</nome_bairro_lista_PARA>                    " + 
				"			  </dado_lista_para>  " + 
				"        <grupo_facilidade_rede_para>" + 
				"				  <grupos>" + 
				"					  <grupo>				  		<indica_numeracao_par_impar_endereco_rede_PARA>PARA</indica_numeracao_par_impar_endereco_rede_PARA> " + 
				"					  	<limite_inferior_endereco_rede_PARA>PARA</limite_inferior_endereco_rede_PARA>" + 
				"						  <limite_superior_endereco_rede_PARA>PARA</limite_superior_endereco_rede_PARA> " + 
				"  						<tipo_complemento1_PARA>PARA</tipo_complemento1_PARA>  " + 
				"	  					<indica_fora_atb_rede_PARA>PARA</indica_fora_atb_rede_PARA>  " + 
				"		  				<indica_endereco_rede_PARA>PARA</indica_endereco_rede_PARA>   " + 
				"	            <codigo_micro_area_servico_PARA>PARA</codigo_micro_area_servico_PARA>" + 
				"	            <codigo_micro_area_reparo_PARA>PARA</codigo_micro_area_reparo_PARA> " + 
				"	            <codigo_micro_area_tup_PARA>PARA</codigo_micro_area_tup_PARA>			" + 
				"					  </grupo>" + 
				"				  </grupos>      " + 
				"          <localiza_planta_rede_PARA>PARA</localiza_planta_rede_PARA>" + 
				"			  </grupo_facilidade_rede_para>" + 
				"        <grupo_wimax_para>	" + 
				"          <indica_abrangencia_wimax_para>PARA</indica_abrangencia_wimax_para>" + 
				"		  		<grupos>" + 
				"			   		<grupo>" + 
				"				   		<indica_comercializacao_wx_PARA>PARA</indica_comercializacao_wx_PARA> " + 
				"			   			<informa_complemento_wx_PARA>PARA</informa_complemento_wx_PARA>" + 
				"					   	<informa_faixa_inicial_wx_PARA>PARA</informa_faixa_inicial_wx_PARA>  " + 
				"   						<informa_faixa_final_wx_PARA>PARA</informa_faixa_final_wx_PARA>   " + 
				"		  				<informa_modalidade_wx_PARA>PARA</informa_modalidade_wx_PARA>" + 
				"			  		</grupo>" + 
				"  				</grupos>" + 
				"	  	  </grupo_wimax_para>" + 
				"    		<outro_para>" + 
				"				  <nomes_foneticos_para>" + 
				"				    <nome_fonetico_para>" + 
				"							<nome_fonetico_logradouro_PARA>PARA</nome_fonetico_logradouro_PARA>" + 
				"				    </nome_fonetico_para>			" + 
				"				  </nomes_foneticos_para>" + 
				"		  		<indicativo_existencia_predio_PARA>PARA</indicativo_existencia_predio_PARA>" + 
				"			  	<indicativo_existencia_complemento_PARA>PARA</indicativo_existencia_complemento_PARA>" + 
				"  				<indicativo_existencia_fachada_PARA>PARA</indicativo_existencia_fachada_PARA>" + 
				"	  			<codigo_estacao_ruralvan_PARA>PARA</codigo_estacao_ruralvan_PARA>" + 
				"		  		<indicativo_registro_excluido_PARA>PARA</indicativo_registro_excluido_PARA>" + 
				"			  	<data_atualizacao_de>PARA</data_atualizacao_de>				" + 
				"  				<codigos_complementos_logradouro_PARA>" + 
				"	  				<codigo_complemento_logradouro_PARA>PARA</codigo_complemento_logradouro_PARA>" + 
				"		  		</codigos_complementos_logradouro_PARA>				" + 
				"  				<indica_caixa_complemento_fac_PARA>PARA</indica_caixa_complemento_fac_PARA>" + 
				"	  			<data_alteracao_CMR_PARA>14/05/2008</data_alteracao_CMR_PARA>" + 
				"		   		<matricula_alteracao_CMR_PARA>PARA</matricula_alteracao_CMR_PARA>" + 
				"  				<matricula_PARA>PARA</matricula_PARA>" + 
				"	  			<indica_logradouro_FAC_PARA>PARA</indica_logradouro_FAC_PARA>" + 
				"		  		<indica_situacao_comercializacao_PARA>PARA</indica_situacao_comercializacao_PARA>" + 
				"			  	<indica_numeracao_irregular_PARA>PARA</indica_numeracao_irregular_PARA>" + 
				"  				<indica_endereco_correspondencia_PARA>PARA</indica_endereco_correspondencia_PARA>" + 
				"	  			<indica_bloqueio_PARA>PARA</indica_bloqueio_PARA> " + 
				"		  		<indica_fora_concessao_PARA>PARA</indica_fora_concessao_PARA>" + 
				"				  <indica_fase_migracao_PARA>PARA</indica_fase_migracao_PARA>" + 
				"  				<data_migracao_PARA>14/05/2008</data_migracao_PARA>" + 
				"	  			<hora_migracao_PARA>5:00</hora_migracao_PARA>" + 
				"  				<elemento_aglutinacao_PARA>PARA</elemento_aglutinacao_PARA>" + 
				"	  			<data_qualificacao_PARA>14/05/2008</data_qualificacao_PARA>" + 
				"	  		</outro_para>" + 
				"     </logradouro_para>				" + 
				"  	</root>" + 
				"  </conteudo>" + 
				"</mensagem>" + 
				"";
		
		//readerXML.readRetornoVitriaLogradouro(xml);
	}
}
