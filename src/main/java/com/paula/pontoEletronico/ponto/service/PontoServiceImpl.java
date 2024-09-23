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

	private PontoRepository pontoRepository;

	private PontoEletronicoConverter pontoEletronicoConverter;

	public PontoServiceImpl(PontoRepository pontoRepository, PontoEletronicoConverter pontoEletronicoConverter) {
		this.pontoRepository = pontoRepository;
		this.pontoEletronicoConverter = pontoEletronicoConverter;
	}

	public PontoEletronicoEntity incluirNovo(PontoEletronicoEntity ponto) {
		ponto.setRegistro(LocalDateTime.now());
		
		PontoEletronicoEntity ultimoPonto = pontoRepository.getUltimoRegistroPorUsuario(ponto.getUsuario());
		
		if(ultimoPonto != null && ultimoPonto.getTipo().equals(ponto.getTipo())) {
			throw new UltimoPontoDoMesmoTipoException();
		}
		
		return pontoRepository.save(ponto);
	}
	
	public JornadaDTO listaRegistrosDePonto(Long idUsuario) {

		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setId(idUsuario);
		
		List<PontoEletronicoEntity> registros= pontoRepository.getRegistrosPorUsuarioEmOrdemDecrescente(usuario);
		
		return new JornadaDTO(getTotalHorasTrabalhadas(registros), pontoEletronicoConverter.createFromDtos(registros));
	}

	private Long getTotalHorasTrabalhadas(List<PontoEletronicoEntity> registros) {
		long total = 0;
		LocalDateTime valorSaida ;
		
		for (PontoEletronicoEntity registro : registros) {

			if(registro.getTipo() == TipoPontoEnum.SAIDA) {
				valorSaida = registro.getRegistro();
			}else {
				valorSaida = LocalDateTime.now();
			}

			total=+ Duration.between(registro.getRegistro(), valorSaida).toMinutes();
		}
		
		if(total != 0 ) {
			return total/60;
		}

		return total;
	}
}
