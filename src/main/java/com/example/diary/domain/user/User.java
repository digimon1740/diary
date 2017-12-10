package com.example.diary.domain.user;

import com.example.diary.utils.EmailValidator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Table(name = "user")
@Entity
@JsonIgnoreProperties(value = {"seq", "passwd", "regtime", "moditime", "role"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;

	@NotNull
	@Column(name = "id")
	private String id;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(name = "passwd")
	private String passwd;

	@Column(name = "regtime")
	private LocalDateTime regtime;

	@Column(name = "moditime")
	private LocalDateTime moditime;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;

	// TODO ID는 email형식이므로 validation을 추가해야함
	public boolean validateId() {
		String email = this.id;
		if (StringUtils.isEmpty(email))
			return false;
		// TODO 대소문자형식 체크해야함
		return EmailValidator.isValid(email);
	}

}