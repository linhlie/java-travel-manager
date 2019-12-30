package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.home.CategoryTours;
import travel.manager.repository.home.CategoryTourRepository;

import java.util.List;

@Service
public class CategoryTourService {
    @Autowired
    private CategoryTourRepository categoryTourRepository;
    public List<CategoryTours> getCateTours() {
        return categoryTourRepository.findAll();
    }
}
