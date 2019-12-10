package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.admin.User;
import travel.manager.model.home.Tour;
import travel.manager.repository.home.TourRepository;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;
    public List<Tour> getAll(){
        return tourRepository.findAll();
    }

}
