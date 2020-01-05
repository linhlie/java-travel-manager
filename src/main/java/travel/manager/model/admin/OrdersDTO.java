package travel.manager.model.admin;

import lombok.Data;

@Data
public class OrdersDTO {
    private int orders_id;
    private String full_name;
    private String email;
    private boolean is_paid;
    private String orders_date;

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_paid() {
        return is_paid;
    }

    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    public String getOrders_date() {
        return orders_date;
    }

    public void setOrders_date(String orders_date) {
        this.orders_date = orders_date;
    }
}
