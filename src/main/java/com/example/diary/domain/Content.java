package com.example.diary.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class Content {

	@Column(name="content")
	private String content;

}
