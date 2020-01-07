package travel.manager.service.home;

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

import travel.manager.model.home.OrderTour;
import travel.manager.repository.admin.UserRepository;
import travel.manager.repository.home.OrderDetailRepository;

import java.sql.Timestamp;
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

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Boolean addOrder(OrderTour orderTour) {
        User user = userRepository.findByIdUsers(orderTour.getId());
        User user1 = new User(orderTour.getId(),orderTour.getEmail(),user.getPassword(),
                orderTour.getPhone(),orderTour.getFullName(),orderTour.getBirthday(),user.getImageId(),user.getRoles());
        userRepository.save(user1);

        String[] arrTour = orderTour.getOrderTour().split(",");

        Order order1= new Order();
        order1.setUserId(orderTour.getId());
        order1.setOrdersDate(new Timestamp(System.currentTimeMillis()));
        order1.setPaid(false);

        orderRepository.save(order1);

        int ids = orderRepository.finOrderIdMax();

        if(arrTour.length>0){
            List<OrdersDetails>orderDetails = new ArrayList<>();
            for (int i=0;i<arrTour.length;i++){
                String[] arrOrder = arrTour[i].split("-");

                Tour tour = tourService.findOne(Long.parseLong(arrOrder[0]));

                OrdersDetails orderDetail = new OrdersDetails();
                orderDetail.setOrders_id(ids);
                orderDetail.setTotal_user(Integer.parseInt(arrOrder[1]));
                orderDetail.setTotal_price(tour.getPrice() - tour.getPrice()*tour.getDiscount());
                orderDetail.setTour_id(Integer.parseInt(arrOrder[0]));
                orderDetails.add(orderDetail);
                orderDetailRepository.saveS(orderDetail.getOrders_id(),orderDetail.getTour_id(),orderDetail.getTotal_price(),orderDetail.getTotal_user());

            }
            return true;
        }
        else
            return false;

    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersById(int id) {
        return orderRepository.findByUserId(id);
    }

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
