package com.paula.pontoEletronico.ponto.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paula.pontoEletronico.ponto.converter.PontoEletronicoConverter;
import com.paula.pontoEletronico.ponto.dto.JornadaDTO;
import com.paula.pontoEletronico.ponto.dto.PontoEletronicoDTO;
import com.paula.pontoEletronico.ponto.entity.PontoEletronicoEntity;
import com.paula.pontoEletronico.ponto.entity.TipoPontoEnum;
import com.paula.pontoEletronico.ponto.exception.UltimoPontoDoMesmoTipoException;
import com.paula.pontoEletronico.ponto.repository.PontoRepository;
import com.paula.pontoEletronico.usuario.entity.UsuarioEntity;

@Service
public class PontoServiceImpl implements PontoService{

	@Autowired
	private PontoRepository pontoRepository;
	
	@Autowired
	private PontoEletronicoConverter pontoEletronicoConverter;
	
	public PontoEletronicoEntity incluirNovo(PontoEletronicoEntity ponto) {
		ponto.setRegistro(LocalDateTime.now());
		
		PontoEletronicoEntity ultimoPonto = pontoRepository.getUltimoRegistroPorUsuario(ponto.getUsuario());
		
		if(ultimoPonto != null && ultimoPonto.getTipo().equals(ponto.getTipo())) {
			throw new UltimoPontoDoMesmoTipoException();
		}
		
		return pontoRepository.save(ponto);
	}
	
	public JornadaDTO listaRegistrosDePonto(Long idUsuario) {
		JornadaDTO jornada = new JornadaDTO();
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setId(idUsuario);
		
		List<PontoEletronicoEntity> registros= pontoRepository.getRegistrosPorUsuarioEmOrdemDecrescente(usuario);
		
		jornada.setRegistros(pontoEletronicoConverter.createFromDtos(registros));
		
		preencheTotalHorasTrabalhadas(jornada);
		
		return jornada;
	}

	private void preencheTotalHorasTrabalhadas(JornadaDTO jornada) {
		long total = 0;
		LocalDateTime valorSaida ;
		
		for (PontoEletronicoDTO ponto : jornada.getRegistros()) {
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
