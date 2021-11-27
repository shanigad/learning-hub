package shani.gad.learninghub.Topic;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Topic {

  String name;
  String description;
  String url;
  int rate;
  ArrayList<String> Ratings;

  public Topic(String name, String description, String url){
    this.name = name;
    this.description = description;
    this.url = url;
    rate = 0;
    Ratings = new ArrayList<>();
  }


}
