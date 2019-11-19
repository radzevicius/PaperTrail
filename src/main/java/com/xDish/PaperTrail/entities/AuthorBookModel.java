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
public class AuthorBookModel {
    private Set<Author> authors = new HashSet<>();
    private List<Book> books = new ArrayList<>();

    public void addAuthor(Author author){this.authors.add(author); }

    public void addBook(Book book){this.books.add(book); }

}

