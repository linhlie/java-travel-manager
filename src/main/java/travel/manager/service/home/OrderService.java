package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.admin.User;
import travel.manager.model.home.Order;
import travel.manager.repository.home.OrderRepository;
import travel.manager.service.admin.UserService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;


    public Order addOrder(String data) {
        LocalDateTime date = LocalDateTime.now();
        String[] arrOrder= data.split(",");
        Order order = new Order();
        User user = userService.getUserByEmail(arrOrder[2]);
        order.setUserId(user.getId());
        order.setTourId(Long.parseLong(arrOrder[1]));
        order.setTotalPeople(Integer.parseInt(arrOrder[0]));
        order.setOrdersDate(new Timestamp(System.currentTimeMillis()));
        orderRepository.save(order);
        return order;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByIdUser(String email) {
        int id = userService.getUserByEmail(email).getId();
        List<Order> orders = orderRepository.findByUserId(id);
        return orders;
    }

    public boolean deletedOrder(int id) {
        if (orderRepository.findById(id)!=null){
            orderRepository.deleteById(id);
            return true;
        }
        else
            return false;

    }
}
