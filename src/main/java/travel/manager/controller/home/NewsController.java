package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travel.manager.dto.ImageNewsDto;
import travel.manager.dto.UserDtoComment;
import travel.manager.message.AjaxResponseBody;
import travel.manager.message.TourResponeBody;
import travel.manager.model.home.*;
import travel.manager.service.admin.UserService;
import travel.manager.service.home.CommentService;
import travel.manager.service.home.ImageService;
import travel.manager.service.home.NewsService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/news/list")
    public ResponseEntity<?> getNews(){
        AjaxResponseBody result = new AjaxResponseBody();
        List<News>news= newsService.getAll();
        result.setNews(news);

        List<ImageNewsDto>images = imageService.getNewImages();
        result.set_imagesNews(images);

        List<UserDtoComment> users= userService.getUserNews();
        result.setListUsers(users);

        List<Comment>comments =new ArrayList<>();

        for (int i=0;i<news.size();i++){
            List<Comment>commentss = commentService.getCommentsNews(news.get(i).getNews_id());
            comments.addAll(commentss);
        }
        result.setComments(comments);

        result.setMsg("data news");
        result.setStatus(true);
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value = { "/news/{id}" }, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getNewsDetails(@PathVariable("id") int id) {
        TourResponeBody result = new TourResponeBody();
        try {
            News news = newsService.getNews(id);
            result.setNews(news);

            List<Image>imagesPlaces = imageService.getImageNews(id);
            result.setImagesNews(imagesPlaces);

            List<Comment>comments = commentService.getCommentsNews(id);
            result.setComments(comments);

            result.setMsg("News detail data");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }

}
