package br.com.produto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.bo.ProdutoBO;
import br.com.produto.dto.ProdutoDto;
import br.com.produto.exception.BDException;
import br.com.produto.json.Response;

@RestController
@RequestMapping("/api/produto/v1")
@Configuration
@ComponentScan("br.com.produto")
public class ProdutoController implements IProdutoController {
	
	@Autowired
	ProdutoBO produtoBO;

	@Override
	@RequestMapping(value = "/inserir/produto", method =  RequestMethod.POST)
	public ResponseEntity<Response> inserirProduto(@RequestParam String nomeProduto, @RequestParam String Descricao, @RequestParam Double valor, @RequestParam Double valorFrete) throws BDException {
		
		ProdutoDto produtoDto = new ProdutoDto();
		Response response = new Response();
		
		try {
			produtoDto.setDescricao(Descricao);
			produtoDto.setNomeProduto(nomeProduto);
			produtoDto.setValor(new Double(valor));
			produtoDto.setValorFrete(new Double(valorFrete));
			
			response.setModeloRetorno(produtoBO.inserirProduto(produtoDto));
			response.setMensagensRetorno("Cadastro realizado com sucessooooo!!!");
			
			
			
		} catch (Exception e) {
			response.setMensagensRetorno(e.getMessage());	
		}
		
		return ResponseEntity.ok(response);
	}

	@Override
	@RequestMapping(value = "/deletar/produtos" , method = RequestMethod.DELETE)
	public ResponseEntity<Response> deletarProdutos(@RequestParam String idProduto) throws BDException {
		
		ProdutoDto produtoDto = new ProdutoDto();
		
		Response response = new Response();
		
		try {
			produtoDto.setIdProduto(new Integer(idProduto));
					
	        response.setModeloRetorno(produtoBO.deletarProdutos(produtoDto));
			response.setMensagensRetorno("Produto deletado do carrinho ");
		} catch (Exception e) {
			response.setMensagensRetorno(e.getMessage());	
			
		}
		
	return ResponseEntity.ok(response);
	}

	@Override
	@RequestMapping(value ="/buscar/produtos" , method = RequestMethod.GET)
	public ResponseEntity <Response> buscarProduto(@RequestParam String nomeProduto, @RequestParam String Descricao, @RequestParam Double valor, @RequestParam Double valorFrete) throws BDException {
		
		ProdutoDto produtoDto = new ProdutoDto();
		Response response = new Response();
		
		try {
		produtoDto.setDescricao(Descricao);
		produtoDto.setNomeProduto(nomeProduto);
		produtoDto.setValor(valor);
		produtoDto.setValorFrete(valorFrete);
		
		    response.setModeloRetorno(produtoBO.buscaProduto());
		    response.setMensagensRetorno("Produto encontrado");
		} catch (Exception e) {
			response.setMensagensRetorno(e.getMessage());
			
		}
		
		
		
		return ResponseEntity.ok(response);
	}

	@Override
	public ArrayList<ProdutoDto> adicionarProdutoCarrinho(ProdutoDto produtoDto) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProdutoDto> removerProdutoCarrinho(ProdutoDto produtoDto) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProdutoDto> ordernarProdutoPorPreco(ArrayList<ProdutoDto> listaProdutos) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoDto atualizarProduto(ProdutoDto produtoDto) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
