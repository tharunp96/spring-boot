package com.springboot.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.sprinboot.model.User;
import com.sprinboot.service.UserServiceImpl;

public class TestWebApp extends SpringbootRegistartionApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	/*
	 * @Test public void contextLoads() { }
	 * 
	 * 
	 * @Before public void setup() { mockMvc =
	 * MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); }
	 */

	@InjectMocks
	UserServiceImpl userService;

	User USER_1 = new User("Nihal", "Sarin", "nihal.sarin@gmail.com", "password", Long.valueOf(500070),
			new Date(2010 - 9 - 11), new Date(2021 - 8 - 11));
	User USER_2 = new User("Nihal1", "Sarin1", "nihal.sarin1@gmail.com", "password1", Long.valueOf(500071),
			new Date(2013 - 11 - 05), new Date(2021 - 8 - 11));
	User USER_3 = new User("Nihal2", "Sarin2", "nihal.sarin2@gmail.com", "password2", Long.valueOf(500071),
			new Date(2021 - 10 - 11), new Date(2018 - 6 - 11));
	User USER_4 = new User("Nihal3", "Sarin3", "nihal.sarin3@gmail.com", "password3", Long.valueOf(500071),
			new Date(2019 - 8 - 11), new Date(2019 - 5 - 11));
	List<User> records = new ArrayList<>(Arrays.asList(USER_1, USER_2, USER_3, USER_4));

	/*
	 * @Test public void registerUser() throws Exception {
	 * 
	 * 
	 * Mockito.when(userService.save(USER_1)).thenReturn(USER_1); // When findAll
	 * called then ready with records (No DB calls)
	 * mockMvc.perform(MockMvcRequestBuilders.post("/registration").contentType(
	 * MediaType.APPLICATION_JSON)) .andExpect(status().isOk()) // 200
	 * .andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].firstName",
	 * is("Nihal"))); }
	 * 
	 */
}
