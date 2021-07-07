package com.digitalinnovation.one.peoplemanagerdio.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testInsertPersonWithSuccess() throws Exception {
		
		URI uri = new URI("/people");
		
		String jsonBody = "{\r\n"
				+ "    \"firstName\":\"Jonatas\",\r\n"
				+ "    \"lastName\":\"Laetinho\",\r\n"
				+ "    \"cpf\":\"055.102.563-89\",\r\n"
				+ "    \"phones\":[\r\n"
				+ "        {\r\n"
				+ "            \"type\":\"MOBILE\",\r\n"
				+ "            \"number\":\"86994643741\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		
		String expectedJsonResponseBody = "{\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"firstName\": \"Jonatas\",\r\n"
				+ "    \"lastName\": \"Laetinho\",\r\n"
				+ "    \"cpf\": \"055.102.563-89\",\r\n"
				+ "    \"birthDate\": null,\r\n"
				+ "    \"phones\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 1,\r\n"
				+ "            \"type\": \"MOBILE\",\r\n"
				+ "            \"number\": \"86994643741\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		
		System.out.println("Dados: "+ jsonBody);
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(jsonBody).contentType(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(MockMvcResultMatchers.status().is(201))
		.andExpect(MockMvcResultMatchers.content().json(expectedJsonResponseBody));
	}
	
	@Test
	void testInsertPersonWithNullFirstName() throws Exception {
		
		URI uri = new URI("/people");
		
		String jsonBody = "{\r\n"
				+ "    \"firstName\":\"\",\r\n"
				+ "    \"lastName\":\"Laetinho\",\r\n"
				+ "    \"cpf\":\"055.102.563-89\",\r\n"
				+ "    \"phones\":[\r\n"
				+ "        {\r\n"
				+ "            \"type\":\"MOBILE\",\r\n"
				+ "            \"number\":\"86994643741\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		
//		String expectedJsonResponseBody = "{\r\n"
//				+ "    \"id\": 1,\r\n"
//				+ "    \"firstName\": \"Jonatas\",\r\n"
//				+ "    \"lastName\": \"Laetinho\",\r\n"
//				+ "    \"cpf\": \"055.102.563-89\",\r\n"
//				+ "    \"birthDate\": null,\r\n"
//				+ "    \"phones\": [\r\n"
//				+ "        {\r\n"
//				+ "            \"id\": 1,\r\n"
//				+ "            \"type\": \"MOBILE\",\r\n"
//				+ "            \"number\": \"86994643741\"\r\n"
//				+ "        }\r\n"
//				+ "    ]\r\n"
//				+ "}";
		
		System.out.println("Dados: "+ jsonBody);
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(jsonBody).contentType(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(MockMvcResultMatchers.status().is(400));
	}

}
