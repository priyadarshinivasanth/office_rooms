package controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import login_details.Login;
import login_details.LoginRepository;

@RestController



public class LoginController {
	
	@RequestMapping("/home")
	String welcome()
	{
		return "Welcome to Homepage";
	}
	
	
	@Autowired
	LoginRepository lr;
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<Login> getall()
	{
		//@Query()
		return (List<Login>) lr.findAll();
	//return val;	
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/signup")
	public Login signup(@Valid @RequestBody Login l)
	{
		return lr.save(l);
		
	}
	
	
	
	

}
