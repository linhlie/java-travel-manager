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

    @Query(value = "select orders.orders_id, user.full_name, user.email, orders.is_paid, orders.orders_date\n" +
            "from user join orders on user.id = orders.user_id",nativeQuery = true)
    List<Object[]> getInfoOrder();
    @Query(value = "",nativeQuery = true)
    List<Order> findByOrOrdersId(@Param("id") int id);

    @Query(value = "select  * from orders where orders_id=:id",nativeQuery = true)
    Order getOne(@Param("id") int id);

    @Query(value = "select  * from orders_details where orders_id=:id",nativeQuery = true)
    List<Object[]> findOrderDetailById(@Param("id") int id);

    @Query(value = "SELECT MAX(orders_id) FROM tour_manager.orders", nativeQuery = true)
    int finOrderIdMax();
}
