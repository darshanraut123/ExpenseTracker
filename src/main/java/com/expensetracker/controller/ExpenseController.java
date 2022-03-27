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
import com.expensetracker.service.ExpenseService;
import com.expensetracker.service.UserService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("")
	public List <Expense> getAll() {
		return expenseService.getAll();
	}
	
	@PostMapping("")
	public Expense createExpense(@Valid @RequestBody Expense expense) {
		return expenseService.createExpense(expense);
	}
	

	
//	@PutMapping("/{id}")
//	public ResponseEntity<Expense> updateUser(@Valid @RequestBody Expense expense,@PathVariable Long id) {
//		 User responseUser = expenseService.updateExpense(id,expense);
//		 if(responseUser==null)
//		 {
//			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		 }
//		 else {
//			 return new ResponseEntity<>(HttpStatus.ACCEPTED);
//		 }
//	}
	
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
//		Boolean userDeleted = expenseService.deleteUser(id);
//		if(userDeleted) {
//			return new ResponseEntity<User>(HttpStatus.ACCEPTED);
//		}
//		else
//		{
//			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//		}
//	}
}
