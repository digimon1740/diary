package com.example.diary.repository;

import com.example.diary.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneById(String id);
}
