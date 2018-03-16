package com.example.diary;

import com.example.diary.domain.user.User;
import com.example.diary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class HelloController {

	UserService userService;

	@Autowired
	public HelloController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String hello() throws Exception {
		return "redirect:login.html";
	}

	@GetMapping(value = "/login-error")
	public String loginError() throws Exception {
		return "/login-error.html";
	}
}
