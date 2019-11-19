package com.xDish.PaperTrail.controllers;


import com.xDish.PaperTrail.entities.AuthorBookModel;
import com.xDish.PaperTrail.entities.AuthorBookOverviewModel;
import com.xDish.PaperTrail.services.AuthorIdSearchService;
import com.xDish.PaperTrail.services.AuthorSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchController {

    private final AuthorSearchService authorService;
    private final AuthorIdSearchService authorIdSearchService;

    @GetMapping("/search/author/name/{name}")
    public AuthorBookOverviewModel nameSearchAuthor(@PathVariable("name") String query) throws Exception {
        int variant = 1;
        return authorService.getAuthorBookOverviewData(variant, query);
    }

    @GetMapping("/search/author/id/{id}")
    public AuthorBookModel idSearchAuthor(@PathVariable("id") String id) throws Exception {
        int variant = 2;
        return authorIdSearchService.getAuthorBookData(variant,id);
    }

}
