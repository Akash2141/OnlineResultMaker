package com.OnlineResult.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.TeacherModel;
import com.OnlineResult.Service.TeacherInfoService;

@RestController
@RequestMapping("/TeacherData")
public class TeacherInfoController {
	
	@Autowired
	TeacherInfoService teacherInfoService;
	
	@PostMapping("/addTeacher")
	public void addTeacher(@RequestBody TeacherModel teacherModel)
	{
		teacherInfoService.addTeacher(teacherModel);
	}
	
	@GetMapping("/getTeacher")
	public List<TeacherModel> getTeacher()
	{
		return teacherInfoService.getAllTeacher();
	}

}
