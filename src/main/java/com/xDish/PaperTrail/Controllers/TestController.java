package com.xDish.PaperTrail.Controllers;


import com.xDish.PaperTrail.Services.AuthorNameSearch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/search/{variant}/{query}")
    public String test(@PathVariable("variant") String variant, @PathVariable("query") String query) throws Exception {
         return new AuthorNameSearch().parseName(Integer.parseInt(variant),query);
    }
}
