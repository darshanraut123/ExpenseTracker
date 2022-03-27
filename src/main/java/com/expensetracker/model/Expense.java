package com.expensetracker.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Min(1)
	private Long amount;
//	private Category category;
	private String description;
	
	private Date expenseDate;
	
	@NotNull
	private Long user_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}


	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", amount=" + amount + ", description=" + description + ", expenseDate="
				+ expenseDate + "";
	}
	
	
}
