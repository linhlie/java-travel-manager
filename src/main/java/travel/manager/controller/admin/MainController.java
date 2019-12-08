package travel.manager.controller.admin;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import travel.manager.message.AjaxResponseBody;
import travel.manager.model.admin.RegisterUser;
import travel.manager.model.admin.User;
import travel.manager.repository.admin.UserRepository;
import travel.manager.service.admin.SecurityServiceImpl;
import travel.manager.service.admin.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class MainController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityServiceImpl securityService;
	
	@GetMapping(value = {"/admin","/admin/"})
	public String admin() {
		return "admin";
	}

	@GetMapping("/admin/users")
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String getUsers() {
		return "/users";
	}
	
	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("registerUser", new RegisterUser());
		return "register";
	}

	@RequestMapping(value = { "/index/users"}, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAccountLogin(Principal principal) {
		travel.manager.message.AjaxResponseBody result = new AjaxResponseBody();
		try {
			org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

			result.setJsonUser(userRepository.findByEmail(loginedUser.getUsername()).toString());

			System.out.println(result.getJsonUser());
			result.setMsg("done");
			result.setStatus(true);

		}catch (Exception e){
			System.out.println("fail");
			result.setMsg(e.getMessage());
			result.setStatus(false);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/register")
	public String register(@Valid RegisterUser registerUser, Model model) {
		System.out.println(registerUser.getEmail());
		return "redirect:/login";
	}

}
