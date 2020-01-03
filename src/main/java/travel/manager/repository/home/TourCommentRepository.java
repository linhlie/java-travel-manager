package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import travel.manager.model.home.Image;
import travel.manager.model.home.TourComment;

import java.util.List;

public interface TourCommentRepository extends JpaRepository<TourComment,Integer> {
    @Query(value = "SELECT MAX(comment_id) FROM tour_manager.comment", nativeQuery = true)
    int finTourIdMax();

}
