package com.OnlineResult.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineResult.Model.BatchMapModel;
import com.OnlineResult.Service.StudentBatchMapService;

@RestController
@RequestMapping("/Mapping")
public class BatchMapController {
	
	private String academicYear="";
	
	@Autowired
	StudentBatchMapService studentBatchMapService;
	
	@PostMapping("/addStudentBatchMap")
	public void addStudentBatchMap(@RequestBody BatchMapModel batchMapModel)
	{
		studentBatchMapService.addStudentBatchMap(batchMapModel);
	}
	
	@GetMapping("/getStudentBatchMap")
	public List<BatchMapModel> getStudentBatchMap()
	{
		System.out.println();
		return studentBatchMapService.getAllStudentBatchMap();
	}
	
	@GetMapping("/getStudentBatchByYear/{semester}/{calendarYear}")
	public List<BatchMapModel> getStudentBatchMapByAcadAndCal(@PathVariable String semester, @PathVariable int calendarYear)
	{
		List<BatchMapModel> listBatchMapModel=studentBatchMapService.getAllStudentBatchMap();
//		List<BatchMapModel> newListBatchMapModel=new ArrayList<BatchMapModel>();
//		
//		if(semester.equals("semester1") || semester.equals("semester2"))
//		{
//			academicYear="fy";
//			
//		}
//		else if(semester.equals("semester3") || semester.equals("semester4"))
//		{
//			academicYear="sy";
//		}
//		else if(semester.equals("semester5") || semester.equals("semester6"))
//		{
//			academicYear="ty";
//		}
		for(BatchMapModel batch:listBatchMapModel)
		{
			System.out.println(batch.getBatchId().getAcademicYear());
//			if(batch.getBatchId().getAcademicYear().equals(academicYear) && batch.getBatchId().getCalendarYear()==calendarYear)
//			{
//				newListBatchMapModel.add(batch);
//			}
		}
		return listBatchMapModel; 
	}

}
