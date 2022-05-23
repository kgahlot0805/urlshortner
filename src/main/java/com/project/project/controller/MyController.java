package com.project.project.controller;

import com.project.project.classes.Url;
import com.project.project.repository.UrlRepository;
import com.project.project.services.ShortServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;


@RestController
public class MyController {

    @Autowired
    private ShortServices shortServices;

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping("/")
    public String home(){
        return "To shorten a url, visit /shorten/{url}\nTo recover original url, visit /recover/{url}";
    }

    //Controller handling shortening of URLs
    @RequestMapping("/shorten/**")
    public String shorten(HttpServletRequest request) {
        String fullUrl = request.getRequestURL().toString();
        String url = (fullUrl.split("/shorten/"))[1];

        //Checking for valid url
        URL validURL = null;
        URI validURI = null;
        try {
            validURL = new URL(url);
            validURI = validURL.toURI();
            System.out.println(validURI);
        }
        catch(Exception e) {
            System.out.println(e);
            return "Invalid URL";
        }

        Url checkUrl = shortServices.checkByString(url);
        if(ObjectUtils.isEmpty(checkUrl)){
            Url newUrl = new Url();
            newUrl.setUrlString(url);
            newUrl.setId((int) shortServices.maxId());
            urlRepository.save(newUrl);
            return shortServices.shortenUrl(newUrl.getId());
        }
        return shortServices.shortenUrl(checkUrl.getId());
    }

    //Controller for converting short URLs back to originals
    @GetMapping("/recover/{shortUrl}")
    public String recover(@PathVariable String shortUrl){
        long id= shortServices.getId(shortUrl);
        Url checkUrl = shortServices.checkById(id);
        if(ObjectUtils.isEmpty(checkUrl)){
            return "Not Found in the database";
        }
        return checkUrl.getUrlString();
    }


}
