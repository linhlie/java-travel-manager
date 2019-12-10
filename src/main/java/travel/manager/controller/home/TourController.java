package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.admin.User;
import travel.manager.model.home.Image;
import travel.manager.model.home.Place;
import travel.manager.model.home.Tour;
import travel.manager.service.admin.UserService;
import travel.manager.service.home.ImageService;
import travel.manager.service.home.PlaceService;
import travel.manager.service.home.TourService;

import java.security.Principal;
import java.util.List;

@Controller
public class TourController {
    @Autowired
    private TourService tourService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @Autowired
    PlaceService placeService;

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
    public ResponseEntity<?> getListDataTour(Principal principal) {
        AjaxResponseBody result = new AjaxResponseBody();
        try {
            List<Tour> list = tourService.getAll();
            if(!list.isEmpty()) {
                result.setList(list);
            }

            List<Image>imagesTours = imageService.getToursImages();
            if(!imagesTours.isEmpty()) {
                result.setImagesTours(imagesTours);
            }

            List<Place>places =placeService.getAll();
            if (!places.isEmpty()) {
                result.setPlaces(places);
            }

            List<Image>imagesPlaces = imageService.getPlaceImages();
            if(!imagesPlaces.isEmpty()){
                result.setImagesPlaces(imagesPlaces);
            }

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
}

