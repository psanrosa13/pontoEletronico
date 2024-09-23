package com.paula.pontoEletronico.ponto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
public class PontoEletronicoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	Gson gson = new Gson();

	
	
}
