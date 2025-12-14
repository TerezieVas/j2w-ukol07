package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> list(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
    public Post singlePost (String slug) {
        return postRepository.findPostBySlug(slug);
    }
    public Optional<Post> sezenId (Long id) {
        return postRepository.findById(id);
    }

    public Page<Post> listDlePublished(Pageable pageable) {
        Date datum = new Date();
       return postRepository.findByPublishedBeforeOrderByPublishedDesc(datum,pageable);
    }
}
