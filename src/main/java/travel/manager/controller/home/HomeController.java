package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import travel.manager.dto.UserRequest;
import travel.manager.model.admin.RegisterUser;
import travel.manager.service.home.PlaceService;


@Controller
public class HomeController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/tour")
    public String vewTours() {
        return "home/tour";
    }

    @GetMapping("/tour-vi")
    public String vewToursVN() {
        return "home/tourVN";
    }

    @GetMapping("/tour-na")
    public String vewToursNa() {
        return "home/tourInternational";
    }

    @GetMapping("/about")
    public String viewAbout() {
        return "home/about";
    }

    @GetMapping("/news")
    public String viewNews() {
        return "home/news";
    }

    @GetMapping("/contact")
    public String viewContact() {
        return "home/contact";
    }

    @GetMapping("/cart")
    public String viewCart() {
        return "home/cart";
    }

    @GetMapping("/place")
    public String viewPlace() {
        return "home/place";
    }

    @GetMapping("/details.html")
    public String viewTourDetails() {
        return "home/tourdetails";
    }

    @GetMapping("/place-detail.html")
    public String viewPlaceDetails() {
        return "home/placedetails";
    }

    @GetMapping("/news-detail")
    public String viewNewsDetails() {
        return "home/newsdetails";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ADMIN')")
    public String viewNewsProfile(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "home/profile";
    }

}
