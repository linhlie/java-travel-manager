package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.home.News;
import travel.manager.service.home.NewsService;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/news/list")
    public ResponseEntity<?> getNews(){
        AjaxResponseBody result = new AjaxResponseBody();
        List<News>news= newsService.getAll();
        result.setNews(news);

        result.setMsg("Ok!");
        result.setStatus(true);
        return ResponseEntity.ok(result);
    }

}
