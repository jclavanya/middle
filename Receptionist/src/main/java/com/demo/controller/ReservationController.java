package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.GuestList;
import com.demo.model.Reservation;
import com.demo.model.ReservationList;
import com.demo.service.ReservationService;




@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;

	@GetMapping("/hello")
	public String hello() {
		return "Reservation Microservice";
	}
	public List<Reservation> getAllReservation()
	{
	return service.getAllReservation();
	}
	
	@GetMapping("/getAlldetails")
	public ReservationList getAlldetails() {
		ReservationList list = new ReservationList();
		list.setResList(this.service.getResList());
		return list;
	}

	
	@RequestMapping(method = RequestMethod.POST, value="/addReservation")
	public void addReservation(@RequestBody Reservation Rsvn)
	{
	service.addReservation(Rsvn);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/updateReservation")
	public void updateReservation(@RequestBody Reservation Rsvn)
	{
	service.updateReservation(Rsvn);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteReservation/{id}")
	public void delete(@PathVariable ("id")Long bookingId)
	{
	service.delete(bookingId);
	}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
