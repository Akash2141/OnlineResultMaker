package com.OnlineResult.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.OnlineResult.Entity.ExamFormat;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ExamFormatRepository extends CrudRepository<ExamFormat, Long>{

}
