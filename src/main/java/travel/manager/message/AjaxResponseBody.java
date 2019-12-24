package travel.manager.message;

import lombok.Data;
import travel.manager.dto.ImageNewsDto;
import travel.manager.dto.UserDtoComment;
import travel.manager.model.admin.User;
import travel.manager.model.admin.UserDto;
import travel.manager.model.home.*;

import java.util.List;

@Data
public class AjaxResponseBody {

    String msg;
    private List<Tour> tours;
    private List list;
    private boolean status;
    private User user;
    private List<UserDtoComment>listUsers;
    private long userId;
    private UserDto userDto;
    private String jsonUser;
    private List<Image>images;
    private List<Image>imagesTours;
    private List<Image>imagesPlaces;
    private List<Image>imagesUsers;
    private List<Place>places;
    private List<News>news;
    private List<Object>imagesNews;
    private List<ImageNewsDto>_imagesNews;
    private List<NewsImage>newsImages;
    private Tour tour;
    private List<Image>imagesUserComments;
    private List<Comment>comments;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public List<UserDtoComment> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<UserDtoComment> listUsers) {
        this.listUsers = listUsers;
    }

}
