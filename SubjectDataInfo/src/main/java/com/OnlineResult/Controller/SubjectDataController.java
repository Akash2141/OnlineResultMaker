package com.OnlineResult.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.SubjectDataModel;
import com.OnlineResult.Service.SubjectDataService;

@RestController
@RequestMapping("/SubjectDataInfo")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectDataController {
	
	@Autowired
	SubjectDataService subjectDataService;
	
	@PostMapping("/addSubjectData")
	public void addSubjectData(@RequestBody SubjectDataModel subjectDataModel)
	{
		subjectDataService.addSubjectData(subjectDataModel);
	}
	
	@GetMapping("/getAllSubjectData")
	public List<SubjectDataModel> getAllSubjectData()
	{
		return subjectDataService.getAllSubjectData();
	}

	@GetMapping("/getSubjectData/{semester}/{calendarYear}")
	public List<SubjectDataModel> getSubjectDataByCalendarYear(@PathVariable String semester, @PathVariable int calendarYear)
	{
		
		return subjectDataService.getSubjectDataByCalendarYear(semester, calendarYear);
	}
}
