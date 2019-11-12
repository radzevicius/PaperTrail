package com.xDish.PaperTrail.Controllers;


        import com.xDish.PaperTrail.Services.AuthorIdSearch;
        import com.xDish.PaperTrail.Services.AuthorNameSearch;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SearchController {

    @GetMapping("/search/author/name/{name}")
    public AuthorNameSearch nameSearchAuthor(@PathVariable("name") String query) throws Exception {
        Integer variant = 1;
        AuthorNameSearch result = new AuthorNameSearch(variant, query);
        return result;
    }

    @GetMapping("/search/author/id/{id}")
    public AuthorIdSearch idSearchAuthor(@PathVariable("id") String id) throws Exception {
        Integer variant = 2;
        AuthorIdSearch result = new AuthorIdSearch(variant, id);
        return result;
    }

}
