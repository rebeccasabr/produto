package br.com.produto.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.produto.dto.ProdutoDto;
import br.com.produto.exception.BDException;
import br.com.produto.json.Response;

public interface IProdutoController {
	
	public ResponseEntity<Response> inserirProduto(@RequestParam String nomeProduto, @RequestParam String Descricao, @RequestParam Double valor, @RequestParam Double valorFrete) throws BDException;

	public ResponseEntity<Response> deletarProdutos(@RequestParam String idProduto) throws BDException;

	public ResponseEntity<Response> buscarProduto(@RequestParam String nomeProduto, @RequestParam String Descricao, @RequestParam Double valor, @RequestParam Double valorFrete) throws BDException;

	public ArrayList<ProdutoDto> adicionarProdutoCarrinho (ProdutoDto produtoDto) throws BDException;

	public ArrayList<ProdutoDto> removerProdutoCarrinho(ProdutoDto produtoDto) throws BDException;

	public ArrayList<ProdutoDto> ordernarProdutoPorPreco(ArrayList<ProdutoDto> listaProdutos) throws BDException;

	public ProdutoDto atualizarProduto(ProdutoDto produtoDto) throws BDException;

}
