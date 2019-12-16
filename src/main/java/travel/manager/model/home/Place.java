package travel.manager.model.home;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "place_id", nullable = false)
    private int placeId;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_summary")
    private String placeSummary;

}
