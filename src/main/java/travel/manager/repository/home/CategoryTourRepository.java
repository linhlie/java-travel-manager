package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.CategoryTours;

@Repository
public interface CategoryTourRepository extends JpaRepository<CategoryTours,Integer> {

}
