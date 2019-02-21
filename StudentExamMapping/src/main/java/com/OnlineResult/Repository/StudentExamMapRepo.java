package com.OnlineResult.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.OnlineResult.Entity.StudentExamMap;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface StudentExamMapRepo extends CrudRepository<StudentExamMap, Long>{

}
