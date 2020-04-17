package com.paula.pontoEletronico.ponto.dto;

import java.time.LocalDateTime;

import com.paula.pontoEletronico.ponto.entity.TipoPontoEnum;
import com.paula.pontoEletronico.usuario.dto.UsuarioDTO;


public class PontoEletronicoDTO {
	
	private Long id;
	
	private UsuarioDTO usuario;
	
	private LocalDateTime registro;

	private TipoPontoEnum tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
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
	
}
