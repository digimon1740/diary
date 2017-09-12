package com.example.diary.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
	@Column(name = "name")
	private String name;

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

}
