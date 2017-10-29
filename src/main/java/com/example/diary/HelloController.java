package com.example.diary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping(value="/")
	public String hello() throws Exception {
		return "redirect:login.html";
	}

	@GetMapping(value="/login-error")
	public String loginError() throws Exception {
		return "/login-error.html";
	}

	@GetMapping(value="/main")
	public String main() throws Exception {
		return "redirect:layout.html";
	}
}
