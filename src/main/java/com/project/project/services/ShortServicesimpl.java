package com.project.project.services;

import com.project.project.classes.Url;
import com.project.project.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortServicesimpl implements ShortServices {
  @Autowired private UrlRepository urlrepository;

  @Override
  public Url checkByString(String url) {
    return urlrepository.findByUrlString(url);
  }

  @Override
  public Url checkById(long id) {
    return urlrepository.findById(id);
  }

  @Override
  public String shortenUrl(long id) {
    String keyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char keyArray[] = keyString.toCharArray();
    StringBuffer shortUrlRev = new StringBuffer();

    while (id > 0) {
      shortUrlRev.append(keyArray[(int) (id % 62)]);
      id = id / 62;
    }
    return shortUrlRev.reverse().toString();
  }

  @Override
  public long maxId() {
    return urlrepository.findAll().size() + 1;
  }

  @Override
  public long getId(String shortUrl) {
    long id = 0;
    for (int i = 0; i < shortUrl.length(); i++) {
      id = id * 62;
      char currentChar = shortUrl.charAt(i);
      if (currentChar >= 'a' && currentChar <= 'z') {
        id = id + currentChar - 'a';
      } else if (currentChar >= 'A' && currentChar <= 'Z') {
        id = id + currentChar - 'A' + 26;
      } else {
        id = id + currentChar - '0' + 52;
      }
    }
    return id;
  }
}
