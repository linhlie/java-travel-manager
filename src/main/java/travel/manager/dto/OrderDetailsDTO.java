package travel.manager.dto;

public class OrderDetailsDTO {
    private int orders_id;
    private String full_name;
    private String email;
    private String phone;
    private float total_price;
    private int total_user;
    private String tour_name;
    private String departure_date;
    private int total_days;
    private String orders_date;

    public int getOrders_id() {
        return orders_id;
    }

    public float getTotal_price() {
        return total_price;
    }

    public int getTotal_user() {
        return total_user;
    }

    public String getTour_name() {
        return tour_name;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public int getTotal_days() {
        return total_days;
    }

    public String getOrders_date() {
        return orders_date;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public void setTotal_user(int total_user) {
        this.total_user = total_user;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public void setTotal_days(int total_days) {
        this.total_days = total_days;
    }

    public void setOrders_date(String orders_date) {
        this.orders_date = orders_date;
    }
}
