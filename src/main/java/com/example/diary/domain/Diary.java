package com.example.diary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Setter
@Getter
@Table(name = "diary")
@Entity
@JsonIgnoreProperties(value = {"seq"})
public class Diary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;

	@Column(name="subject")
	private String subject;

	@Embedded
	private Content content;

	@Column(name="regtime")
	private LocalDateTime regtime;

	@Column(name="moditime")
	private LocalDateTime moditime;
}
