package org.example.controller;

import org.example.collection.Collections;
import org.example.collection.User;
import org.example.collection.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController	{
	private ApplicationContext context;
	private Collections cc;

	@Autowired
	public UserService userService;

	@ModelAttribute
	public void commonData(Model model) {
		model.addAttribute("header", "Sajied");
	}

	@RequestMapping(value="/redirect")
	public String redirect(HttpServletRequest response) {
		/*try {
			return response.sendRedirect("/home");
		} catch(IOException e) {
			e.printStackTrace();
		}*/ // not recommended

		return "redirect:/home";
	}

	@RequestMapping(value="/redirect")
	public RedirectView redirectTwo() {
		RedirectView r = new RedirectView();
		r.setUrl("home");
		return r;
	}
	
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

	@RequestMapping(value="/formaction", method= RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		this.userService.createUser(user);
		return "home";
	}

}
