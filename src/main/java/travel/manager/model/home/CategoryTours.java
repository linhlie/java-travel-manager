package travel.manager.model.home;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category_tour")
public class CategoryTours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_tour_id")
    private Long category_tour_id;
    private String category_tour_name;
    private String category_tour_url;

}
