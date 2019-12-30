package travel.manager.model.home;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orders_id")
    private int ordersId;

    private int userId;

    private Date ordersDate;

    private boolean isPaid;

    private long tourId;

    private int totalPeople;
}
