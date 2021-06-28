package br.com.produto.bo;

import java.util.ArrayList;

import br.com.produto.domain.Produto;
import br.com.produto.dto.ProdutoDto;
import br.com.produto.exception.BDException;

public interface IProdutoBO {

	public ProdutoDto inserirProduto(ProdutoDto produtoDto) throws BDException;
	
	public ProdutoDto deletarProdutos(ProdutoDto produtoDto) throws BDException;
	
	public ArrayList<ProdutoDto> buscaProduto() throws BDException;
	
	public ArrayList<ProdutoDto> adicionarProdutoCarrinho (ProdutoDto produtoDto) throws BDException;
	
	public ArrayList<ProdutoDto> removerProdutoCarrinho(ProdutoDto produtoDto) throws BDException;
	
	public ArrayList<ProdutoDto> ordernarProdutoPorPreco(ArrayList<ProdutoDto> listaProdutos) throws BDException;
	
	public ProdutoDto atualizarProduto(ProdutoDto produtoDto) throws BDException;
}
