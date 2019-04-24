package com.OnlineResult.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.OnlineResult.Entity.Teacher;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface TeacherInfoRepo extends CrudRepository<Teacher, Long>{

	Teacher findByUsernameAndPassword(String username, String password);

}
