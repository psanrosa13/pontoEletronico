
package com.paula.pontoEletronico.templates;


import com.paula.pontoEletronico.usuario.dto.UsuarioDTO;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UsuarioDtoTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(UsuarioDTO.class).addTemplate("primeiro_usuario", new Rule(){{
			add("nomeCompleto", "Eduarda Isabel Malu Rezende");
			add("cpf", "240.545.648-60");
			add("email", "eduardaisabelmalurezende@br.nestle.com");
			//add("dataDeCadastro", LocalDate.now());
		}});
		
		Fixture.of(UsuarioDTO.class).addTemplate("segundo_usuario", new Rule(){{
			add("nomeCompleto", "Raimundo Geraldo Vitor Bernardes");
			add("cpf", "869.096.154-25");
			add("email", "raimundogeraldovitorbernardes-84@destaco.com");
			//add("dataDeCadastro", LocalDate.now());
		}});
		
		Fixture.of(UsuarioDTO.class).addTemplate("usuario_sem_nome", new Rule(){{
			add("cpf", "679.098.414-34");
			add("email", "mmarcosvinicius@unitau.br");
			//add("dataDeCadastro", LocalDate.now());
		}});
		
		Fixture.of(UsuarioDTO.class).addTemplate("usuario_ponto_um", new Rule(){{
			add("id", "1");
		}});
		
		Fixture.of(UsuarioDTO.class).addTemplate("usuario_ponto_dois", new Rule(){{
			add("id", "2");
		}});
	}

	
	
}
