package com.expensetracker.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=3,max=15)
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty
	@Size(min=1,max=15)
	@Column(name="last_name")
	private String lastName;
	
	@Email
	@NotEmpty
	private String email;
	
	private String gender;
	
	
	@Column(name="registration_date")
	private Date registrationDate;
	
	@NotEmpty
	private String password;
	
	@DecimalMin("1000.00")
	@DecimalMax("1000000.00")
	private Long salary;
	
	private String avatar;
	
	@OneToMany(mappedBy = "user_id",cascade = CascadeType.PERSIST)
	@JsonManagedReference
	private List <Expense> expense;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<Expense> getExpense() {
		return expense;
	}

	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", registrationDate=" + registrationDate + ", password=" + password
				+ ", salary=" + salary + ", avatar=" + avatar + ", expense=" + expense + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
		
}
