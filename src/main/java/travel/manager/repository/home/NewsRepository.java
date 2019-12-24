package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.News;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
    @Query(value = "select * from tour_manager.news where news_id = ?", nativeQuery = true)
    News getNews(int id);
}
