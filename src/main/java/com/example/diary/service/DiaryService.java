package com.example.diary.service;

import com.example.diary.domain.Diary;
import com.example.diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiaryService {

	@Autowired
	private DiaryRepository diaryRepository;

	@Transactional
	public void create(Diary diary) {
		// == validation 필요함
		diaryRepository.save(diary);
	}
}
