package com.xDish.PaperTrail.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AuthorBookOverviewModel {
    private Set<AuthorOverview> authors = new HashSet<>();
    private List<BookOverview> books = new ArrayList<>();

    public void addAuthorOverview(AuthorOverview authorOverview) {
        this.authors.add(authorOverview);
    }

    public void addBookOverview(BookOverview bookOverview) {
        this.books.add(bookOverview);
    }
}
