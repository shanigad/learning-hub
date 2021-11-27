package shani.gad.learninghub.LearningPath;

import java.util.Collection;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shani.gad.learninghub.Topic.Topic;
import shani.gad.learninghub.Topic.TopicService;
import shani.gad.learninghub.User.User;
import shani.gad.learninghub.User.UserService;

@RestController
public class LearningPathController {

  @Autowired
  private LearningPathsService learningPathsService;

  @Autowired
  private UserService userService;

  @Autowired
  private TopicService topicService;

  @PostMapping("/path/{username}")
  public String createLearningPath(@RequestBody LearningPath newLearningPath,
                                   @PathVariable String username){
    User user = userService.getRegisteredUser(username);
    learningPathsService.createLearningPath(user, newLearningPath);
    userService.updateUser(user);
    return "Success";
  }

  @PutMapping("/topic/{username}/{path}/{topicName}")
  public String addTopic(@PathVariable String path,
                         @PathVariable String username,
                         @PathVariable String topicName){
    User user = userService.getRegisteredUser(username);
    Topic topic = topicService.getTopic(topicName);
    userService.updateUser(learningPathsService.addTopic(user, user.getLearningPath(path), topic));
    return "Success";
  }

  @GetMapping("/paths/{username}")
  public Collection<LearningPath> getLearningPaths(@PathVariable String username){
    return userService.getRegisteredUser(username).getLearningPaths().values();
  }

  @GetMapping("/topic/paths/{username}/{topic}")
  public Stream<LearningPath> getPathByTopic(@PathVariable String topic,
                                             @PathVariable String username){
   User user = userService.getRegisteredUser(username);
   return learningPathsService.getPathsByTopic(topic, user.getLearningPaths());
  }
}
