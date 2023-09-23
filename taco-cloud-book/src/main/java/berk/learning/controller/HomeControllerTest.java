package berk.learning.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@WebMvcTest (HomeController.class)
public class HomeControllerTest {

	@Autowired
	private MockMvc mocMvc;
	
	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andExpect(content().string(
		containsString("Welcome to...")));
	}
}
