package com.expensetracker.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;
import com.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	public List<Expense> getAll() {
		try{
			return expenseRepository.findAll();
		}
		catch(Exception err){
			System.out.println(err.getMessage());
			return null;
		}

	}

	public Expense createExpense(Expense expense) {
		try {
			return expenseRepository.save(expense);
		}
		catch(Exception err) {
			System.out.println(err.getMessage());
			return null;
		}
	}

}
