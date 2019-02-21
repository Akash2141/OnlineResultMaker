package com.OnlineResult.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineResult.Entity.SubjectData;

@Repository
public interface SubjectDataRepo extends CrudRepository<SubjectData, Long>{

}
