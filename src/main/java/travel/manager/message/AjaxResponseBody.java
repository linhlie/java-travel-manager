package travel.manager.message;

import lombok.Data;
import travel.manager.model.admin.User;
import travel.manager.model.admin.UserDto;
import travel.manager.model.home.Image;
import travel.manager.model.home.News;
import travel.manager.model.home.Place;
import travel.manager.model.home.Tour;

import java.util.List;

@Data
public class AjaxResponseBody {

    String msg;
    List<Tour> result;
    private List list;
    private boolean status;
    private User user;
    private long userId;
    private UserDto userDto;
    private String jsonUser;
    private List<Image>images;
    private List<Image>imagesTours;
    private List<Image>imagesPlaces;
    private List<Image>imagesUsers;
    private List<Place>places;
    private List<News>news;





    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Tour> getResult() {
        return result;
    }

    public void setResult(List<Tour> result) {
        this.result = result;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public String getJsonUser() {
        return jsonUser;
    }

    public void setJsonUser(String jsonUser) {
        this.jsonUser = jsonUser;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
