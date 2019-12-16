package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import travel.manager.dto.ImageNewsDto;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.home.Image;
import travel.manager.model.home.News;
import travel.manager.service.home.ImageService;
import travel.manager.service.home.NewsService;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private ImageService imageService;

      @GetMapping(value = "/news/list")
    public ResponseEntity<?> getNews(){
        AjaxResponseBody result = new AjaxResponseBody();
        List<News>news= newsService.getAll();
        result.setNews(news);

        List<ImageNewsDto>images = imageService.getNewImages();
        result.set_imagesNews(images);

        result.setMsg("Ok!");
        result.setStatus(true);
        return ResponseEntity.ok(result);
    }

}
