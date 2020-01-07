package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import travel.manager.model.home.OrdersDetails;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrdersDetails,Integer> {

    @Query(value = "select orders.orders_id,user.full_name, user.email, user.phone,orders_details.total_price,orders_details.total_user,tour.tour_name, tour.departure_date, tour.total_days,orders.orders_date\n" +
            "from orders join orders_details on orders_details.orders_id = orders.orders_id\n" +
            "join user on user.id = orders.user_id\n" +
            "join tour on orders_details.tour_id = tour.tour_id where orders.orders_id =:ids", nativeQuery = true)
    List<Object[]> getOrdersDetailsById(@Param("ids") int ids);

    @Modifying
    @Query(value = "INSERT INTO orders_details (orders_id, tour_id, total_price, total_user) VALUES (:orders_id, :tour_id, :total_price , :total_user)", nativeQuery = true)
    @Transactional
    void saveS(@Param("orders_id") int orders_id, @Param("tour_id") int tour_id, @Param("total_price") float total_price, @Param("total_user") int total_user);

    @Query(value = "select month(orders_date) as 'thang', sum(total_price) as 'tongtien'\n" +
            "from orders join orders_details on  orders.orders_id = orders_details.orders_id\n" +
            "where year(orders_date)=:year group by  month(orders_date) ORDER BY thang asc", nativeQuery = true)
    List<Object[]> findTourByYear(int  year);
}

