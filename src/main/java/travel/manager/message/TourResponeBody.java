package travel.manager.message;

import lombok.Data;
import travel.manager.model.home.*;

import java.util.List;

@Data
public class TourResponeBody {
    private boolean status;
    String msg;
    private Tour tour;
    private List<Image> imagesTours;
    private List<Image> imagesPlace;
    private List<Comment>comments;
    private List<CategoryTours>categoryTours;
    private Place place;
    private List<Tour>listTourPlace;
    private List<Image>imagesNews;
    private News news;
    private Image image;
    private List<Tour>toursCart;
    private String cus;
}
