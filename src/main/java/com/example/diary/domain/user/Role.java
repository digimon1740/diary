package com.example.diary.domain.user;

import org.springframework.util.StringUtils;

public enum Role {
	USER, ADMIN;

	public static Role of(String name) {
		if (StringUtils.isEmpty(name))
			return Role.USER;
		name = name.trim();
		if (ADMIN.name().equalsIgnoreCase(name))
			return Role.ADMIN;
		return Role.USER;
	}
}
