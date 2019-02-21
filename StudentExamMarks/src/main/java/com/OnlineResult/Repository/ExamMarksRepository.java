package com.OnlineResult.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.OnlineResult.Entity.ExamMarks;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ExamMarksRepository extends CrudRepository<ExamMarks, Long>{
	
	public List<ExamMarks> findByYearAndSemesterAndMonthAndTypeAndAtkt(int year, String semester, String month, String type, boolean atkt);

}
