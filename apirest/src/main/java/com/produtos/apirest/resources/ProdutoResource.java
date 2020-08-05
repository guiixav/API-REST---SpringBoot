package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value="/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna Lista de produtos")
	public List<produto> listaProdutos(){
		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um produto único")
	public produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Salva um produto")
	public produto salvarProduto(@RequestBody produto prod) 
	{
		return produtoRepository.save(prod);
	}
	
	@DeleteMapping("/produto/{id}")
	@ApiOperation(value="Deleta um produto")
	public void deletaProduto(@PathVariable(value="id") long id) {
	produtoRepository.deleteById(id);
		
	}
	
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto")
	public produto atualizaProduto(@RequestBody produto prod) {
		
		return produtoRepository.save(prod);
		
	}
}

