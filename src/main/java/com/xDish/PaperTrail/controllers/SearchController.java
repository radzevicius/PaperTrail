package com.xDish.PaperTrail.controllers;


import com.xDish.PaperTrail.entities.AuthorBookModel;
import com.xDish.PaperTrail.services.AuthorIdSearch;
import com.xDish.PaperTrail.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchController {

    private final AuthorService authorService;

    @GetMapping("/search/author/name/{name}")
    public AuthorBookModel nameSearchAuthor(@PathVariable("name") String query) throws Exception {
        int variant = 1;
        return authorService.getAuthorBookData(variant, query);
    }

    @GetMapping("/search/author/id/{id}")
    public AuthorIdSearch idSearchAuthor(@PathVariable("id") String id) throws Exception {
        int variant = 2;
        return new AuthorIdSearch(variant, id);
    }

}
