package com.paula.pontoEletronico.ponto.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paula.pontoEletronico.ponto.exception.UltimoPontoDoMesmoTipoException;
import com.paula.pontoEletronico.ponto.model.Ponto;
import com.paula.pontoEletronico.ponto.model.TipoPontoEnum;
import com.paula.pontoEletronico.ponto.repository.PontoRepository;
import com.paula.pontoEletronico.usuario.model.Usuario;

@Service
public class PontoService {

	@Autowired
	private PontoRepository pontoRepository;
	
	public Ponto salvar(Ponto ponto) {
		ponto.setRegistro(LocalDateTime.now());
		
		Optional<Ponto> ultimoPonto = pontoRepository.getUltimoRegistroPorUsuario(ponto.getUsuario());
		
		if(ultimoPonto.isPresent() && ultimoPonto.get().getTipo().equals(ponto.getTipo())) {
			throw new UltimoPontoDoMesmoTipoException();
		}
		
		return pontoRepository.save(ponto);
	}
	
	public Jornada consulta(Long idUsuario) {
		Jornada jornada = new Jornada();
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		jornada.setRegistros(pontoRepository.getRegistrosPorUsuarioEmOrdemDecrescente(usuario));
		
		preencheTotalHorasTrabalhadas(jornada);
		
		return jornada;
	}

	private void preencheTotalHorasTrabalhadas(Jornada jornada) {
		long total = 0;
		LocalDateTime valorSaida ;
		
		for (Ponto ponto : jornada.getRegistros()) {
			valorSaida = LocalDateTime.now();
			
			if(ponto.getTipo().equals(TipoPontoEnum.SAIDA)) {
				valorSaida = ponto.getRegistro();
			}else {
				total=+ Duration.between(ponto.getRegistro(), valorSaida).toMinutes();
			}
		}
		
		if(total != 0 ) {
			jornada.setTotal(total/60 );
		}else {
			jornada.setTotal(total);
		}
	}
}
