package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.Image;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {

    @Query(value = "select * from tour_manager.tour_image,tour_manager.image where tour_image.image_id = image.image_id", nativeQuery = true)
    List<Image> findByTourId();

    @Query(value = "select * from tour_manager.place,tour_manager.image where place.image_id = image.image_id", nativeQuery = true)
    List<Image> findByPlaces();
}
