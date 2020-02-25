package com.paula.pontoEletronico.ponto.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.paula.pontoEletronico.usuario.model.Usuario;

@Entity
public class Ponto {
	@Id
	@GeneratedValue
	private Long id;
	
    @ManyToOne
    @JoinColumn
	private Usuario usuario;
	
	private LocalDateTime registro;

	@Enumerated(EnumType.STRING)
	private TipoPontoEnum tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
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
