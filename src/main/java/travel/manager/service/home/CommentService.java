package travel.manager.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.model.home.Comment;
import travel.manager.repository.home.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComments(int id) {
        return commentRepository.findCommentsTours(id);
    }

    public List<Comment> getCommentsPlace(int id) {
        return commentRepository.findCommentsPlace(id);
    }

    public List<Comment> getCommentsNews(int news_id) {
        return commentRepository.findCommentsNews(news_id);
    }
}
