package com.xDish.PaperTrail.services;

import com.xDish.PaperTrail.entities.Author;
import com.xDish.PaperTrail.entities.AuthorBookModel;
import com.xDish.PaperTrail.entities.Book;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorIdSearchService {

    public AuthorBookModel getAuthorBookData(int variant, String authorID) throws Exception{
        AuthorBookModel authorBookModel = new AuthorBookModel();
        Document document = BuildXmlDocument.XmlDocument(ApiUrlBuilder.buildUrl(variant, authorID));
        Node authorNode = document.getElementsByTagName("author").item(0);
        Element authorElement = (Element) authorNode.getChildNodes();
        Author author =  parseAuthorInfo(authorElement);
        authorBookModel.addAuthor(author);
        NodeList books = authorElement.getElementsByTagName("book");
        for (int i = 0 ; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            Book parsedBook = parseBooks(book);
            authorBookModel.addBook(parsedBook);
        }
        return authorBookModel;
    }


    private Author parseAuthorInfo(Element authorInfo) {
        Author currentAuthor = new Author();
        currentAuthor.setName(authorInfo.getElementsByTagName("name").item(0).getTextContent());
        currentAuthor.setId(authorInfo.getElementsByTagName("id").item(0).getTextContent());
        currentAuthor.setImageURL(authorInfo.getElementsByTagName("image_url").item(0).getTextContent());
        currentAuthor.setAbout(authorInfo.getElementsByTagName("about").item(0).getTextContent());
        currentAuthor.setGender(authorInfo.getElementsByTagName("gender").item(0).getTextContent());
        return currentAuthor;

    }

    private Book parseBooks(Element book) {
            Book currentBook = new Book();
            currentBook.setTitle(book.getElementsByTagName("title").item(0).getTextContent());
            currentBook.setBookImageURL(book.getElementsByTagName("image_url").item(0).getTextContent());
            currentBook.setAverageRating(book.getElementsByTagName("average_rating").item(0).getTextContent());
            currentBook.setIsbn(book.getElementsByTagName("isbn").item(0).getTextContent());
            currentBook.setPages(book.getElementsByTagName("num_pages").item(0).getTextContent());
            currentBook.setId(book.getElementsByTagName("id").item(0).getTextContent());
            currentBook.setDescription(book.getElementsByTagName("description").item(0).getTextContent());
            Element author =(Element) book.getElementsByTagName("author").item(0);
            currentBook.setAuthor(author.getElementsByTagName("name").item(0).getTextContent());
            currentBook.setAuthorId(author.getElementsByTagName("id").item(0).getTextContent());
            return currentBook;
        }
}
