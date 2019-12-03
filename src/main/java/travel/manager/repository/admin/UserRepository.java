package travel.manager.repository.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travel.manager.model.admin.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);
	
}
