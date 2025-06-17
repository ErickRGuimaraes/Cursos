package com.spring_boot_mongodb.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_mongodb.domain.Post;
import com.spring_boot_mongodb.repository.PostRepository;
import com.spring_boot_mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post post = repo.findById(id)
    .orElseThrow(() -> new ObjectNotFoundException("Post not found with id: " + id));
        return post;
    }

    public List<Post> findByTitle(String title) {
        return repo.searchTitle(title);
        // Uncomment the line below if you want to use the method that finds posts by title containing
        //return repo.findByTitleContainingIgnoreCase(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // Adjust maxDate to include the whole day
        return repo.fullSearch(text, minDate, maxDate);
    }
}
