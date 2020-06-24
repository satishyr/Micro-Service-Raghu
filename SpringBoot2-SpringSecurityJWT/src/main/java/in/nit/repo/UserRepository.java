package in.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.User;
import java.lang.String;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	User findByUserName(String username);
}
