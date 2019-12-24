package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travel.manager.message.AjaxResponseBody;
import travel.manager.message.TourResponeBody;
import travel.manager.model.home.*;
import travel.manager.service.home.CommentService;
import travel.manager.service.home.ImageService;
import travel.manager.service.home.PlaceService;
import travel.manager.service.home.TourService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TourService tourService;

    @RequestMapping(value = { "/places"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?>getDataPlaces(){
        AjaxResponseBody result = new AjaxResponseBody();

        List<Place> places = placeService.getAll();

        List<Image>images = imageService.getPlaceImages();

        if (!places.isEmpty()&&!images.isEmpty()){
            result.setPlaces(places);
            result.setImagesPlaces(images);

            result.setStatus(true);
            result.setMsg("Data places!");
        }
        else {
            result.setStatus(false);
            result.setMsg("Load data places fail!");
        }

        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = { "/place/{id}" }, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getTourDetails(@PathVariable("id") int id) {
        TourResponeBody result = new TourResponeBody();
        try {
            Place place = placeService.getPlaceById(id);
            result.setPlace(place);

            List<Image>imagesPlaces = imageService.getImagePlace(id);
            result.setImagesPlace(imagesPlaces);

            List<Comment>comments = commentService.getCommentsPlace(id);
            result.setComments(comments);

            List<Tour>tours = tourService.getTourByPlace(id);
            result.setListTourPlace(tours);

            List<Image> imagesTour = new ArrayList<>();
            for (int i=0;i<tours.size();i++){
                List<Image>images = imageService.findImageByTourId(tours.get(i).getTourId());
                imagesTour.addAll(images);
            }
            result.setImagesTours(imagesTour);

            result.setMsg("Place detail data");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }

}
