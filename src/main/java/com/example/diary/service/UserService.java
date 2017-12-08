package com.example.diary.service;

import com.example.diary.domain.user.User;
import com.example.diary.domain.user.UserResponse;
import com.example.diary.exception.UserNotFoundException;
import com.example.diary.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User findOneById(String id) {
		return userRepository.findOneById(id);
	}

	@Transactional(readOnly = true)
	public User findOneByIdWithNullCheck(String id) throws UserNotFoundException {
		User user = userRepository.findOneById(id);
		if (user == null)
			throw new UserNotFoundException("Could not find user : " + id);
		return user;
	}

	@Transactional(readOnly = true)
	public boolean existUser(String id) {
		return userRepository.findOneById(id) != null;
	}

	@Transactional(readOnly = true)
	public boolean noUser(String id) {
		return userRepository.findOneById(id) == null;
	}

	@Transactional
	public UserResponse create(User user) {
		// TODO validation 필요함
		User old = findOneById(user.getId());
		if (old != null)
			return new UserResponse(UserResponse.Code.EXIST);
		userRepository.save(user);
		return new UserResponse(UserResponse.Code.OK);
	}

	@Transactional
	public void modify(User user) {
		if (user == null || StringUtils.isEmpty(user.getId()))
			return;
		try {
			User old = findOneByIdWithNullCheck(user.getId());
			old.setLastName(user.getLastName());
			old.setPasswd(user.getPasswd());
			old.setModitime(LocalDateTime.now());
		} catch (UserNotFoundException e) {
			log.error(e.getMessage(), e);
		}
	}
}
