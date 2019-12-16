package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.Tour;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Integer> {

    @Query(value = "select * from tour_manager.tour", nativeQuery = true)
    List<Tour> findAlls();

    @Query(value = "select * from tour_manager.tour where tour_id = ?", nativeQuery = true)
    Tour findTourById(long id);

}
