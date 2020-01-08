package travel.manager.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import travel.manager.dto.UserDtoComment;
import travel.manager.dto.UserRequest;
import travel.manager.filestorage.FileStorage;
import travel.manager.filestorage.FileStorageImpl;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.admin.RegisterUser;
import travel.manager.model.admin.User;
import travel.manager.model.home.Image;
import travel.manager.repository.admin.UserRepository;
import travel.manager.repository.home.ImageRepository;
import travel.manager.service.admin.UserService;
import travel.manager.service.home.ImageService;

import javax.validation.Valid;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

@Controller
public class UsersControllers {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    FileStorageImpl fileStorage;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = { "/users/tourDetails" }, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getTourDetails() {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        List<UserDtoComment> users= userService.getUsersComment();
        responseBody.setListUsers(users);

        List<Image>images = imageService.getImageUserComments();
        responseBody.setImagesUserComments(images);

        responseBody.setMsg("UsersComments");
        responseBody.setStatus(true);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute UserRequest userRequest,Model model) {
        if (userService.updateUser(userRequest)){
            model.addAttribute("message", "Update user success!");
        }
        else {
            model.addAttribute("message", "Update user Fail!");
        }
        return "redirect:/profile";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterUser registerUser, Model model) {
        if(userService.addUser(registerUser)){
            System.out.println("OK");
        }
        return "redirect:/login";
    }
    @PostMapping("/user/uploadImage")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model, Principal principal) {
        try {
            String url = fileStorage.store(file);
            Image image = new Image();
            image.setImageName(file.getOriginalFilename());
            image.setImageUrl(url);
            imageRepository.save(image);

            org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
            int id = imageRepository.findImageIdMax();
            User user = userRepository.findByEmail(loginedUser.getUsername());
            user.setImageId(Long.parseLong(String.valueOf(id)));
            userRepository.save(user);


        } catch (Exception e) {
        }
        return "redirect:/profile";
    }

}
