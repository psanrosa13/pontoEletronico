package com.paula.pontoEletronico.ponto.dto;

import java.time.LocalDateTime;

import com.paula.pontoEletronico.ponto.entity.TipoPontoEnum;
import com.paula.pontoEletronico.usuario.dto.UsuarioDTO;


public record PontoEletronicoDTO(Long id,UsuarioDTO usuario, LocalDateTime registro, TipoPontoEnum tipo){}
