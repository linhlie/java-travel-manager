package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.dto.OrderDetailsDTO;
import travel.manager.repository.home.OrderDetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetailsDTO> getOrderDetails(int id){
        List<Object[]> objects1 = orderDetailRepository.getOrdersDetailsById(id);
//        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
        List<OrderDetailsDTO> orderDetailsDTO = new ArrayList<>();
        for (Object[] objects : objects1
        ){
            OrderDetailsDTO orderDetailsDTOS = new OrderDetailsDTO();
//            orderDetailsDTOS.setOrders_id(Integer.parseInt(String.valueOf(objects[0])));
//            orderDetailsDTOS.setTour_name(String.valueOf(objects[3]));
            System.out.println(objects[0]);
            System.out.println(objects[1]);
            System.out.println(objects[2]);
            System.out.println(objects[3]);
            System.out.println(objects[4]);
            System.out.println(objects[5]);
            System.out.println(objects[6]);
            System.out.println(objects[7]);
            System.out.println(objects[8]);
            System.out.println(objects[9]);
        }

        return orderDetailsDTO;
    }
}
