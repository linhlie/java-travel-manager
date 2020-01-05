package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import travel.manager.model.home.OrdersDetails;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrdersDetails,Integer> {
    @Query(value = "select orders.orders_id,user.full_name, user.email, user.phone,orders_details.total_price,orders_details.total_user,tour.tour_name, tour.departure_date, tour.total_days,orders.orders_date\n" +
            "from orders join orders_details on orders_details.orders_id = orders.orders_id\n" +
            "join user on user.id = orders.user_id\n"+
            "join tour on orders_details.tour_id = tour.tour_id where orders.orders_id =:ids", nativeQuery = true)
    List<Object[]> getOrdersDetailsById(@Param("ids") int ids);
}
