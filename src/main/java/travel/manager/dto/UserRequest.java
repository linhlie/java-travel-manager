package travel.manager.dto;

import lombok.Data;

@Data
public class UserRequest {
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String birthday;
}
