package com.example.diary.controller.user;

import com.example.diary.controller.general.api.ApiResponse;
import com.example.diary.domain.user.User;
import com.example.diary.exception.UserNotFoundException;
import com.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "checkid")
	public ApiResponse checkId(@RequestParam(name = "id") String id) throws UserNotFoundException {
		return new ApiResponse<>(userService.findOneById(id));
	}

	@PostMapping(path = "join")
	public ApiResponse join(@RequestBody User user) {
		return new ApiResponse<>(userService.create(user));
	}
}
