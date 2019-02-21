package com.OnlineResult.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.ExamMarksModel;
import com.OnlineResult.Service.ExamMarksService;

@RestController
@RequestMapping("/ExamMarks")
public class ExamMarksController {
	
	@Autowired
	private ExamMarksService examMarksService;
	
	@PostMapping("/addExamMarks")
	public void addExamMarks(@RequestBody ExamMarksModel examMarksModel)
	{
		examMarksService.addExamMarks(examMarksModel);
	}
	
	@GetMapping("/getExamMarks")
	public List<ExamMarksModel> getExamMarks()
	{
		return examMarksService.getExamMarks();
	}
	@GetMapping("/getExamMarksByYear/{year}/{semester}/{month}/{type}/{atkt}")
	public List<ExamMarksModel> getExamMarksByyear(@PathVariable int year, @PathVariable String semester,@PathVariable String month, @PathVariable String type, @PathVariable boolean atkt)
	{
		return examMarksService.getExamMarksByYearSemester(year,semester,month,type,atkt);
	}
	

}
