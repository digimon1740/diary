package com.example.diary.service;

import com.example.diary.domain.Diary;
import com.example.diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

	@Autowired
	private DiaryRepository diaryRepository;

	public void create(Diary diary) {
		diaryRepository.save(diary);
	}
}
