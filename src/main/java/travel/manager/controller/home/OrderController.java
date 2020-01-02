package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.home.Order;
import travel.manager.service.home.OrderService;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/tour/{data}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> addOrder(@PathVariable("data") String data) {
        AjaxResponseBody result = new AjaxResponseBody();
        try {
            Order order = orderService.addOrder(data);
            result.setOrder(order);
            result.setMsg("done");
            result.setStatus(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
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
}
