package com.OnlineResult.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.OnlineResult.Model.StudentModel;
import com.OnlineResult.Service.StudentService;

@RestController
@RequestMapping("/StudentData")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addUser")
	public void addStudent(@RequestBody StudentModel studentModel)
	{
		studentService.addStudent(studentModel);
	}
	
	@GetMapping("/getAllStudent")
	public List<StudentModel> getAllStudent()
	{
		System.out.println();
		return studentService.getAllStudent();
	}
	
	@GetMapping("/getAllStudent/{id}")
	public StudentModel getStudent(@PathVariable Long id)
	{
		StudentModel studentModel=studentService.getAllStudentById(id);
		return studentModel;
	}
	

}
