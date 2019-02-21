package com.OnlineResult.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineResult.Entity.SubjectData;
import com.OnlineResult.Model.SubjectDataModel;
import com.OnlineResult.Repository.SubjectDataRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class SubjectDataService {
	
	@Autowired
	SubjectDataRepo subjectDataRepo;
	
	public void addSubjectData(SubjectDataModel subjectDataModel)
	{
		Gson gson = new Gson();
		String json = gson.toJson(subjectDataModel);
		SubjectData examMarks = gson.fromJson(json, SubjectData.class);
		subjectDataRepo.save(examMarks);
	}
	
	public List<SubjectDataModel> getAllSubjectData()
	{
		Iterable<SubjectData> itSubjectData = subjectDataRepo.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(itSubjectData);
		List<SubjectDataModel> listSubjectDataModel = gson.fromJson(json, new TypeToken<List<SubjectDataModel>>() {
		}.getType());
		return listSubjectDataModel;
	}

}
