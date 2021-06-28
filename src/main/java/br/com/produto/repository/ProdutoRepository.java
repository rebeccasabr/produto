package br.com.produto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.produto.domain.Produto;

@Component("produtoRepository")
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

	
	
}