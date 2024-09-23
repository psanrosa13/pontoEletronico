package com.paula.pontoEletronico.ponto.dto;

import java.util.List;

public record JornadaDTO(Long total, List<PontoEletronicoDTO> registros) {}
