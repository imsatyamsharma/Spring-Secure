package com.example.practice;

import com.example.practice.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.example.practice.models.JwtRequest;
import com.example.practice.models.JwtResponse;
import com.example.practice.services.MyUserDetailsService;

@Component
@RestController
public class HomeController {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	//curl --location --request GET 'http://0.0.0.0:8080/home' \
	//--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYzODUzMDcxNCwiaWF0IjoxNjM4MTcwNzE0fQ.KlIaXJ25hdoK30023LrI7h1eihKwtvKzkqO_DgbW2obgxxTlPENsPVsrktGhHiSR0OvgJ1UO5jaGDu3YF0deiQ' \
	//--header 'Cookie: JSESSIONID=B1A634C792A828936F42B34862A20E22'
	@GetMapping("/home")
	public String home() {
		return "Welcome";
	}

	//curl --location --request POST 'http://0.0.0.0:8080/authenticate' \
	//--header 'Authorization: Basic YWRtaW46cGFzc3dvcmQ=' \
	//--header 'Content-Type: application/json' \
	//--header 'Cookie: JSESSIONID=54E3C619F9E7CE7E7D480D92700DA07D' \
	//--data-raw '{
	//
	// "username":"admin",
	// "password":"password"
	//}'
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}

