package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/placedetails.html")
    public String viewPlaceDetails() {
        return "home/placedetails";
    }

}
