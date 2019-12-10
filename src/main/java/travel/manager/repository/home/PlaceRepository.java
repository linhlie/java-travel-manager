package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {
}
