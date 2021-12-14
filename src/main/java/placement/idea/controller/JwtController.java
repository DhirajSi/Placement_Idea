package placement.idea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import placement.idea.model.AuthenticationRequest;
import placement.idea.model.AuthenticationResponse;
import placement.idea.service.MyUserDetailsService;
import placement.idea.utils.JwtUtil;

@RestController
public class JwtController {

	String jwtToken;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	MyUserDetailsService userDetailsService;

	@GetMapping("/hello")

	public String hello() {
//		System.out.println("%%%%%%%%%%%%%%%%%% %%%%%%%%%%%%%%%%%%%%%%%%%%");
		return "Hello Word";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> getToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

		final String jwtToken = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
	}

}
