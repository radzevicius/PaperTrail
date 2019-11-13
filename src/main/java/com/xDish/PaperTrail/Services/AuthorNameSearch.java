package com.xDish.PaperTrail.Services;


import com.xDish.PaperTrail.Entities.AuthorOverview;
import com.xDish.PaperTrail.Entities.BookOverview;
import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AuthorNameSearch {

  private List<AuthorOverview> authors = new ArrayList<AuthorOverview>();
  private List<BookOverview> books = new ArrayList<BookOverview>();


  public AuthorNameSearch(int variant, String query) throws Exception {
    elementBuilder(variant, query);
  }

  private void checkAuthors(Element author) {
    int authorID = Integer.parseInt(author.getElementsByTagName("id").item(0).getTextContent());
    for (AuthorOverview authorOverview : authors){
      if (Integer.parseInt(authorOverview.getId()) == authorID){
        return;
      }
    }
    parseAuthorData(author);


  }

  private void parseAuthorData(Element author){
    AuthorOverview currentAuthor =  new AuthorOverview();
    currentAuthor.setName(author.getElementsByTagName("name").item(0).getTextContent());
    currentAuthor.setId(author.getElementsByTagName("id").item(0).getTextContent());
    this.authors.add(currentAuthor);

  }

  private void parseBookData(Element work){
    BookOverview currentBookOverview = new BookOverview();
    currentBookOverview.setRating(work.getElementsByTagName("average_rating").item(0).getTextContent());
    Element bookElement =(Element) work.getElementsByTagName("best_book").item(0);
    currentBookOverview.setImageURL(bookElement.getElementsByTagName("image_url").item(0).getTextContent());
    currentBookOverview.setTitle(bookElement.getElementsByTagName("title").item(0).getTextContent());
    currentBookOverview.setId(bookElement.getElementsByTagName("id").item(0).getTextContent());
    Element author = (Element) bookElement.getElementsByTagName("author").item(0);
    currentBookOverview.setAuthor(author.getElementsByTagName("name").item(0).getTextContent());
    currentBookOverview.setAuthorID(author.getElementsByTagName("id").item(0).getTextContent());
    checkAuthors(author);
    this.books.add(currentBookOverview);
  }


  private void elementBuilder(int variant, String query) throws Exception{
    Document document =  BuildXmlDocument.XmlDocument(ApiUrlBuilder.buildUrl(variant, query));
    NodeList listOfWorks = document.getElementsByTagName("work");
    for (int i = 0 ; i < listOfWorks.getLength(); i++){
      Node specificWork = listOfWorks.item(i);
      parseBookData((Element)specificWork);
    }
  }

}







