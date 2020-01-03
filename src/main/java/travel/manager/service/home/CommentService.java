package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.home.Comment;
import travel.manager.model.home.TourComment;
import travel.manager.repository.home.CommentRepository;
import travel.manager.repository.home.TourCommentRepository;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TourCommentRepository tourCommentRepository;

    public List<Comment> getComments(int id) {
        return commentRepository.findCommentsTours(id);
    }

    public List<Comment> getCommentsPlace(int id) {
        return commentRepository.findCommentsPlace(id);
    }

    public List<Comment> getCommentsNews(int news_id) {
        return commentRepository.findCommentsNews(news_id);
    }

    public boolean createdComment(int id, String string) {
        String[] ct = string.split(",");
        Comment comment = new Comment();
        comment.setUserId(id);
        comment.setContent(ct[0]);
        commentRepository.save(comment);
        if (comment!=null){
            int ids = tourCommentRepository.finTourIdMax();
            Comment comment1 = commentRepository.getOne(ids);

            TourComment tourComment =  new TourComment();
            tourComment.setComment_id(comment1.getCommentId());
            tourComment.setTour_id(Integer.parseInt(ct[1]));
            tourCommentRepository.save(tourComment);

            return true;
        }
        else return false;
    }
}
