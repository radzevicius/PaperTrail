package com.xDish.PaperTrail.controllers;


import com.xDish.PaperTrail.entities.AuthorBookModel;
import com.xDish.PaperTrail.entities.AuthorBookOverviewModel;
import com.xDish.PaperTrail.entities.AuthorSeriesModel;
import com.xDish.PaperTrail.services.AuthorIdSearchService;
import com.xDish.PaperTrail.services.AuthorIdSeriesSearchService;
import com.xDish.PaperTrail.services.AuthorSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://192.168.1.248:3000")
public class SearchController {

    private final AuthorSearchService authorService;
    private final AuthorIdSearchService authorIdSearchService;
    private final AuthorIdSeriesSearchService authorIdSeriesSearchService;

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

    @GetMapping("/search/series/author/{id}")
    public AuthorSeriesModel authorIdSearchSeries(@PathVariable("id") String id) throws Exception {
        int variant = 3;
        return authorIdSeriesSearchService.getAuthorSeriesData(variant, id);
    }

}
