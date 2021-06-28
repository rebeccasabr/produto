package br.com.produto.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="TBL_PRODUTOS")
@SequenceGenerator(name="tbl_produtos_id_produto_seq", sequenceName="tbl_produtos_id_produto_seq",initialValue=1, allocationSize=1)
@Entity

public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tbl_produtos_id_produto_seq")
	@Column(name="idProduto")
	private Integer idProduto;
	
	@Column(name="nomeProduto")
	private String nomeProduto;
	
	@Column(name="valor")
	private Double valor;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="valorFrete")
	private Double valorFrete;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public Produto(Integer idProduto, String nomeProduto, Double valor, String descricao, Double valorFrete) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.descricao = descricao;
		this.valorFrete = valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Produto() {
		super();
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", valor=" + valor + ", descricao="
				+ descricao + ", valorFrete=" + valorFrete + "]";
	}
	
}