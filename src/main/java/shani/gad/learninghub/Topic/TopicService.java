package shani.gad.learninghub.Topic;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

  HashMap<String, Topic> topics = new HashMap<>();

  public Topic getTopic(String topicName){
    return topics.get(topicName);
  }

  public void addTopic(Topic topic){
    topics.put(topic.name, topic);
  }

  public String rate(String topicName, int newRate ,String username) {
    if(!topics.containsKey(topicName)){
      return topicName + " not found";
    }
    Topic topic = topics.get(topicName);
    if (topic.Ratings.contains(username)) {
      return "You can't rate a topic more than once";
    }

    topic.rate = ((topic.rate*topic.Ratings.size()) + newRate) / (topic.Ratings.size()+1);
    topic.Ratings.add(username);
    return "Success";
  }
}
