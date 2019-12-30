package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import travel.manager.message.AjaxResponseBody;
import travel.manager.message.TourResponeBody;
import travel.manager.model.admin.User;
import travel.manager.model.home.*;
import travel.manager.service.admin.UserService;
import travel.manager.service.home.*;

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
    private PlaceService placeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryTourService categoryTourService;

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

            List<Tour> tours = tourService.getAll();
            if(!tours.isEmpty()) {
                result.setTours(tours);
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

            result.setMsg("Tour Data");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = { "/tours/{id}" }, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getTourDetails(@PathVariable("id") long id) {
        TourResponeBody result = new TourResponeBody();
        try {
            List<Image>imagesTours = imageService.findImageByTourId(id);
            result.setImagesTours(imagesTours);

            Tour tour = tourService.findOne(id);
            result.setTour(tour);

            Place place = placeService.getPlaceById(tour.getPlaceId());
            result.setPlace(place);

            List<Comment>comments = commentService.getComments(Integer.parseInt(String.valueOf(id)));
            result.setComments(comments);

            result.setMsg("Tour detail data");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = { "/tours/cate"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCateTours() {
        TourResponeBody result = new TourResponeBody();

        List<CategoryTours>categoryTours =categoryTourService.getCateTours();
        result.setCategoryTours(categoryTours);

        result.setMsg("Cate Tours");
        result.setStatus(true);
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value = { "/image/{id}" }, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getImage(@PathVariable("id") int id) {
        TourResponeBody result = new TourResponeBody();
        try {
            Image image = imageService.getImage(id);
            result.setImage(image);

            result.setMsg("Image");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = { "/tour/cart/{string}" }, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getDataCart(@PathVariable("string") String string) {
        TourResponeBody result = new TourResponeBody();
        try {
            List<Tour> tours = tourService.getListTours(string);
            result.setToursCart(tours);
            result.setMsg("Image");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }
}

