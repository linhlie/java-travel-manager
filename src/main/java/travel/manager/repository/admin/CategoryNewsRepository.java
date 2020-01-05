package travel.manager.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import travel.manager.model.home.CategoryNews;

public interface CategoryNewsRepository extends JpaRepository<CategoryNews,Integer> {

}
