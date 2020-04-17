package com.paula.pontoEletronico.ponto.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import com.paula.pontoEletronico.ponto.dto.PontoEletronicoDTO;
import com.paula.pontoEletronico.usuario.entity.UsuarioEntity;

@Entity
public class PontoEletronicoEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
    @ManyToOne
	private UsuarioEntity usuario;
	
	private LocalDateTime registro;

	@Enumerated(EnumType.STRING)
	private TipoPontoEnum tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getRegistro() {
		return registro;
	}

	public void setRegistro(LocalDateTime registro) {
		this.registro = registro;
	}

	public TipoPontoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoPontoEnum tipo) {
		this.tipo = tipo;
	}

	
	public PontoEletronicoDTO getPontoEletronicoDTO() {
		ModelMapper  modelMapper = new ModelMapper();
		
		PontoEletronicoDTO pontoEletronicoDTO = modelMapper.map(this, PontoEletronicoDTO.class);
		
		return pontoEletronicoDTO;
	}
}
