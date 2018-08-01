package controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rooms.Room;
import rooms.Roomrepository;

@RestController


public class Roomcontroller {
	
	@RequestMapping("/room")
	public String roomwelcome()
	{
		return "Welcome to rooms!!";
		
	}
	
	@Autowired
	Roomrepository rr;
	
	@PostMapping("/room/details")
	public String store(@Valid @RequestBody Room r)
	{
		rr.save(r);
		return "Room details are stored";
		
	}
	
	@GetMapping("/room/all")
	public List<Room> getall()
	{
		return (List<Room>) rr.findAll();
	}
	
	
	@GetMapping("/room/{id}")
	public Optional<Room> getroom(@PathVariable(value="id") Long id)
	{
		return rr.findById(id);
	}
	
//	@GetMapping("/room/name")
//	public List<Room> getname(@RequestParam String name)
//	{
//		return rr.findbyTitle();
//	}
	
	
	

}
