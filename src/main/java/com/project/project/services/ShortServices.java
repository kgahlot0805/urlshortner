package com.project.project.services;

import com.project.project.classes.Url;

public interface ShortServices {

    //Search database for given url
    public Url checkByString(String url);

    //Search database for given id
    public Url checkById(long id);

    //Given an id, convert it into short URL
    public String shortenUrl(long id);

    //Return the maximum id in the table
    public long maxId();

    //convert given short url back to id
    public long getId(String shortUrl);
}
