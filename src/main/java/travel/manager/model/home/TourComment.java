package travel.manager.model.home;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tour_comment")
public class TourComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "tour_id")
    private int tour_id;

    @Column(name = "comment_id")
    private int comment_id;
}
