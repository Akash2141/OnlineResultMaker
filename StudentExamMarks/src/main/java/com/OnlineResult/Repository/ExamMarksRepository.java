package com.OnlineResult.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.OnlineResult.Entity.ExamMarks;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ExamMarksRepository extends CrudRepository<ExamMarks, Long>{
	
	public List<ExamMarks> findByYearAndSemesterAndMonthAndTypeAndPattern(int year, String semester, String month, String type, String pattern);

	public Iterable<ExamMarks> findByYearAndSemesterAndMonthAndPatternAndStudentUnicode(int year, String semester,
			String month, String pattern, String unicode);

	public ExamMarks findByYearAndSemesterAndMonthAndTypeAndPatternAndStudentUnicode(int year, String semester,
			String month, String type, String pattern, String studentUnicode);

}
