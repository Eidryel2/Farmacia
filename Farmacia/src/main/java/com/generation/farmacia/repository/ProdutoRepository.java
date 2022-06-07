package com.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	public List <Produto> findByNomeContainingIgnoreCase(@Param("nome") String nome);
	/* MySQL: select * from tb_produtos where nome = "produto" and laboratorio = "laboratorio";*/
	
	public List <Produto> findByNomeAndLaboratorio(String nome, String laboratorio);
	/*  MySQL: select * from tb_produtos where nome = "produto" or laboratorio = "laboratorio";*/
	
	public List <Produto> findByNomeOrLaboratorio(String nome, String laboratorio);
	
	@Query(value = "select * from tb_produtos where preco between :inicio and :fim", nativeQuery = true)
	public List <Produto> buscarProdutosEntre(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);

	public List<Produto> findByPrecoIn(List<BigDecimal> preco);
	/* Method Query equivalente: public List<Produto> findByPrecoBetween(BigDecimal inicio, BigDecimal fim);*/
}
