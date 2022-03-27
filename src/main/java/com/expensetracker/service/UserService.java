package com.expensetracker.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;
import com.expensetracker.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAll(){
		List <User> users  = userRepository.findAll();
		return users;
	}

	public @Valid User createUser(@Valid User user) {

		return userRepository.save(user);
		
	}

	public User updateUser(Long id,User editeduser) {
		
		Optional <User> option =  userRepository.findById(id);
		if(option.isPresent()){
			editeduser.setId(id);
			return userRepository.save(editeduser);
		}
		else {
			return null;
		}
	}
	
	public Boolean deleteUser(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			if(!userRepository.findById(id).isPresent())
				return true;
		}
		return false;

	}

	public List<Expense> getAllExpensesFor(Long id) {
		Optional<User> option = userRepository.findById(id);
		if(option.isPresent()) {
			User user = option.get();
			return user.getExpense();
			}
		else
			return null;
		
	}


}
