package travel.manager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.manager.model.home.CategoryTours;
import travel.manager.model.home.Place;
import travel.manager.model.home.Tour;
import travel.manager.service.home.CategoryTourService;
import travel.manager.service.home.ImageService;
import travel.manager.service.home.PlaceService;
import travel.manager.service.home.TourService;

import javax.validation.Valid;

@Controller
public class ViewController {

    @Autowired
    TourService tourService;
    @Autowired
    CategoryTourService categoryTourService;
    @Autowired
    PlaceService placeService;
    @Autowired
    ImageService imageService;
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
    public String viewOrder(){
        return "admin/Order";
    }


}
