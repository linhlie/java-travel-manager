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
    private Long tourId;

    @Column(name = "category_tour_id")
    private int categoryTourId;

    @Column(name = "place_id")
    private int placeId;

    @Column(name = "comment_id")
    private int commentId;

    private String tourName;

    private String tourSummary;

    private String tourContent;

    private String departureDate;

    private int totalMember;

    private float price;

    private float discount;

    private int totalDays;

}
