package com.example.diary.service;

import com.example.diary.domain.user.Role;
import com.example.diary.domain.user.User;
import com.example.diary.domain.user.UserResponse;
import com.example.diary.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void createTest() {
		User user = new User();
		user.setId("admin@diary.com");
		user.setFirstName("SangHoon");
		user.setLastName("Lee");
		user.setPasswd("admin123");
		user.setRegtime(LocalDateTime.now());
		user.setRole(Role.of("admin"));
		UserResponse userResponse = userService.create(user);
		log.info("userResponse : {}", userResponse);
	}

	@Test
	public void findOneByIdTest() throws UserNotFoundException {
		User user = userService.findOneByIdWithNullCheck("admin11");
		log.info("user : {}", user);
	}

	@Test
	public void modifyTest() throws UserNotFoundException {
		User user = userService.findOneByIdWithNullCheck("admin11");
		userService.modify(user);
	}
}
