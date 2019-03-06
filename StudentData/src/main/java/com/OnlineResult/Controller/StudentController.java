package com.OnlineResult.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
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
		List<StudentModel> listStudentModel= studentService.getAllStudent();
		return listStudentModel;
	}
	
	@GetMapping("/getStudent/{id}")
	public StudentModel getStudent(@PathVariable Long id)
	{
		System.out.println(id);
		StudentModel studentModel=studentService.getAllStudentById(id);
		System.out.println(studentModel.getAddress());
		return studentModel;
	}
	
	@GetMapping("/getStudent/{semester}/{calendarYear}")
	public List<StudentModel> getAllStudentByYear(@PathVariable String semester,@PathVariable int calendarYear)
	{
		List<StudentModel> listStudentModel= studentService.getAllStudent();
		List<StudentModel> newListStudentModel=new ArrayList<StudentModel>();
		String academicYear="";
		if(semester.equals("semester1") | semester.equals("semester2"))
			academicYear="fy";
		else if(semester.equals("semester3") | semester.equals("semester4"))
			academicYear="sy";
		else if(semester.equals("semester5") | semester.equals("semester6"))
			academicYear="ty";
		for(StudentModel studentModel:listStudentModel)
		{
			if(null!=studentModel.getBatch() && studentModel.getBatch().getAcademicYear().equals(academicYear) && 
					studentModel.getBatch().getCalendarYear()==calendarYear)
			{
				newListStudentModel.add(studentModel);
			}
		}
		return newListStudentModel;
	}
	

}
