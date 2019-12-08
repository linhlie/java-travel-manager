package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.admin.User;
import travel.manager.model.home.Tour;
import travel.manager.service.admin.SecurityService;
import travel.manager.service.admin.UserService;
import travel.manager.service.home.TourService;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private TourService tourService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/index","/"})
    public String index(Model model, Principal principal) {
        try {
            org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
            User user = userService.getUserByEmail(loginedUser.getUsername());
            model.addAttribute("accounts",user );
            return "index";
        }catch (Exception e){
            return "index";
        }

    }

    @RequestMapping(value = { "/index/tours" ,"/tours"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getListData(Principal principal) {
        AjaxResponseBody result = new AjaxResponseBody();
        try {
            List<Tour> list = tourService.getAll();
            result.setList(list);
            try {
                org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
                if (loginedUser != null) {
                    User user = userService.getUserByEmail(loginedUser.getUsername());
                    result.setUserId(user.getId());
                }
                else {
                    result.setUserId(0);
                }
            }catch (Exception e){}

            result.setMsg("done");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }
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
