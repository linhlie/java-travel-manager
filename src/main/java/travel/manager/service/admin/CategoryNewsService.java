package travel.manager.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.home.CategoryNews;
import travel.manager.repository.admin.CategoryNewsRepository;

import java.util.List;

@Service
public class CategoryNewsService {
    @Autowired
    private CategoryNewsRepository categoryNewsRepository;
    public List<CategoryNews> getCateNews(){ return categoryNewsRepository.findAll();}
}
