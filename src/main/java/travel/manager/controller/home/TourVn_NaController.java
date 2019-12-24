package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import travel.manager.dto.ImageNewsDto;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.home.Image;
import travel.manager.model.home.News;
import travel.manager.model.home.Tour;
import travel.manager.service.home.ImageService;
import travel.manager.service.home.NewsService;
import travel.manager.service.home.TourService;

import java.util.List;

@Controller
public class TourVn_NaController {

    @Autowired
    private TourService tourService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = {"/tours/vi"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getListTourVN() {
        AjaxResponseBody result = new AjaxResponseBody();

        List<Tour>toursVN = tourService.getToursVN();

        List<Image>images =imageService.getToursImagesVN();

        if (!toursVN.isEmpty()&&!images.isEmpty()){

            result.setImagesTours(images);
            result.setTours(toursVN);

            result.setStatus(true);
            result.setMsg("TourVN");
        }
        else {
            result.setStatus(false);
            result.setMsg("load data fail!");
            }

        return ResponseEntity.ok(result);
    }
    @RequestMapping(value = {"/tours/na"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getListTourNA() {
        AjaxResponseBody result = new AjaxResponseBody();

        List<Tour>toursNA = tourService.getToursNA();

        List<Image>images =imageService.getToursImagesNA();

        if (!toursNA.isEmpty()&&!images.isEmpty()){

            result.setImagesTours(images);
            result.setTours(toursNA);

            result.setStatus(true);
            result.setMsg("TourNA");
        }
        else {
            result.setStatus(false);
            result.setMsg("load data fail!");
            }

        return ResponseEntity.ok(result);
    }
}
