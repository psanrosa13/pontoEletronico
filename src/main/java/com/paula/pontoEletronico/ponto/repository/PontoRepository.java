package com.paula.pontoEletronico.ponto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paula.pontoEletronico.ponto.model.Ponto;
import com.paula.pontoEletronico.usuario.model.Usuario;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {

	@Query("select p1 FROM Ponto p1 WHERE p1.id = (SELECT MAX(p.id) from Ponto p where p.usuario = :usuario)")
	public Optional<Ponto> getUltimoRegistroPorUsuario(@Param("usuario") Usuario usuario); 
	
	
	@Query("select p from Ponto p where p.usuario = :usuario "
			+ "ORDER BY p.id DESC")
	public List<Ponto> getRegistrosPorUsuarioEmOrdemDecrescente(@Param("usuario") Usuario usuario); 
	
}
