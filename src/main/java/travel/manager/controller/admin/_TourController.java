package travel.manager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.admin.User;
import travel.manager.model.home.Image;
import travel.manager.model.home.Place;
import travel.manager.model.home.Tour;
import travel.manager.service.home.TourService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class _TourController {
    @Autowired
    private TourService tourService;

    @RequestMapping(value = { "/tours"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getTours(Principal principal) {
        AjaxResponseBody result = new AjaxResponseBody();
        try {

            List<Tour> tours = tourService.getAll();
            if(!tours.isEmpty()) {
                result.setTours(tours);
            }
            result.setMsg("Tour Data");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }
}
