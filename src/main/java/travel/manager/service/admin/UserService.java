package travel.manager.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import travel.manager.dto.UserDtoComment;
import travel.manager.dto.UserRequest;
import travel.manager.model.admin.RegisterUser;
import travel.manager.model.admin.Role;
import travel.manager.model.admin.User;
import travel.manager.model.admin.UserDto;
import travel.manager.repository.admin.RoleRepository;
import travel.manager.repository.admin.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;



    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @PreAuthorize(value = "hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
    public List<Object> getListUsers() {
        return userRepository.findAll().stream().map(u -> {
            return new UserDto( u.getId(),  u.getEmail(),  u.getPhone(),u.getFullName(), u.getCreatedAt(), u.getBirthday(), u.getImageId());
        }).collect(Collectors.toList());
    }

    public List<UserDtoComment> getUsersComment() {
        return userRepository.findAll().stream().map(u ->{
            return new UserDtoComment(u.getId(),u.getFullName(),u.getImageId());
        }).collect(Collectors.toList());
    }

    public List<UserDtoComment> getUserNews() {
        return userRepository.findAll().stream().map(u ->{
            return new UserDtoComment(u.getId(),u.getFullName(),u.getImageId());
        }).collect(Collectors.toList());
    }

    public User getUserById(int id) {
        return userRepository.findByIdUsers(id);
    }

    public boolean updateUser(UserRequest userRequest) {
        System.out.println(userRequest);
        try {
            User user = userRepository.findByIdUsers(userRequest.getId());
            User user1 = new User(userRequest.getId(),userRequest.getEmail(),user.getPassword(),
                    userRequest.getPhone(),userRequest.getFullName(),userRequest.getBirthday(),user.getImageId(),user.getRoles());
            System.out.println(user1);
            userRepository.save(user1);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean addUser(RegisterUser registerUser) {
        try {
            if (registerUser.getPassword().equals(registerUser.getConfirmPassword())){
                if (userRepository.findByEmail(registerUser.getEmail()) == null) {
                    User user = new User();
                    user.setEmail(registerUser.getEmail());
                    user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
                    user.setPhone(registerUser.getPhone());
                    user.setFullName(registerUser.getFullName());
                    user.setBirthday(registerUser.getBirthday());
                    user.setImageId((long) 44);
                    HashSet<Role> roles = new HashSet<>();
                    roles.add(roleRepository.findByName("ROLE_MEMBER"));
                    user.setRoles(roles);
                    System.out.println(user);

                    userRepository.save(user);
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
