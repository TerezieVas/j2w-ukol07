package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import cz.czechitas.java2webapps.ukol7.service.PostService;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Controller
public class PostController {
    private final PostService service;
    private final PostService postService;

    public PostController(PostService service, PostService postService) {
        this.service = service;
        this.postService = postService;
    }

    @GetMapping("/")
    public ModelAndView index(/*@PageableDefault(sort = {"published"}, size = 20) Pageable pageable*/) {
       Pageable pageable = PageRequest.of(0, 20);
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView
                .addObject("seznam", service.listDlePublished(pageable));
    }

    @GetMapping("post/{slug}")
    public Object detail(@PathVariable String slug) {
        slug = "/" + slug;
        Post post = postService.singlePost(slug);
        return new ModelAndView("detail")//detail je název celého souboru ftlh
                .addObject("clanek", post);//clanek je název POUZE objektu, který je v detail.ftlh


    }
}
