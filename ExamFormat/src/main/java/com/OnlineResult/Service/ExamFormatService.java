package com.OnlineResult.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineResult.Entity.ExamFormat;
import com.OnlineResult.Model.ExamFormatModel;
import com.OnlineResult.Repository.ExamFormatRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class ExamFormatService {

	@Autowired
	ExamFormatRepository examFormatRepository;

	public void addExamFormat(ExamFormatModel examFormatModel) {
		Gson gson = new Gson();
		String json = gson.toJson(examFormatModel);
		ExamFormat examFormat = gson.fromJson(json, ExamFormat.class);
		examFormatRepository.save(examFormat);
	}

	public List<ExamFormatModel> allExamFormat() {
		Iterable<ExamFormat> itExamFormat = examFormatRepository.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(itExamFormat);
		List<ExamFormatModel> listExamFormatModel = gson.fromJson(json, new TypeToken<List<ExamFormatModel>>() {
		}.getType());
		return listExamFormatModel;
	}

	public ExamFormatModel getExamFormatByYear(int year) {
		ExamFormat itExamFormat = examFormatRepository.findByYear(year);
		if (itExamFormat == null) {
			throw null;
		} else {
			Gson gson = new Gson();
			String json = gson.toJson(itExamFormat);
			ExamFormatModel listExamFormatModel = gson.fromJson(json, new TypeToken<ExamFormatModel>() {
			}.getType());

			return listExamFormatModel;
		}
	}

	public void updateFormat(ExamFormatModel examFormatModel) {
		ExamFormat examFormat, examFormat1;
		Gson gson = new Gson();
		String json = gson.toJson(examFormatModel);
		examFormat = gson.fromJson(json, ExamFormat.class);
		examFormat1 = examFormatRepository.findByYear(examFormatModel.getYear());
		if (examFormat1 != null) {
			examFormat.setId(examFormat1.getId());
		} else {
			throw null;
		}
		examFormatRepository.save(examFormat);
	}

}
