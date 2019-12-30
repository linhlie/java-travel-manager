package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.Order;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order,Integer> {

    @Query(value = "select * from orders where user_id=:id", nativeQuery = true)
    List<Order> findByUserId(@Param("id") int id);
}
