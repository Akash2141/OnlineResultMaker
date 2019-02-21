package com.OnlineResult.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineResult.Entity.ExamMarks;

@Repository
public interface ExamMarksRepository extends CrudRepository<ExamMarks, Long>{
	
	public List<ExamMarks> findByYearAndSemesterAndMonthAndTypeAndAtkt(int year, String semester, String month, String type, boolean atkt);

}
