package com.OnlineResult.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineResult.Entity.DropStudent;

@Repository
public interface DropStudentRepository extends CrudRepository<DropStudent, Long>{

}
