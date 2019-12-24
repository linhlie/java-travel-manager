package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {

    @Query(value = "select * from tour_manager.place where place_id = ?", nativeQuery = true)
    Place findPlaceById(int id);
}
