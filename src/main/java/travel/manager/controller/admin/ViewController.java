package travel.manager.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = {"/admin","/admin/"})
    public String getAdmin() {
        return "admin/admin";
    }
    @GetMapping("/admin/addCate")
    public String getAddCate() {
        return "admin/AddCategory";
    }
    @GetMapping("/admin/news")
    public String getNews() {
        return "admin/News";
    }
    @GetMapping("/admin/contact")
    public String getContact() {
        return "admin/Contact";
    }
    @GetMapping("/admin/addNews")
    public String getAddNews() {
        return "admin/AddNews";
    }
    @GetMapping("/admin/addTour")
    public String getAddTour() {
        return "admin/AddTour";
    }
    @GetMapping("/admin/tour")
    public String getTour() {
        return "admin/Tour";
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
    @GetMapping("/admin/editTour")
    public String editTour() {
        return "admin/EditTour";
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
    public String viewOrder(){
        return "admin/Order";
    }


}
