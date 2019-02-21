package com.OnlineResult.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineResult.Entity.Student;
import com.OnlineResult.Model.StudentExamMapModel;
import com.OnlineResult.Repository.StudentExamMapRepo;
import com.google.gson.Gson;

@Service
public class StudentExamMapService {
	
	@Autowired
	StudentExamMapRepo studentExamMapRepo;
	
	public void addStudentExamMap(StudentExamMapModel studentExamMapModel)
	{
		Gson gson = new Gson();
		String json = gson.toJson(studentExamMapModel);
		Student student = gson.fromJson(json, Student.class);
		studentRepository.save(student);
	}

}
