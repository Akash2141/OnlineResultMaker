package com.OnlineResult.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.StudentExamMapModel;
import com.OnlineResult.Service.StudentExamMapService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/StudentExamMap")
public class StudentExamMapController {
	
	@Autowired
	StudentExamMapService studentExamMapService;
	
	@PostMapping("/addStudentExamMap")
	public void addStudentExamMap(@RequestBody StudentExamMapModel studentExamMapModel)
	{
		studentExamMapService.addStudentExamMap(studentExamMapModel);
	}
	
	@GetMapping("/getAllStudentExamMap")
	public List<StudentExamMapModel> getAllStudentExamMap()
	{
		return studentExamMapService.getAllStudentExamMap();
	}

}
