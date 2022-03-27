package com.expensetracker.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.expensetracker.service.JwtUtil;
import com.expensetracker.service.MyuserDetailsService;

@Component 
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;


	@Autowired
	private MyuserDetailsService myUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {



		String requestTokenHeader = request.getHeader("Authorization");
		String userName = null;
		String jwtToken = null;
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer"))
		{
			jwtToken = requestTokenHeader.substring(7);
			try {
				userName = this.jwtUtil.extractUsername(jwtToken);
				

				if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
					UserDetails userDetails = myUserDetailsService.loadUserByUsername(userName);
					if(jwtUtil.validateToken(jwtToken, userDetails)) {
						UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
						userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);

					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}

		}

		
		filterChain.doFilter(request, response);

	}



}
