package shani.gad.learninghub.LearningPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import shani.gad.learninghub.Topic.Topic;
import shani.gad.learninghub.User.User;

@Service
public class LearningPathsService {

  public User createLearningPath(User user, LearningPath path){
   user.updatePath(path);
   return user;
  }

  public User addTopic(User user, LearningPath learningPath, Topic topic){
    ArrayList<Topic> topics = learningPath.getTopics();
    topics.add(topic);
    learningPath.setTopics(topics);
    user.updatePath(learningPath);
    return user;
  }

  public Stream<LearningPath> getPathsByTopic(String topic, HashMap<String, LearningPath> learningPaths) {
   return learningPaths.values().stream()
       .filter(lp -> isContainTopic(lp, topic));
  }

  private boolean isContainTopic(LearningPath learningPath, String topic){
    return learningPath.topics.stream().anyMatch(t -> t.getName().equals(topic));
  }
}
