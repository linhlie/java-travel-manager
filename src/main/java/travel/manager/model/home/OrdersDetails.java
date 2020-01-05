package travel.manager.model.home;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders_details")
public class OrdersDetails {
    @Id
    @Column(name = "orders_id")
    private int orders_id;
    @Column(name = "tour_id")
    private int tour_id;
    @Column(name = "total_price")
    private float total_price;
    @Column(name = "total_user")
    private int total_user;
}
