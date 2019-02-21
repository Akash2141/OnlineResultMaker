package com.OnlineResult.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineResult.Entity.Teacher;

@Repository
public interface TeacherInfoRepo extends CrudRepository<Teacher, Long>{

}
