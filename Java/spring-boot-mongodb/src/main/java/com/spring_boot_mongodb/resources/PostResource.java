package com.spring_boot_mongodb.resources;

import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_mongodb.domain.Post;
import com.spring_boot_mongodb.resources.util.URL;
import com.spring_boot_mongodb.services.PostService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }
    
    @RequestMapping(value="/titlesearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) throws UnsupportedEncodingException {
        text = URL.decodeParam(text);
        List<Post> posts = service.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
    
    @RequestMapping(value="/fullsearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
        @RequestParam(value="text", defaultValue="") String text,
        @RequestParam(value="minDate", defaultValue="") String minDate,
        @RequestParam(value="maxDate", defaultValue="") String maxDate
        ) throws UnsupportedEncodingException {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0)); 
        Date max = URL.convertDate(maxDate, new Date()); 
        List<Post> posts = service.fullSearch(text,min, max);
        return ResponseEntity.ok().body(posts);
    }
}
