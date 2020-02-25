package com.paula.pontoEletronico.usuario.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
public class UsuarioControllerTeste {

	@Autowired
	private MockMvc mockMvc;
	
	private Long usuarioId;
	
	private String USUARIO_NOVO_PRIMEIRO = "{\"cpf\": \"356.333.740-37\",\"dataDeCadastro\": \"2020-02-02\",\"email\": \"tatianaferraz7@gmail.com\",\"nomeCompleto\": \"Tatiana Ferraz\"}";
	private String USUARIO_NOVO = "{\"cpf\": \"108.702.670-94\",\"dataDeCadastro\": \"2020-02-20\",\"email\": \"psa7@gmail.com\",\"nomeCompleto\": \"Paula Macedo Santana\"}";
	private String USUARIO_NOVO_INCOMPLETO = "{\"cpf\": \"717.708.090-23\",\"email\": \"psa7@gmail.com\",\"nomeCompleto\": \"Paula Macedo Santana\"}";
	
	@Before
	public void init() throws Exception {

		MvcResult result = mockMvc.perform(post("/usuario")
			      .content(USUARIO_NOVO_PRIMEIRO)
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
			      .andDo(print())
	              .andReturn();
	
	
		Gson gson = new Gson();
		JsonObject json = gson.fromJson(result.getResponse().getContentAsString(), JsonObject.class);
		usuarioId = json.get("id").getAsLong();
	
	}
	
	@Test
	public void quandoIncluirNovoUsuarioDeveRetornarStatusCreatedEId() throws Exception {
		mockMvc.perform(post("/usuario")
			      .content(USUARIO_NOVO)
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
			      .andExpect(jsonPath("$.id").value("2"));
	}
	
	@Test
	public void quandoIncluirNovoUsuarioSemBodyDeveRetornarBadRequest() throws Exception {	
		mockMvc.perform(post("/usuario")
			      .content("")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());
	}
	
	@Test
	public void quandoIncluirNovoUsuarioComObjetoVazioDeveRetornarBadRequest() throws Exception {
		mockMvc.perform(post("/usuario")
			      .content("{}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());
	}
	
	@Test
	public void quandoIncluirNovoUsuarioSemDataCadastroDeveRetornarBadRequest() throws Exception {
		mockMvc.perform(post("/usuario")
			      .content(USUARIO_NOVO_INCOMPLETO)
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());
	}
	
	@Test
	public void quandoConsultarUmClienteNaoRegistradoDeveRetornarUmaMensagemDeErro() throws Exception {
		mockMvc.perform(get("/usuario/{id}", "19")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is4xxClientError())
			      .andExpect(content().string("Usuário não encontrado em nossa base de Dados com o id fornecedio"));
	}
	
	@Test
	public void quandoConsultarUmClienteRegistrado() throws Exception {
		mockMvc.perform(get("/usuario/{id}", usuarioId)
			      .content(USUARIO_NOVO_INCOMPLETO)
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.nomeCompleto").value("Tatiana Ferraz"));
	}
	
	
}
