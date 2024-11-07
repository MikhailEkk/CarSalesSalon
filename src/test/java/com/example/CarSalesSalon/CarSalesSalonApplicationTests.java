package com.example.CarSalesSalon;

import com.example.CarSalesSalon.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class)
public class CarSalesSalonApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHomePageStatus() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk()); //Статус
	}

	@Test
	public void testHomePageViewName() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(view().name("home"));	//имя представления, возвращаемое контроллером
	}

	@Test
	public void testHomePageContent() throws Exception {
		mockMvc.perform(get("/"))	//Контент сообщения
				.andExpect(content().string(org.hamcrest.Matchers.containsString("Рады приветствовать вас в Premium Motors!")));
	}


	//Проверка обработки несуществующего маршрута (404 ошибка)
	@Test
	public void testNonExistentPageReturns404() throws Exception {
		mockMvc.perform(get("/nonexistent")) .andExpect(status().isNotFound());
	}
}
