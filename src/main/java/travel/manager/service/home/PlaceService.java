package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.home.Place;
import travel.manager.repository.home.PlaceRepository;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    PlaceRepository placeRepository;
    public List<Place> getAll() {
        return placeRepository.findAll();
    }
}
