package travel.manager.model.admin;

import lombok.Data;

@Data
public class RegisterUser {
    private String email;

    private String password;

    private String confirmPassword;

    private String phone;

    private String fullName;

    private String birthday;

}
