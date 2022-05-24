package com.project.project.classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shorturl")
public class Url {
  private String urlString;
  @Id private Integer id;

  public Url() {}

  public String getUrlString() {
    return urlString;
  }

  public void setUrlString(String urlString) {
    this.urlString = urlString;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
