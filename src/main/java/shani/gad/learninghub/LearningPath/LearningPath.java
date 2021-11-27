package shani.gad.learninghub.LearningPath;

import java.util.ArrayList;
import lombok.Data;
import shani.gad.learninghub.Topic.Topic;

@Data
public class LearningPath {

  String name;
  String description;
  ArrayList<Topic> topics;

  public LearningPath(String name, String description){
    this.name = name;
    this.description= description;
    topics = new ArrayList<>();
  }

}
