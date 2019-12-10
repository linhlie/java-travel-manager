package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.home.Image;
import travel.manager.repository.home.ImageRepository;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAll(){
        return imageRepository.findAll();
    }
    public List<Image> getToursImages(){
        return imageRepository.findByTourId();
    }
    public List<Image> getPlaceImages(){
        return imageRepository.findByPlaces();
    }
}
