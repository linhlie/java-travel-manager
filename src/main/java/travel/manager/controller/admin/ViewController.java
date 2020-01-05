package travel.manager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.manager.dto.OrderDetailsDTO;
import travel.manager.model.home.*;
import travel.manager.service.admin.CategoryNewsService;
import travel.manager.service.admin.UserService;
import travel.manager.service.home.*;

import javax.validation.Valid;

@Controller
public class ViewController {

    @Autowired
    TourService tourService;
    @Autowired
    CategoryTourService categoryTourService;
    @Autowired
    CategoryNewsService categoryNewsService;
    @Autowired
    PlaceService placeService;
    @Autowired
    ImageService imageService;
    @Autowired
    UserService userService;
    @Autowired
    NewsService newsService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrdersDetailService getOrderDetails;

    @GetMapping(value = {"/admin","/admin/"})
    public String getAdmin() {
        return "admin/admin";
    }
    @GetMapping("/admin/addCate")
    public String getAddCate() {
        return "admin/AddCategory";
    }
    @GetMapping("/admin/contact")
    public String getContact() {
        return "admin/Contact";
    }
    @GetMapping("/admin/news")
    public String getNews(Model model) {
        model.addAttribute("news",newsService.getAll());
        return "admin/News";
    }
    @GetMapping("/admin/addNews")
    public String getAddNews(Model model) {
    model.addAttribute("news",new News());
    model.addAttribute("categoryNews", categoryNewsService.getCateNews());
        return "admin/AddNews";
    }
    @PostMapping("/admin/saveNews")
    public String saveNews(@Valid News news, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "admin/AddNews";
        }
        newsService.save(news);
        return "redirect:/admin/news";
    }
    @GetMapping("/admin/news/{id}/edit")
    public String updateNews(Model model,@PathVariable Integer id) {
        model.addAttribute("news",newsService.getNewsById(id));
        model.addAttribute("categoryNews", categoryNewsService.getCateNews());
        return "admin/AddNews";
    }

    @GetMapping("/admin/news/{id}/delete")
    public String deleteNews(@PathVariable Integer id, RedirectAttributes redirect) {
        newsService.deleteNews(id);
        return "redirect:/admin/news";
    }
    @GetMapping("/admin/addTour")
    public String getAddTour(Model model) {
        model.addAttribute("tour",new Tour());
        model.addAttribute("categoryTour",categoryTourService.getCateTours());
        model.addAttribute("place",placeService.getAll());
        return "admin/AddTour";
    }

    @PostMapping("/admin/saveTour")
    public String saveTour(@Valid Tour tour, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "admin/AddTour";
        }
        tourService.save(tour);
        return "redirect:/admin/tour";
    }

    @GetMapping("/admin/tour")
    public String getTour(Model model) {
        model.addAttribute("tour",tourService.getAll());
//        model.addAttribute("image",imageService.)
        return "admin/Tour";
    }
    @GetMapping("/tour/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        tourService.delete(id);
        return "redirect:/admin/tour";
    }

    @GetMapping("/admin/tour/{id}/edit")
    public String updateTour(Model model,@PathVariable Long id) {
        model.addAttribute("tour",tourService.findOne(id));
        model.addAttribute("categoryTour",categoryTourService.getCateTours());
        model.addAttribute("place",placeService.getAll());
        return "admin/AddTour";
    }
    @GetMapping("/admin/updateTour")
    public String edit(Model model){
        return "admin/EditTour";
    }

    @GetMapping("/admin/user")
    public String getAllUser(Model model){
        model.addAttribute("users",userService.getAll());
        return "admin/User";
    }
    @GetMapping("/admin/user/{id}/delete")
    public String deleteUser(@PathVariable Integer id, RedirectAttributes redirect) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }
    @GetMapping("/admin/addUser")
    public String getAddUser() {
        return "admin/AddUser";
    }
    @GetMapping("/admin/updateUser")
    public String updateUser() {
        return "admin/EditUser";
    }
    @GetMapping("/admin/cateNews")
    public String getCateNews() {
        return "admin/CategoryNews";
    }
    @GetMapping("/admin/cateTour")
    public String getCateTour() {
        return "admin/CategoryTour";
    }
    @GetMapping("/admin/editNews")
    public String editNews() {
        return "admin/EditNews";
    }

    @GetMapping("/admin/editCate")
    public String editCate() {
        return "admin/EditCategory";
    }
    @GetMapping("/admin/place")
    public String viewPlace(){
        return "admin/Place";
    }
    @GetMapping("/admin/order")
    public String viewOrder(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        getOrderDetails.getOrderDetails(18);
        return "admin/Order";
    }
    @GetMapping("/admin/order/{id}/delete")
    public String deleteOrders(@PathVariable Integer id, RedirectAttributes redirect){
        orderService.deletedOrder(id);
        return "redirect:/admin/order";
    }
    @GetMapping("/admin/{id}/order")
    public String Orders(Model model,@PathVariable Integer id){
        model.addAttribute("order",orderService.getOrdersById(id));
        return "admin/OrderDetails";
    }
    @GetMapping("/admin/orderDetails")
    public String viewOrderDetails(){
        return "admin/orderDetails";
    }

}
