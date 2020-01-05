package travel.manager.dto;

import lombok.Data;

@Data
public class OrderDetailBillDTO {

    private int orders_id;
    private int tour_id;
    private float total_price;
    private int total_user;
    private String nameTour;
    private String date;
    private float discount;
}
