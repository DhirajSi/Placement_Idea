package placement.idea.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import placement.idea.model.SignUpUsers;
import placement.idea.repository.UserRepository;
import placement.idea.service.UserService;

public class UserValidation extends Validation {
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

	public String userValidation(SignUpUsers user) {
		String response = "";

		try {
			if (user.getEmailId() != null) {
				response = Validation.emailValidation(user.getEmailId());

				if (response != Constants.noErrorFound) {

					return response;
				}

			}
			if (user.getUserName() != null) {
				response = Validation.userNameValidation(user.getUserName());
				if (response != Constants.noErrorFound) {
					return response;
				}
			}

		} catch (Exception e) {

		}
		return response;

	}

	
	
}
