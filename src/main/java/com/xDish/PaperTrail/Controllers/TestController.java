package com.xDish.PaperTrail.Controllers;


        import com.xDish.PaperTrail.Services.AuthorNameSearch;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.Collection;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/search/{variant}/{query}")
    public AuthorNameSearch test(@PathVariable("variant") String variant, @PathVariable("query") String query) throws Exception {
        AuthorNameSearch result = new AuthorNameSearch(Integer.parseInt(variant), query);
        return result;
    }
}
