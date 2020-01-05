package travel.manager.service.home;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.dto.OrderDetailBillDTO;
import travel.manager.model.admin.OrdersDTO;
import travel.manager.model.admin.User;
import travel.manager.model.home.Order;
import travel.manager.model.home.OrdersDetails;
import travel.manager.model.home.Tour;
import travel.manager.repository.home.OrderRepository;
import travel.manager.service.admin.UserService;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private TourService tourService;


    public Order addOrder(String data) {
        LocalDateTime date = LocalDateTime.now();
        String[] arrOrder= data.split(",");
        Order order = new Order();
        User user = userService.getUserByEmail(arrOrder[2]);
        order.setUserId(user.getId());
//        order.setTourId(Long.parseLong(arrOrder[1]));
//        order.setTotalPeople(Integer.parseInt(arrOrder[0]));
        order.setOrdersDate(new Timestamp(System.currentTimeMillis()));
        orderRepository.save(order);
        return order;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    public List<Order> getOrdersById(int id) {return orderRepository.findByUserId(id);}
    public List<OrdersDTO> getAllOrders(){
        List<Object[]> objects = orderRepository.getInfoOrder();
        List<OrdersDTO> ordersDTOS = new ArrayList<>();
        for (Object[] obj : objects){
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setOrders_id(Integer.parseInt((String.valueOf(obj[0]))));
            ordersDTO.setFull_name((String.valueOf(obj[1])));
            ordersDTO.setEmail((String.valueOf(obj[2])));
            ordersDTO.setIs_paid(Boolean.parseBoolean((String.valueOf(obj[3]))));
            ordersDTO.setOrders_date(String.valueOf(obj[4]));
            ordersDTOS.add(ordersDTO);
        }
        return ordersDTOS;
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
    public Order getOne(int id){
        return orderRepository.getOne(id);
    }

    public List<OrderDetailBillDTO> getOrderDetailById(int id) {
        List<Object[]> objects1 = orderRepository.findOrderDetailById(id);
        List<OrderDetailBillDTO>ordersDetails = new ArrayList<OrderDetailBillDTO>();
        for (Object[] objects : objects1){
            OrderDetailBillDTO orderDetail = new OrderDetailBillDTO();
            Tour tour = tourService.findOne(Long.parseLong(String.valueOf(objects[1])));

            orderDetail.setOrders_id(Integer.parseInt(String.valueOf(objects[0])));
            orderDetail.setTour_id(Integer.parseInt(String.valueOf(objects[1])));
            orderDetail.setTotal_price(Float.parseFloat(String.valueOf(objects[2])));
            orderDetail.setTotal_user(Integer.parseInt(String.valueOf(objects[3])));
            orderDetail.setNameTour(tour.getTourName());
            orderDetail.setDate(tour.getDepartureDate());
            orderDetail.setDiscount(tour.getDiscount());
            ordersDetails.add(orderDetail);
        }
        return ordersDetails;

    }
}
