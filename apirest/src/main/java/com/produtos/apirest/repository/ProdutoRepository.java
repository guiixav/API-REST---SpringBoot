package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.produto;

public interface ProdutoRepository extends JpaRepository<produto, Long>{

	produto findById(long id);
	
}
