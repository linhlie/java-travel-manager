package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import travel.manager.model.home.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query(value = "SELECT comment.comment_id,content,user_id,create_at FROM tour_manager.comment, tour_comment where tour_comment.comment_id = comment.comment_id  and tour_comment.tour_id=:tourId", nativeQuery = true)
    List<Comment> findCommentsTours(@Param("tourId") int tourId);

    @Query(value = "SELECT comment.comment_id,content,user_id,create_at FROM tour_manager.comment, \n" +
            "place_comment where place_comment.comment_id = comment.comment_id  and place_comment.place_id=:placeId", nativeQuery = true)
    List<Comment> findCommentsPlace(@Param("placeId") int placeId);

    @Query(value = "SELECT comment.comment_id,content,user_id,create_at FROM tour_manager.comment,news_comment where news_comment.comment_id = comment.comment_id  and news_comment.news_id=:newsId", nativeQuery = true)
    List<Comment> findCommentsNews(@Param("newsId") int newsId);
}
