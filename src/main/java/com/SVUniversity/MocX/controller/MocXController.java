package com.SVUniversity.MocX.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SVUniversity.MocX.domain.UserDetails;
import com.SVUniversity.MocX.dto.LoginStatusDTO;
import com.SVUniversity.MocX.jwt.JwtTokenUtil;
import com.SVUniversity.MocX.service.JwtUserDetailsService;




@RestController
@CrossOrigin(origins = "*")
public class MocXController {
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping("/check")
	public String check()
	{
	
		return "{\"string\":\"demo\"}";
	}
	
	private void authenticate(String username, String password) throws Exception {
		//	System.out.println("entered in authenticate sub function...");
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			} catch (DisabledException e) {
				throw new Exception("USER_DISABLED", e);
			} catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}
			//System.out.println("exited in authenticate sub function...");
		}
	
	@RequestMapping(value = "/login")
 	public LoginStatusDTO createAuthenticationToken(@RequestParam("username") String username, @RequestParam("otp") String otp) {
 		System.out.println("entered in authenticate...");
 		LoginStatusDTO loginStatus=new LoginStatusDTO();
 		try
 		{
 			username=username.toLowerCase().replaceAll("to","");
			
 		authenticate(username, otp);

 		final org.springframework.security.core.userdetails.UserDetails userDetails = userDetailsService
 				.loadUserByUsername(username);

 		final String token = jwtTokenUtil.generateToken(userDetails);
 		System.out.println("exited in authenticate...");
		
		
		
 		
		
 		loginStatus.setLoginStatus(true);
		
 		loginStatus.setJwt(token);
			
 		loginStatus.setRole(userDetails.getAuthorities().toArray()[0].toString());
 		}
 		catch(Exception ex)
 		{
 			System.out.println("Error Occured while logging in "+ex);
 		}
	
 		return loginStatus;
 	}
}
