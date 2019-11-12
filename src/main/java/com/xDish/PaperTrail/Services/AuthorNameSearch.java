package com.xDish.PaperTrail.Services;


import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

@Getter
public class AuthorNameSearch {

  private String name;
  private Integer id;

  public AuthorNameSearch(int variant, String query) throws Exception {
    parseName(variant, query);
  }

  public void parseName(int variant, String query) throws Exception {
    String finalName = "I didn't change";
    String url = new ApiUrlBuilder().buildUrl(variant, query);
    Document document =  new GetXml().XmlDocument(url);
    NodeList xml = document.getElementsByTagName("author");
    Node nameOfAuthor = xml.item(2);
    if (nameOfAuthor.getNodeType() == Node.ELEMENT_NODE) {
      Element author = (Element) nameOfAuthor;
      NodeList authorNames = author.getChildNodes();
      Node name = authorNames.item(3);
      Node authorId = authorNames.item(1);
      finalName = name.getTextContent();
      this.name = finalName;
      this.id = Integer.parseInt(authorId.getTextContent());
    }
  }
}







