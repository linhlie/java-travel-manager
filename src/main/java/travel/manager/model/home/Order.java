package travel.manager.model.home;

import lombok.Data;
import travel.manager.model.admin.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

}
