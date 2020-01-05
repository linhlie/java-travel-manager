package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.News;
import travel.manager.repository.home.NewsRepository;

import java.util.List;

@Repository
public class NewsService{
    @Autowired
    private NewsRepository newsRepository;
    public List<News>getAll(){
        return newsRepository.findAll();
    }
    public News getNewsById(Integer id) {
        return newsRepository.getNewsById(id);
    }

    public void save(News news){
        newsRepository.save(news);
    }
    public void deleteNews(Integer id){
        newsRepository.deleteById(id);
    }
}
