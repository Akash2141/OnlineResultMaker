package com.OnlineResult.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.OnlineResult.Entity.SubjectData;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface SubjectDataRepo extends CrudRepository<SubjectData, Long>{

}
