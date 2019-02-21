package com.OnlineResult.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OnlineResult.Entity.Student;
import com.OnlineResult.Model.StudentModel;
import com.OnlineResult.Repository.StudentRepository;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public void addStudent(StudentModel studentModel) {
		Gson gson = new Gson();
		String json = gson.toJson(studentModel);
		Student student = gson.fromJson(json, Student.class);
		studentRepository.save(student);

	}

	public List<StudentModel> getAllStudent() {
		Iterable<Student> itStudent=studentRepository.findAll();
		Gson gson=new Gson();
		String json=gson.toJson(itStudent);
		List<StudentModel> listStudentModel=gson.fromJson(json, new TypeToken<List<StudentModel>>() {
		}.getType());
		return listStudentModel;
	}
	
	public StudentModel getAllStudentById(Long id) {
		Student student=studentRepository.findById(id).get();
		Gson gson=new Gson();
		String json=gson.toJson(student);
		StudentModel studentModel=gson.fromJson(json, StudentModel.class);
		return studentModel;
	}

}
