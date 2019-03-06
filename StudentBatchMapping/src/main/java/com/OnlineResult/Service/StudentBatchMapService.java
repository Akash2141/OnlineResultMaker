package com.OnlineResult.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineResult.Entity.BatchMap;
import com.OnlineResult.Model.BatchMapModel;
import com.OnlineResult.Repository.StudentBatchMapRepository;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@Service
public class StudentBatchMapService {
	
	@Autowired
	StudentBatchMapRepository studentBatchMapRepository;
	
	public void addStudentBatchMap(BatchMapModel batchMapModel)
	{
		Gson gson = new Gson();
		String json = gson.toJson(batchMapModel);
		BatchMap batchMap = gson.fromJson(json, BatchMap.class);
		studentBatchMapRepository.save(batchMap);
	}
	
	public List<BatchMapModel> getAllStudentBatchMap()
	{
		Iterable<BatchMap> itStudent=studentBatchMapRepository.findAll();
		Gson gson=new Gson();
		String json=gson.toJson(itStudent);
		List<BatchMapModel> listBatchMapModel=gson.fromJson(json, new TypeToken<List<BatchMapModel>>() {
		}.getType());
		return listBatchMapModel;
	}
//	public List<BatchMapModel> getStudentByYear(String academicYear, int calendarYear)
//	{
//		System.out.println(academicYear+""+calendarYear);
//		Iterable<BatchMap> itStudent=studentBatchMapRepository.findAll();
//		Gson gson=new Gson();
//		String json=gson.toJson(itStudent);
//		List<BatchMapModel> listBatchMapModel=gson.fromJson(json, new TypeToken<List<BatchMapModel>>() {
//		}.getType());
//		List<BatchMapModel> newListBatchMapModel=new ArrayList<BatchMapModel>();
//		for(BatchMapModel batch:listBatchMapModel)
//		{
//			System.out.println(batch.getBatchId().getAcademicYear().toString());
//			if(batch.getBatchId().getAcademicYear().equals(academicYear) && batch.getBatchId().getCalendarYear()==calendarYear)
//			{
//				newListBatchMapModel.add(batch);
//			}
//		}
//		return listBatchMapModel;
//	}

}
