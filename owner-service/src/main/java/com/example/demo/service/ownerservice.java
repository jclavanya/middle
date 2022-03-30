package com.example.demo.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Department;
import com.example.demo.repo.repository;



@Service
public class ownerservice{
	
	@Autowired
	private repository repo;
	
	
	public List<Department> department()
	{
		List<Department> dep=new ArrayList<>();
		repo.findAll()
		.forEach(dep::add);
		return dep;
	}
	
	
//add department by owner	
public void adddepartment(Department dpt)

{
	repo.save(dpt);
}


//update user by id
public void updatedepartment(String id, Department dpt) {
	repo.save(dpt);
	}



//delete department by id
public void deletedepartment(String id) {
	repo.deleteById(id);
}


}







