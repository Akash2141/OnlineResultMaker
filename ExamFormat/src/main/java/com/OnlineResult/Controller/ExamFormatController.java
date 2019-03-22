package com.OnlineResult.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.ExamFormatModel;
import com.OnlineResult.Service.ExamFormatService;

@RestController
@RequestMapping("/ExamFormat")
public class ExamFormatController {

	@Autowired
	ExamFormatService examFormatService;

	@PostMapping("/addExamFormat")
	public void addExamFormat(@RequestBody ExamFormatModel examFormatModel) {
		examFormatService.addExamFormat(examFormatModel);
	}

	@GetMapping("/allExamFormat")
	public List<ExamFormatModel> allExamFormatModel() {
		return examFormatService.allExamFormat();
	}

	@GetMapping("/getExamFormat/{year}")
	public ExamFormatModel getExamFormatByYear(@PathVariable int year) {

		return examFormatService.getExamFormatByYear(year);
	}

	@PutMapping("/updateExamFormat")
	public void updateExamFormat(@RequestBody ExamFormatModel examFormatModel) {
		examFormatService.updateFormat(examFormatModel);
	}

}
