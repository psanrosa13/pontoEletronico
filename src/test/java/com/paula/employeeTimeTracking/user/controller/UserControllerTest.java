package com.paula.employeeTimeTracking.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.GsonBuilder;
import com.paula.employeeTimeTracking.LocalDateTypeAdapter;
import com.paula.employeeTimeTracking.templates.UserTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.paula.employeeTimeTracking.user.dto.UserDTO;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
public class UserControllerTest {

	public static final String PATH_USERS = "/users";
	public static final String PATH_USER_BY_ID = "/users/{id}";
	@Autowired
	private MockMvc mockMvc;

	Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
			.create();

	
	@Test
	public void whenInsertNewValidUserShouldReturnStatusCreated() throws Exception {
		UserDTO newUser = UserTemplate.getPrimeiroUsuario();
		
		mockMvc.perform(post(PATH_USERS)
			      .contentType(MediaType.APPLICATION_JSON)
			      .content(gson.toJson(newUser))
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value("1"))
				.andExpect(jsonPath("$.fullName").value(newUser.fullName()));
	}
	
	@Test
	public void whenInsertNewUserWithWrongBodyShouldReturnBadRequest() throws Exception {
		UserDTO newUser = UserTemplate.getSegundoUsuario();

		mockMvc.perform(post(PATH_USERS)
			      .contentType(MediaType.APPLICATION_JSON)
						.content(gson.toJson(newUser))
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is4xxClientError());
	}
	
	@Test
	public void whenInsertNewUserWithEmptyBodyShouldReturnBadRequest() throws Exception {
		mockMvc.perform(post(PATH_USERS)
			      .content("{}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is4xxClientError());
	}

	
	@Test
	public void whenConsultUserByIdNotPresentInDatabaseShouldReturnNotFound() throws Exception {
		mockMvc.perform(get(PATH_USER_BY_ID, "19")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is4xxClientError())
			      .andExpect(content().string("We didn't find any such user in our database"));
	}
	
	@Test
	public void whenGetByIdTheNewUserShouldReturnTheRightDataWithSuccess() throws Exception {
		UserDTO newUser = UserTemplate.getPrimeiroUsuario();
		
		MvcResult result = mockMvc.perform(post(PATH_USERS)
			      .contentType(MediaType.APPLICATION_JSON)
			      .content(gson.toJson(newUser))
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
				.andReturn();

		UserDTO responseNewUser = gson.fromJson(result.getResponse().getContentAsString(), UserDTO.class);
		
		mockMvc.perform(get(PATH_USER_BY_ID, responseNewUser.id())
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.fullName").value(newUser.fullName()));
	}
	
	
}
