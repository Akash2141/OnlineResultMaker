package com.OnlineResult.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.OnlineResult.Entity.ExamGraceMarks;

public interface GraceMarksRepo extends CrudRepository<ExamGraceMarks, Long> {

	List<ExamGraceMarks> findByYearAndSemesterAndMonthAndPatternAndStudentUnicode(int year, String semester,
			String month, String pattern, String unicode);

}
