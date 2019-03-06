package com.OnlineResult.Conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.DropStudentModel;
import com.OnlineResult.Service.DropStudentService;

@RestController
@RequestMapping("/Student")
public class DropStudentController {
	
	@Autowired
	DropStudentService dropStudentService;
	
	@PostMapping("saveStudent")
	public void SaveDropStudent(@RequestBody DropStudentModel dropStudentModel)
	{
		dropStudentService.SaveDropStudentData(dropStudentModel);
	}
	
	@GetMapping("/getAllStudent")
	public List<DropStudentModel> GetAllDropStudent()
	{
		return dropStudentService.GetAllDropStudent();
	}
	
	

}
