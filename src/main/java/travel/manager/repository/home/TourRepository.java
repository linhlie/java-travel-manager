package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.Tour;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

    @Query(value = "select * from tour_manager.tour", nativeQuery = true)
    List<Tour> findAlls();

    @Query(value = "select * from tour_manager.tour where tour_id = ?", nativeQuery = true)
    Tour findTourById(Long id);

    @Query(value = "SELECT * FROM tour_manager.tour where country =1", nativeQuery = true)
    List<Tour> findAllToursVN();

    @Query(value = "SELECT * FROM tour_manager.tour where country =2", nativeQuery = true)
    List<Tour> findAllToursNA();

    @Query(value = "SELECT * FROM tour_manager.tour where place_id=:idPlace", nativeQuery = true)
    List<Tour> findTourByIdPlace(@Param("idPlace") int idPlace);
}
