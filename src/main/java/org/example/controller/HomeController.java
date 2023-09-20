package org.example.controller;

import org.example.collection.Collections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController	{
	private ApplicationContext context;
	private Collections cc;
	
	@RequestMapping(value="/home")
	public ModelAndView test() {
		context = new ClassPathXmlApplicationContext("configc.xml");
		cc = (Collections) context.getBean("mycollection");

		return new ModelAndView("home", "f", (Object)cc.getFriends());
	}

	@RequestMapping(value="/formaction", method= RequestMethod.POST)
	public void GetDataFromView(HttpServletRequest response) {
		String name = response.getParameter("name");
		String email = response.getParameter("email");
	}

	@RequestMapping(value="/formaction", method= RequestMethod.POST)
	public void GetDataFromViewWithRequestParam(@RequestParam("name") String name,
			@RequestParam("email") String email) {
		System.out.println(name);
		System.out.println(email);
	}
}
