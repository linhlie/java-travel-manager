package travel.manager.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import travel.manager.model.admin.User;
import travel.manager.model.home.Tour;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	@Query(value = "SELECT * FROM tour_manager.user where id = :id", nativeQuery = true)
	User findByIdUsers(@Param("id") int id);

	@Query(value = "select * from tour_manager.user", nativeQuery = true)
	List<User> findAlls();
	@Query(value = "SELECT * FROM tour_manager.user where id =(SELECT MAX(id) FROM tour_manager.user)", nativeQuery = true)
    int findIdMax();
}
