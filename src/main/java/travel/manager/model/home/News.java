package travel.manager.model.home;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "news_id")
    private int news_id;

    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "category_news_id")
    private int category_newsId;

    @Column(name = "news_summary")
    private String newsSummary;

    @Column(name = "news_content")
    private String newsContent;

    @Column(name = "create_at")
    private String createAt;

    @Column(name="create_by")
    private int createByl;

    @Column(name = "image_id")
    private int imageId;
}
