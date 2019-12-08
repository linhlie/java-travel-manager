package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.Tour;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {
    List<Tour>findAll();
}
