package com.example.diary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String hello() throws Exception {
		return "redirect:login.html";
	}

	@RequestMapping(value="/login-error", method = RequestMethod.GET)
	public String loginError() throws Exception {
		return "/login-error.html";
	}

	@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView main() throws Exception {
		return new ModelAndView("main");
	}
}
