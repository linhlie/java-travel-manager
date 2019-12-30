package travel.manager.model.home;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "news_image")
public class NewsImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int news_id;
    private int image_id;
    @OneToMany
    private List<Image> image;
}
