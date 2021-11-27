package shani.gad.learninghub.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shani.gad.learninghub.User.User;

@RestController
public class TopicController {

  @Autowired
  TopicService topicService;

  @PutMapping("/rate/{username}/{topic}/{score}")
  public String registerUser(@PathVariable String topic,
                             @PathVariable int score,
                             @PathVariable String username){
    return topicService.rate(topic, score, username);
  }

  @PostMapping("/topic")
  public String registerUser(@RequestBody Topic topic){
    topicService.addTopic(topic);
    return "Success";
  }
}
