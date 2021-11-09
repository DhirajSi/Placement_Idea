package placement.idea.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import placement.idea.model.SignUpUsers;
import placement.idea.service.UserService;
import placement.idea.utils.Constants;

@RestController
public class AppController {
	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public String saveUser(@RequestBody SignUpUsers user) {
		Optional<SignUpUsers> response=	getUser(user.getEmailId());
		if(response.isEmpty()) {
			return userService.addNewUser(user);
		}
		
		
		return Constants.UserEmailIdAlreadyExist;
	}
	
	
	@GetMapping("/getUser/{emailId}")
	public Optional<SignUpUsers> getUser(@PathVariable String emailId){
		return userService.getUser(emailId);
		
	}

}
