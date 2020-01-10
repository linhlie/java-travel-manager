package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
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
import java.security.Principal;
import java.util.List;
import java.util.Random;

@Controller
public class OrderController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private TourService tourService;

    private static char[] confirm;

    OrderTour _orderTour= new OrderTour();

    @RequestMapping(value = "/order/tour/{data}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> addOrder(@PathVariable("data") String data) {
        AjaxResponseBody result = new AjaxResponseBody();
        return ResponseEntity.ok(result);
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
    static char[] OTP(int len)
    {
        String numbers = "0123456789";

        Random rndm_method = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++)
        {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }
    void sendEmail(String subject, String mail, String code) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail);
        msg.setSubject(subject);
        msg.setText(code);

        javaMailSender.send(msg);

    }
    @PostMapping("/order/tour")
    public String addOrderTour(@Valid OrderTour orderTour, Model model, Principal principal) {
        try {
            if (orderTour!=null) {
                org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
                _orderTour = orderTour;
                confirm = OTP(6);
                System.out.println(confirm);
                sendEmail("Send code confirm",loginedUser.getUsername(),"Mã xác nhận của bạn là: "+String.valueOf(confirm));
            }
        } catch (Exception e) {
        }
        return "redirect:/order/confirm";
    }
    @GetMapping("/order/confirm/{confirm}")
    @ResponseBody
    public ResponseEntity<?>confirmOrder(@PathVariable ("confirm") String  confirms) {
        Response response = new Response();
        if (Integer.parseInt(String.valueOf(confirms))==Integer.parseInt(String.valueOf(confirm))){
            orderService.addOrder(_orderTour);
            response.setMsg("done");
            response.setStatus(true);
        }
        else {
            response.setMsg("false");
            response.setStatus(false);
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/order/getOne/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getOrdersDetail(@PathVariable("id") int id,Principal principal) {
        AjaxResponseBody result = new AjaxResponseBody();
        try {
            Order order = orderService.getOne(id);
            org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
            sendEmail("Thông báo",loginedUser.getUsername(),"Cảm ơn bạn đã đặt tour tại Travelix, chúng tôi sẽ liên hệ sớm nhất cho bạn!");

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
    @GetMapping("/order/confirm")
    public String confirm(Model model){
        return "confirm";
    }
    @GetMapping("/order/success")
    public String success(Model model){
        return "success";
    }

}
