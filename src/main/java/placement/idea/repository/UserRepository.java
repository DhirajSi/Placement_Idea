package placement.idea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import placement.idea.model.SignUpUsers;

public interface UserRepository extends JpaRepository<SignUpUsers, String>{
	
	

}
