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

import com.OnlineResult.Model.TeacherModel;
import com.OnlineResult.Service.TeacherInfoService;

@RestController
@RequestMapping("/TeacherData")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherInfoController {
	
	@Autowired
	TeacherInfoService teacherInfoService;
	
	@PostMapping("/addTeacher")
	public void addTeacher(@RequestBody TeacherModel teacherModel)
	{
		teacherInfoService.addTeacher(teacherModel);
	}
	
	@GetMapping("/getAllTeacher")
	public List<TeacherModel> getAllTeacher()
	{
		return teacherInfoService.getAllTeacher();
	}
	
	@GetMapping("/getTeacher/{username}/{password}")
	public TeacherModel getTeacher(@PathVariable String username, @PathVariable String password) {
		return teacherInfoService.getTeacher(username, password);
	}
	
//	@GetMapping("/getTeacher/{username}/{password}")
//	public TeacherModel getTeacher(@PathVariable ) {
//		return null ;//teacherInfoService.getTeacher(username, password);
//	}

}
