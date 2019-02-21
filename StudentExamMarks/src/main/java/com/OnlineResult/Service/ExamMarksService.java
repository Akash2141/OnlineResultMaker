package com.OnlineResult.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.OnlineResult.Entity.ExamMarks;
import com.OnlineResult.Model.ExamMarksModel;
import com.OnlineResult.Repository.ExamMarksRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class ExamMarksService {

	@Autowired
	ExamMarksRepository examMarksRepository;

	public void addExamMarks(ExamMarksModel examMarksModel) {
		Gson gson = new Gson();
		String json = gson.toJson(examMarksModel);
		ExamMarks examMarks = gson.fromJson(json, ExamMarks.class);
		examMarksRepository.save(examMarks);
	}

	public List<ExamMarksModel> getExamMarks() {

		Iterable<ExamMarks> itExamMarks = examMarksRepository.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(itExamMarks);
		List<ExamMarksModel> listExamMarksModel = gson.fromJson(json, new TypeToken<List<ExamMarksModel>>() {
		}.getType());
		return listExamMarksModel;
	}
	public List<ExamMarksModel> getExamMarksByYearSemester(int year, String semester, String month, String type, boolean atkt)
	{
		Iterable<ExamMarks> itExamMarks = examMarksRepository.findByYearAndSemesterAndMonthAndTypeAndAtkt(year,semester,month,type,atkt);
		Gson gson = new Gson();
		String json = gson.toJson(itExamMarks);
		List<ExamMarksModel> listExamMarksModel = gson.fromJson(json, new TypeToken<List<ExamMarksModel>>() {
		}.getType());
				
//		Collections.sort(getExamMarksSortedByYear, new YearComparator());
		
		return listExamMarksModel;
	}

}
