package com.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.dto.JwtRequest;
import com.expensetracker.dto.JwtResponse;
import com.expensetracker.service.JwtUtil;
import com.expensetracker.service.MyuserDetailsService;


@RestController
@RequestMapping("/api")
public class JwtController {
	

	@Autowired
	private MyuserDetailsService myUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;

	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			System.out.println(jwtRequest);
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
			 
			
		}
		
		catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		
		UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT "+token);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	

}
