package com.OnlineResult.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.ExamGraceMarksModel;
import com.OnlineResult.Model.ExamMarksModel;
import com.OnlineResult.Service.ExamMarksService;

@RestController
@RequestMapping("/ExamMarks")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamMarksController {

	@Autowired
	private ExamMarksService examMarksService;

	@PostMapping("/addExamMarks")
	public void addExamMarks(@RequestBody ExamMarksModel examMarksModel) {
		examMarksService.addExamMarks(examMarksModel);
	}

	@GetMapping("/getExamMarks")
	public List<ExamMarksModel> getExamMarks() {
		return examMarksService.getExamMarks();
	}

	@GetMapping("/getExamMarksByYear/{year}/{semester}/{month}/{type}/{pattern}")
	public List<ExamMarksModel> getExamMarksByyear(@PathVariable int year, @PathVariable String semester,
			@PathVariable String month, @PathVariable String type, @PathVariable String pattern) {
		return examMarksService.getExamMarksByYearSemester(year, semester, month, type, pattern);
	}

	@PutMapping("/updateExamMarks")
	public void updateExamMarks(@RequestBody ExamMarksModel examMarksModel)
	{
		examMarksService.updateExamMarks(examMarksModel);
	}
	
	@GetMapping("/getExamMarksByYearUnicodeAddGrace/{year}/{semester}/{month}/{pattern}/{unicode}")
	public List<ExamMarksModel> getExamMarksByYearUnicode(@PathVariable int year, @PathVariable String semester,
			@PathVariable String month, @PathVariable String pattern, @PathVariable String unicode) {
		return examMarksService.CheckAndAddGrace(year, semester, month, pattern, unicode);
	}

	@GetMapping("/getExamGraceMarksByYearUnicode/{year}/{semester}/{month}/{pattern}/{unicode}")
	public List<ExamGraceMarksModel> getExamGraceMarksByYearUnicode(@PathVariable int year,
			@PathVariable String semester, @PathVariable String month, @PathVariable String pattern,
			@PathVariable String unicode) {

		return examMarksService.getExamGraceMarks(year,semester,month,pattern,unicode);

	}
	@GetMapping("/getAllGracemarks")
	public List<ExamGraceMarksModel> getAllExamGraceMarks()
	{
		return examMarksService.getAllExamGraceMarks();
	}

}
