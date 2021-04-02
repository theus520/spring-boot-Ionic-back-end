package com.matheusrabelo.mr.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheusrabelo.mr.domain.Categoria;
import com.matheusrabelo.mr.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	// aqui o framework vai processar e cria um method sem precisar criar uma classe de auxilio
	
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome AND cat IN :categorias")
	Page<Produto> pesquisar(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias,
			Pageable pageRequest);

}
