package com.OnlineResult.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.StudentModel;
import com.OnlineResult.Service.StudentResultService;

@RestController
@RequestMapping("/StudentResult")
public class ResultStudentController {
	
	Logger logger = LoggerFactory.getLogger(ResultStudentController.class);
	
	@Autowired
	StudentResultService studentResultService;
	
	@GetMapping("/getAllStudent")
	public List<StudentModel> getAllStudent()
	{
		System.out.println("Hii bro and");
		logger.info(studentResultService.getAllStudent().toString());;
		return studentResultService.getAllStudent();
	}

}
