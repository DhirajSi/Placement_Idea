package placement.idea.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import placement.idea.model.SignUpUsers;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<SignUpUsers> user=	userService.getUser(username);
		String emailId=user.get().getEmailId();
		String password=user.get().getPassword();
		System.out.println("1111111111$$$$$$$$$$$$$$$$$$$$$$$$#########"+user.get().getEmailId());
		System.out.println("2222222$$$$$$$$$$$$$$$$$$$$$$$$#########"+user.toString());
		
		return new User(emailId,password,new ArrayList<>());
	} 

}