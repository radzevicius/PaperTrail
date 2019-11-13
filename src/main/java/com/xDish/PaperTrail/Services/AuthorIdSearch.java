package com.xDish.PaperTrail.Services;

import com.xDish.PaperTrail.Entities.Author;
import com.xDish.PaperTrail.Entities.Book;
import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AuthorIdSearch {

    private Author author;
    private List<Book> books = new ArrayList<Book>();

    public AuthorIdSearch(int variant, String query) throws Exception {
        elementBuilder(variant, query);
    }

    private void parseAuthorInfo(Element authorInfo) {
        Author currentAuthor = new Author();
        currentAuthor.setName(authorInfo.getElementsByTagName("name").item(0).getTextContent());
        currentAuthor.setId(authorInfo.getElementsByTagName("id").item(0).getTextContent());
        currentAuthor.setImageURL(authorInfo.getElementsByTagName("image_url").item(0).getTextContent());
        currentAuthor.setAbout(authorInfo.getElementsByTagName("about").item(0).getTextContent());
        currentAuthor.setGender(authorInfo.getElementsByTagName("gender").item(0).getTextContent());
        this.author = currentAuthor;

    }

    private void parseBooks(NodeList books) {
        for (int i = 0 ; i < books.getLength(); i++){
            Element book =(Element) books.item(i);
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
            this.books.add(currentBook);
        }
    }

    private void elementBuilder(int variant, String query) throws Exception {
        Document document = BuildXmlDocument.XmlDocument(ApiUrlBuilder.buildUrl(variant, query));
        Node authorNode = document.getElementsByTagName("author").item(0);
        Element authorElement = (Element) authorNode.getChildNodes();
        parseAuthorInfo(authorElement);
        NodeList books = authorElement.getElementsByTagName("book");
        parseBooks(books);
    }


}



