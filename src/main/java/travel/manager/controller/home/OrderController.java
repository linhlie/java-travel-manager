package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import travel.manager.dto.OrderDetailBillDTO;
import travel.manager.message.AjaxResponseBody;
import travel.manager.message.Response;
import travel.manager.model.admin.User;
import travel.manager.model.admin.UserDto;
import travel.manager.model.home.Order;
import travel.manager.service.admin.UserService;

import travel.manager.model.home.OrderTour;
import travel.manager.service.home.OrderService;
import travel.manager.service.home.TourService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private TourService tourService;

    @RequestMapping(value = "/order/tour/{data}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> addOrder(@PathVariable("data") String data) {
        AjaxResponseBody result = new AjaxResponseBody();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/order/tour")
    public String addOrderTour(@Valid OrderTour orderTour, Model model) {
        try {
            if (orderTour!=null) {
                if (orderService.addOrder(orderTour));{
                    model.addAttribute("message", "Bạn đã thanh toán thành công!");
                }
            }
        } catch (Exception e) {
            model.addAttribute("message", "Thất bại!  ");
        }
        return "success";
    }
    @RequestMapping(value = "/tour/order/{email}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getOrders(@PathVariable("email") String email) {
        AjaxResponseBody result = new AjaxResponseBody();
        try {
            List<Order>orders = orderService.getOrdersByIdUser(email);
            result.setOrders(orders);
            result.setMsg("Data order");
            result.setStatus(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value = "/order/deleted/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getOrders(@PathVariable("id") int id) {
        AjaxResponseBody result = new AjaxResponseBody();
        try {
            if (orderService.deletedOrder(id)){
                result.setMsg("Deleted Success!");
                result.setStatus(true);
            }
            else {
                result.setStatus(false);
            }

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value = "/order/getOne/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getOrdersDetail(@PathVariable("id") int id) {
        AjaxResponseBody result = new AjaxResponseBody();
        try {
            Order order = orderService.getOne(id);
            result.setMsg("Order");
            result.setStatus(true);
            result.setOrder(order);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/order/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        Response result = new Response();
        try {
            User user = userService.getUserById(id);
            UserDto userDto = new UserDto(user.getId(),user.getEmail(),user.getPhone(),user.getFullName());
            result.setMsg("user");
            result.setStatus(true);
            result.setUserDto(userDto);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value = "/order/tours/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getTours(@PathVariable("id") int id) {
        Response result = new Response();
        try {
            List<OrderDetailBillDTO> ordersDetails = orderService.getOrderDetailById(id);
            result.setMsg("orderDetails");
            result.setStatus(true);
            result.setOrdersDetails(ordersDetails);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/tour/checkout")
    public String edit(Model model){
        model.addAttribute("orderTour", new OrderTour());

        return "home/checkout";
    }

}
