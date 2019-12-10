package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.News;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
}
