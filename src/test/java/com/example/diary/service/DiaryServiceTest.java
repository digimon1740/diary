package com.example.diary.service;

import com.example.diary.domain.Content;
import com.example.diary.domain.Diary;
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
public class DiaryServiceTest {

	@Autowired
	private DiaryService diaryService;

	@Test
	public void create() {
		Diary diary = new Diary();
		diary.setSubject("This is test diary");
		Content content = new Content();
		content.setContent("This is first paragraph");
		diary.setContent(content);
		diary.setRegtime(LocalDateTime.now());
		diaryService.create(diary);
	}
}
