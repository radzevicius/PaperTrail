package com.xDish.PaperTrail.services;

import com.xDish.PaperTrail.entities.AuthorBookModel;
import com.xDish.PaperTrail.entities.AuthorOverview;
import com.xDish.PaperTrail.entities.BookOverview;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

@Service
public class AuthorService {

    public AuthorBookModel getAuthorBookData(int variant, String query) throws Exception {
        Document document = BuildXmlDocument.XmlDocument(ApiUrlBuilder.buildUrl(variant, query));
        NodeList listOfWorks = document.getElementsByTagName("work");
        AuthorBookModel authorBookModel = new AuthorBookModel();
        for (int i = 0; i < listOfWorks.getLength(); i++) {
            Node specificWork = listOfWorks.item(i);
            BookOverview book = parseBookData((Element) specificWork);
            AuthorOverview author = parseAuthorData((Element) specificWork);
            authorBookModel.addAuthor(author);
            authorBookModel.addBook(book);
        }
        return authorBookModel;
    }

    private AuthorOverview parseAuthorData(Element work) {
        Element bookElement = (Element) work.getElementsByTagName("best_book").item(0);
        Element xmlAuthor = (Element) bookElement.getElementsByTagName("author").item(0);
        AuthorOverview currentAuthor = new AuthorOverview();
        currentAuthor.setName(xmlAuthor.getElementsByTagName("name").item(0).getTextContent());
        currentAuthor.setId(xmlAuthor.getElementsByTagName("id").item(0).getTextContent());
        return currentAuthor;
    }

    private BookOverview parseBookData(Element work) {
        BookOverview currentBookOverview = new BookOverview();
        currentBookOverview.setRating(work.getElementsByTagName("average_rating").item(0).getTextContent());
        Element bookElement = (Element) work.getElementsByTagName("best_book").item(0);
        currentBookOverview.setImageURL(bookElement.getElementsByTagName("image_url").item(0).getTextContent());
        currentBookOverview.setTitle(bookElement.getElementsByTagName("title").item(0).getTextContent());
        currentBookOverview.setId(bookElement.getElementsByTagName("id").item(0).getTextContent());
        return currentBookOverview;
    }
}
