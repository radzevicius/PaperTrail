package com.xDish.PaperTrail.Controllers;


import com.xDish.PaperTrail.Services.AuthorNameSearch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/search/{variant}/{query}")
    public ResponseEntity<String> test(@PathVariable("variant") String variant, @PathVariable("query") String query) throws Exception {
        String  test = new AuthorNameSearch().parseName(Integer.parseInt(variant),query);
        return ResponseEntity.ok().body(test);
    }
}
