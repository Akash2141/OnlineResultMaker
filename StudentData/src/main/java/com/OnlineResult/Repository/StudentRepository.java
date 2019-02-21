package com.OnlineResult.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.OnlineResult.Entity.Student;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface StudentRepository extends CrudRepository<Student, Long>{

}
