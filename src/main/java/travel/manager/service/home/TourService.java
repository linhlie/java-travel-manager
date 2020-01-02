package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.home.Tour;
import travel.manager.repository.home.TourRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAll(){
        return tourRepository.findAlls();
    }

    public Tour findOne(Long id) {
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

    public List<Tour> getListTours(String string) {
        String[] arrTour = string.split(",");
        List<Tour>tours = new ArrayList<>();
        for (int i = 0; i < arrTour.length; i++) {
            Tour tour = tourRepository.findTourById(Long.parseLong(arrTour[i]));
            tours.add(tour);
        }
        return tours;
    }

    public void save(Tour tour) {
        tourRepository.save(tour);
    }
    public void delete(Long id){
        tourRepository.deleteById(id);
    }
}
