package com.paula.pontoEletronico.usuario.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.paula.pontoEletronico.usuario.dto.UsuarioDTO;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
public class UsuarioControllerTeste {

	@Autowired
	private MockMvc mockMvc;
	
	Gson gson = new Gson();
	
	@BeforeClass
	public static void setUp() {
	    FixtureFactoryLoader.loadTemplates("com.paula.pontoEletronico.templates");
	}
	
	@Test
	public void quandoIncluirNovoUsuarioDeveRetornarStatusCreatedId() throws Exception {
		UsuarioDTO primeiroUsuario = Fixture.from(UsuarioDTO.class).gimme("primeiro_usuario");
		
		mockMvc.perform(post("/usuarios")
			      .contentType(MediaType.APPLICATION_JSON)
			      .content(gson.toJson(primeiroUsuario))
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
	
		UsuarioDTO segundoUsuario = Fixture.from(UsuarioDTO.class).gimme("segundo_usuario");
		
		mockMvc.perform(post("/usuarios")
			      .content(gson.toJson(segundoUsuario))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
			      .andExpect(jsonPath("$.id").value("2"));
	}
	
	@Test
	public void quandoIncluirNovoUsuarioSemBodyDeveRetornarBadRequest() throws Exception {	
		mockMvc.perform(post("/usuarios")
			      .content("")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());
	}
	
	@Test
	public void quandoIncluirNovoUsuarioComObjetoVazioDeveRetornarBadRequest() throws Exception {
		mockMvc.perform(post("/usuarios")
			      .content("{}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());
	}
	
	@Test
	public void quandoIncluirNovoUsuarioSemNomeDeveRetornarBadRequest() throws Exception {
		UsuarioDTO usuarioDTO = Fixture.from(UsuarioDTO.class).gimme("usuario_sem_nome");
		
		mockMvc.perform(post("/usuarios")
			      .content(gson.toJson(usuarioDTO))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());
	}
	
	@Test
	public void quandoConsultarUmClienteNaoRegistradoDeveRetornarUmaMensagemDeErro() throws Exception {
		mockMvc.perform(get("/usuarios/{id}", "19")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is4xxClientError())
			      .andExpect(content().string("Usuário não encontrado em nossa base de Dados com o id fornecedio"));
	}
	
	@Test
	public void quandoConsultarUmClienteRegistrado() throws Exception {
		UsuarioDTO primeiroUsuario = Fixture.from(UsuarioDTO.class).gimme("primeiro_usuario");
		
		mockMvc.perform(post("/usuarios")
			      .contentType(MediaType.APPLICATION_JSON)
			      .content(gson.toJson(primeiroUsuario))
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
		
		mockMvc.perform(get("/usuarios/{id}", 1)
			      .content("")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.nomeCompleto").value("Tatiana Ferraz"));
	}
	
	
}
