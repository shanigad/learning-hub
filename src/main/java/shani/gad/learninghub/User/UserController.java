package shani.gad.learninghub.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public String registerUser(@RequestBody User user){
    userService.addUser(user);
    return "You registered successfully";
  }

  @PostMapping("/login")
  public String loginUser(@RequestBody User user){
    return "Hi " + userService.getUser(user.getUsername(), user.getPassword());
  }
}
