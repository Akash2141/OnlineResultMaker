package com.OnlineResult.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineResult.Entity.BatchMap;

@Repository
public interface StudentBatchMapRepository extends CrudRepository<BatchMap, Long>{
	
}
