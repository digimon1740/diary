package com.example.diary.service;

import com.example.diary.domain.user.User;
import com.example.diary.exception.UserNotFoundException;
import com.example.diary.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findOneById(String id) {
		return userRepository.findOneById(id);
	}

	public User findOneByIdWithNullCheck(String id) throws UserNotFoundException {
		User user = userRepository.findOneById(id);
		if (user == null)
			throw new UserNotFoundException("Could not find user : " + id);
		return user;
	}

	public User create(User user) {
		// -- null check

		// -- exists check

		// -- form check
		return userRepository.save(user);
	}

	public void modify(User user) {
		if (user == null || StringUtils.isEmpty(user.getId()))
			return;
		try {
			User old = findOneByIdWithNullCheck(user.getId());
			old.setName(user.getName());
			old.setPasswd(user.getPasswd());
			old.setModitime(LocalDateTime.now());
		} catch (UserNotFoundException e) {
			log.error(e.getMessage(), e);
		}
	}
}
