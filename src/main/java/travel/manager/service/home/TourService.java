package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.home.Tour;
import travel.manager.repository.home.TourRepository;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAll(){
        return tourRepository.findAlls();
    }

    public Tour findOne(long id) {
        return tourRepository.findTourById(id);
    }

    public List<Tour> getToursVN() {
        return tourRepository.findAllToursVN();
    }

    public List<Tour> getToursNA() {
        return tourRepository.findAllToursNA();
    }

    public List<Tour> getTourByPlace(int id) {
        return tourRepository.findTourByIdPlace(id);
    }
}
