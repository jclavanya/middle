package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.inventory;

import com.example.demo.service.inventoryService;


@RestController

//@RequestMapping("/inventory")
@CrossOrigin(origins="http://localhost:4200")
public class inventoryController {
    //@Bean
	@Autowired
	private inventoryService inventoryService;
	
	//@Autowired
	//private DepartmentRepository ownerRepo;
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllInv")
	public List<inventory> getAllInventory(){
		return inventoryService.getAllInventory();
	}
	@RequestMapping(method=RequestMethod.POST, value="/addInv")
	public void addInventory(@RequestBody inventory inventorys)
	{
		inventoryService.addInventory(inventorys);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/updateInv")
	public void updateInventory(@RequestBody inventory inventorys, @PathVariable int inventory_id )
	{
		inventoryService.updateInventory(inventory_id,inventorys);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteByInv/{id}")
	public void deleteInventory( @PathVariable int inventory_id )
	{
		inventoryService.deleteInventory(inventory_id);
	}
	
}

