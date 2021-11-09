package placement.idea.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import placement.idea.model.SignUpUsers;
import placement.idea.repository.UserRepository;
import placement.idea.utils.Constants;
import placement.idea.utils.UserValidation;
import placement.idea.utils.Validation;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	UserValidation userValidation = new UserValidation();

	public String addNewUser(SignUpUsers user) {
		String response;

		try {
			response = userValidation.userValidation(user);

			if (response == Constants.noErrorFound) {
				userRepository.save(user);

			} else {
				// message=response;
				return response;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return Constants.NewUserSaved;

	}

	public Optional<SignUpUsers> getUser(String emailId) {
		// TODO Auto-generated method stub
		return userRepository.findById(emailId);
	}

}
