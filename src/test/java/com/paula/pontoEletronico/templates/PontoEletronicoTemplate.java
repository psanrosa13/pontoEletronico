package com.paula.pontoEletronico.templates;

import java.time.LocalDateTime;
import java.time.Month;

import com.paula.pontoEletronico.ponto.dto.PontoEletronicoDTO;
import com.paula.pontoEletronico.ponto.entity.TipoPontoEnum;
import com.paula.pontoEletronico.usuario.dto.UsuarioDTO;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PontoEletronicoTemplate implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(PontoEletronicoDTO.class).addTemplate("ponto_Entrada_segunda", new Rule(){{
			add("usuario", one(UsuarioDTO.class, "usuario_ponto_um") );
			add("registro", LocalDateTime.of(2020, Month.APRIL, 13, 12, 30));
			add("tipo", TipoPontoEnum.ENTRADA);
		}});
		
		Fixture.of(PontoEletronicoDTO.class).addTemplate("ponto_Saida_segunda", new Rule(){{
			add("usuario", one(UsuarioDTO.class, "usuario_ponto_um") );
			add("registro", LocalDateTime.of(2020, Month.APRIL, 13, 18, 20));
			add("tipo", TipoPontoEnum.SAIDA);
		}});
		
	}

	
	
	
	
}
