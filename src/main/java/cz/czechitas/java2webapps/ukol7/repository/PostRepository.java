package cz.czechitas.java2webapps.ukol7.repository;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostBySlug(String slug);

    Page<Post> findByPublishedBeforeOrderByPublishedDesc(Date publishedBefore, Pageable pageable);

    //  Page<Post> findAll(Pageable pageable);

}
