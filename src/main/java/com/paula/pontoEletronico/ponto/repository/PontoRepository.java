package com.paula.pontoEletronico.ponto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paula.pontoEletronico.ponto.entity.PontoEletronicoEntity;
import com.paula.pontoEletronico.usuario.entity.UsuarioEntity;

@Repository
public interface PontoRepository extends JpaRepository<PontoEletronicoEntity, Long> {

	@Query("select p1 FROM PontoEletronicoEntity p1 WHERE p1.id = (SELECT MAX(p.id) from PontoEletronicoEntity p where p.usuario = :usuario)")
	public PontoEletronicoEntity getUltimoRegistroPorUsuario(@Param("usuario") UsuarioEntity usuario); 
	
	
	@Query("select p from PontoEletronicoEntity p where p.usuario = :usuario "
			+ "ORDER BY p.id DESC")
	public List<PontoEletronicoEntity> getRegistrosPorUsuarioEmOrdemDecrescente(@Param("usuario") UsuarioEntity usuario); 
	
}
