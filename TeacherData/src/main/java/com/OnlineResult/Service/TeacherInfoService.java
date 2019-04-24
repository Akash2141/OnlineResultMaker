package com.OnlineResult.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineResult.Entity.Teacher;
import com.OnlineResult.Model.TeacherModel;
import com.OnlineResult.Repository.TeacherInfoRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class TeacherInfoService {
	
	@Autowired
	TeacherInfoRepo teacherInfoRepo;
	
	public void addTeacher(TeacherModel teacherModel)
	{
		Gson gson = new Gson();
		String json = gson.toJson(teacherModel);
		Teacher teacher = gson.fromJson(json, Teacher.class);
		teacherInfoRepo.save(teacher);
	}
	
	public List<TeacherModel> getAllTeacher()
	{
		Iterable<Teacher> itExamMarks = teacherInfoRepo.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(itExamMarks);
		List<TeacherModel> listTeacher = gson.fromJson(json, new TypeToken<List<TeacherModel>>() {
		}.getType());
		return listTeacher;
	}
	
	public TeacherModel getTeacher(String username, String password) {
		Teacher teacher=teacherInfoRepo.findByUsernameAndPassword(username,password);
		Gson gson = new Gson();
		String json = gson.toJson(teacher);
		TeacherModel teacherModel=gson.fromJson(json, TeacherModel.class);
		return teacherModel;
	}

}
