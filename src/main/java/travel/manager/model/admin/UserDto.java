package travel.manager.model.admin;

import lombok.Data;

@Data
public class UserDto {

    private int id;

    private String email;

    private String phone;

    private String fullName;

    private String createdAt;

    private String birthday;

    private Long imageId;

    public UserDto(int id, String email, String phone, String fullName, String createdAt, String birthday, Long imageId) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
        this.createdAt = createdAt;
        this.birthday = birthday;
        this.imageId = imageId;
    }
    public UserDto(int id, String email, String phone, String fullName) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
    }
}
