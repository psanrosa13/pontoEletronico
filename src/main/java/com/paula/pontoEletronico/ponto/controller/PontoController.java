package com.paula.pontoEletronico.ponto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paula.pontoEletronico.ponto.model.Ponto;
import com.paula.pontoEletronico.ponto.service.Jornada;
import com.paula.pontoEletronico.ponto.service.PontoService;

@RestController
@RequestMapping("/ponto")
public class PontoController {

	@Autowired
	private PontoService pontoService;
	
	@PostMapping
	public Ponto inserir(@RequestBody Ponto ponto) {
		return pontoService.salvar(ponto);
	}
	
	@GetMapping("/usuario/{id}/jornada")
	public Jornada consultar(@PathVariable Long id) {
		return pontoService.consulta(id);
	}
	
}
