package travel.manager.repository.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travel.manager.model.admin.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
	
}
