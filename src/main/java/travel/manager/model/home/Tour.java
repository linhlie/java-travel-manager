package travel.manager.model.home;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tour_id", nullable = false)
    private Long tour_id;

    @Column(name = "category_tour_id")
    private int category_tour_id;

    @Column(name = "place_id")
    private int place_id;

    @Column(name = "comment_id")
    private int comment_id;

    private String tour_name;

    private String tour_summary;

    private String tour_content;

    private String departure_date;

    private int total_member;

    private float price;

    private float discount;

    private int image_id;

}
