package com.expensetracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.model.Expense;
import com.expensetracker.model.User;
import com.expensetracker.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public List <User> getAll() {
		return userService.getAll();
	}
	
	@PostMapping("")
	public User createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@PathVariable Long id) {
		 User responseUser = userService.updateUser(id,user);
		 if(responseUser==null)
		 {
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		 }
		 else {
			 return new ResponseEntity<User>(responseUser,HttpStatus.ACCEPTED);
		 }
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		Boolean userDeleted = userService.deleteUser(id);
		if(userDeleted) {
			return new ResponseEntity<User>(HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/expense/{id}")
	public List<Expense> getAllExpenses(@PathVariable Long id){
	List<Expense> expenses = userService.getAllExpensesFor(id);
		if(expenses==null) return null;
		else return expenses;
		
	}

}
