package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.dto.ImageNewsDto;
import travel.manager.model.home.Image;
import travel.manager.repository.home.ImageRepository;

import java.util.ArrayList;
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
    public List<ImageNewsDto> getNewImages(){
        List<Object[]> objects = imageRepository.findByNews();
        List<ImageNewsDto> imageNewsDtos = new ArrayList<ImageNewsDto>();
        for (Object[] obj : objects
        ){
            ImageNewsDto imageNewsDto = new ImageNewsDto();

            imageNewsDto.setNews_id(Integer.parseInt(String.valueOf(obj[0])));
            imageNewsDto.setImage_id(Integer.parseInt(String.valueOf(obj[1])));
            imageNewsDto.setImage_name(String.valueOf (obj[2]));
            imageNewsDto.setImage_url(String.valueOf(obj[3]));

            imageNewsDtos.add(imageNewsDto);
        }

        return imageNewsDtos;
    }
}
