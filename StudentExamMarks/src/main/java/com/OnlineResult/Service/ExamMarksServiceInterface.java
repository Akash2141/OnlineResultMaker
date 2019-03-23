package com.OnlineResult.Service;

import java.util.List;

import com.OnlineResult.Model.ExamGraceMarksModel;
import com.OnlineResult.Model.ExamMarksModel;

public interface ExamMarksServiceInterface {
	
	public void addExamMarks(ExamMarksModel examMarksModel);
	public List<ExamMarksModel> getExamMarks();
	public List<ExamMarksModel> CheckAndAddGrace(int year, String semester, String month, String pattern, String Unicode);
	public List<ExamMarksModel> getExamMarksByYearSemester(int year, String semester, String month, String type,
			String pattern);

}
