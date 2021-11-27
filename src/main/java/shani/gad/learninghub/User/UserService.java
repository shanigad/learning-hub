package shani.gad.learninghub.User;

import java.util.Collection;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private HashMap<String, User> registeredUsers = new HashMap<>();

  public void addUser(User user){
    if(!registeredUsers.containsKey(user.getUsername())){
        registeredUsers.put(user.getUsername(), user);
    }
  }

  public String getUser(String username, String password){
    if(registeredUsers.containsKey(username)
        && registeredUsers.get(username).getPassword().equals(password)){
        return username;
    }
    return "Sorry we can't find your username or password, please register before login";
  }

  public User getRegisteredUser(String username){
    return registeredUsers.get(username);
  }

  public void updateUser(User user){
    if(registeredUsers.containsKey(user.getUsername())){
      registeredUsers.put(user.getUsername(), user);
    }
  }
}
