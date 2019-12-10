package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travel.manager.service.home.PlaceService;


@Controller
public class HomeController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/offers")
    public String viewOffers() {
        return "home/offers";
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

}
