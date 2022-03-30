package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Department;

import com.example.demo.jwtmodels.AuthenticationRequest;
import com.example.demo.jwtmodels.AuthenticationResponse;
import com.example.demo.jwtutil.JwtUtil;
import com.example.demo.service.ownerservice;

@RestController
//@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
	
	@Autowired
	private ownerservice service;
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	
	@GetMapping("/getdepartment")
	
	public List<Department> depart()
	{
		return service.department();
	}
	
	
	//Create Department details
	@RequestMapping(method=RequestMethod.POST, value="/department")
	public void add(@RequestBody Department dpt)
	{
	  service.adddepartment(dpt);
	}
	
	
	
	//Update values by ID
	@RequestMapping(method=RequestMethod.PUT, value="/department/{id}")
	public void Update(@RequestBody Department dpt,@PathVariable String id)
	{
	   service.updatedepartment(id,dpt);
	}
	
	
	//Delete values by ID
	@RequestMapping(method=RequestMethod.DELETE, value="/department/{id}")
	public void delete(@PathVariable String id)
	{
	   service.deletedepartment(id);
	}
	
	
	@GetMapping("/token")
	public String welcome()
	{
		return "welcome to hotel Plaza";
	}
	
	
//	@RequestMapping(value= "/authenticate", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
//	try {
//	authenticationManager.authenticate(
//	new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//	}catch (BadCredentialsException e) {
//	throw new Exception("Incorrect username or password",e);
//	}
//	final UserDetails userDetails=userDetailsService
//	.loadUserByUsername(authenticationRequest.getUsername());
//	final String jwt=jwtTokenUtil.generateToken(userDetails);
//	return ResponseEntity.ok(new AuthenticationResponse(jwt));
//
//	}
}
	
	
	
	


