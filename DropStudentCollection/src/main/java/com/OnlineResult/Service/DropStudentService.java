package com.OnlineResult.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.OnlineResult.Entity.DropStudent;
import com.OnlineResult.Model.DropStudentModel;
import com.OnlineResult.Repository.DropStudentRepository;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@Service
public class DropStudentService {
	
	@Autowired
	DropStudentRepository dropStudentRepository;
	
	public void SaveDropStudentData(@RequestBody DropStudentModel dropStudentModel)
	{
		Gson gson = new Gson();
		String json = gson.toJson(dropStudentModel);
		DropStudent dropStudent = gson.fromJson(json, DropStudent.class);
		dropStudentRepository.save(dropStudent);
	}
	
	public List<DropStudentModel> GetAllDropStudent()
	{
		Iterable<DropStudent> itStudent=dropStudentRepository.findAll();
		Gson gson=new Gson();
		String json=gson.toJson(itStudent);
		List<DropStudentModel> listDropStudentModel=gson.fromJson(json, new TypeToken<List<DropStudentModel>>() {
		}.getType());
		return listDropStudentModel;
	}

}
