package com.paula.pontoEletronico.ponto.controller;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
public class PontoEletronicoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	Gson gson = new Gson();
	
	@BeforeClass
	public static void setUp() {
	    FixtureFactoryLoader.loadTemplates("com.paula.pontoEletronico.ponto.templates");
	}
	
	
}
