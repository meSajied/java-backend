package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {
	@Test
	void runTest() {
		HomeController controller = new HomeController();
		assertNotNull(controller.context);
	}
}