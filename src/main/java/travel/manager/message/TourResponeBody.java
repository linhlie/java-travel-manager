package travel.manager.message;

import lombok.Data;
import travel.manager.model.home.Tour;

@Data
public class TourResponeBody {
    private boolean status;
    String msg;
    private Tour tour;
}
