package com.example.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.models.JwtRequest;
import com.example.practice.models.JwtResponse;
import com.example.practice.services.MyUserDetailsService;
import com.example.practice.utils.JwtUtility;
@Component
@RestController
public class HomeController {
	

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String home() {
		return "Welcome";
	}

//	@PostMapping("/authenticate")
//	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
//     System.out.println("Welcome");
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(
//							jwtRequest.getUsername(),
//							jwtRequest.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new Exception("Invalid Credentials", e);
//		}
//
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
//
//		final String token = jwtUtility.generateToken(userDetails);
//
//		// System.out.println("Welcome");
//
//		return new JwtResponse(token);
//	}

}
