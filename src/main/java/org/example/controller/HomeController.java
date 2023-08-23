package org.example.controller;

import org.example.collection.Collections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
