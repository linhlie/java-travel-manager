package travel.manager.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import travel.manager.model.admin.User;
import travel.manager.model.admin.UserDto;
import travel.manager.repository.admin.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @PreAuthorize(value = "hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
    public List<Object> getListUsers() {
        return userRepository.findAll().stream().map(u -> {
            return new UserDto( u.getId(),  u.getEmail(),  u.getPhone(),u.getFullName(), u.getCreatedAt(), u.getBirthday(), u.getImageId());
        }).collect(Collectors.toList());
    }
}
