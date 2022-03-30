package com.example.demo.repo;
	
	import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;
@Repository
	public interface repository extends MongoRepository<Department,String>
	{
		
	}


