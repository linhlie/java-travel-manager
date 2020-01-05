package travel.manager.model.home;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category_news")
public class CategoryNews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_news_id")
    private Integer category_news_id;
    private String category_news_name;
}
