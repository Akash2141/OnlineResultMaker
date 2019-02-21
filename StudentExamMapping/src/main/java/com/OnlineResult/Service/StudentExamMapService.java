package com.OnlineResult.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineResult.Entity.StudentExamMap;
import com.OnlineResult.Model.StudentExamMapModel;
import com.OnlineResult.Repository.StudentExamMapRepo;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@Service
public class StudentExamMapService {
	
	@Autowired
	StudentExamMapRepo studentExamMapRepo;
	
	public void addStudentExamMap(StudentExamMapModel studentExamMapModel)
	{
		Gson gson = new Gson();
		String json = gson.toJson(studentExamMapModel);
		StudentExamMap student = gson.fromJson(json, StudentExamMap.class);
		studentExamMapRepo.save(student);
	}
	
	public List<StudentExamMapModel> getAllStudentExamMap()
	{
		Iterable<StudentExamMap> itStudentExamMap=studentExamMapRepo.findAll();
		Gson gson=new Gson();
		String json=gson.toJson(itStudentExamMap);
		List<StudentExamMapModel> listStudentExamMapModel=gson.fromJson(json, new TypeToken<List<StudentExamMapModel>>() {
		}.getType());
		return listStudentExamMapModel;
	}

}
