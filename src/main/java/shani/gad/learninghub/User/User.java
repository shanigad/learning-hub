package shani.gad.learninghub.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import lombok.Data;
import shani.gad.learninghub.LearningPath.LearningPath;

@Data
public class User {

  private String username;
  private String password;
  private HashMap<String, LearningPath> learningPaths;

  public User( String username, String password){
    this.username = username;
    this.password = password;
    learningPaths = new HashMap<>();
  }


  public LearningPath getLearningPath(String learningPath)
  {
    return learningPaths.get(learningPath);
  }

  public void updatePath(LearningPath path){
    HashMap<String, LearningPath> paths = this.getLearningPaths();
    paths.put(path.getName(), path);
    this.setLearningPaths(paths);
  }
}
