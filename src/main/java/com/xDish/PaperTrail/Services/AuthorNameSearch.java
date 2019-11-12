package com.xDish.PaperTrail.Services;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;


public class AuthorNameSearch {

  public AuthorNameSearch() throws Exception {
  }

  public String parseName(int variant, String query) throws Exception {
    String finalName = "I didn't change";
    String url = new ApiUrlBuilder().buildUrl(variant, query);
    Document document =  new GetXml().XmlDocument(url);
    NodeList xml = document.getElementsByTagName("author");
    Node nameOfAuthor = xml.item(2);
    if (nameOfAuthor.getNodeType() == Node.ELEMENT_NODE) {
      Element author = (Element) nameOfAuthor;
      NodeList authorNames = author.getChildNodes();
      Node name = authorNames.item(3);
      finalName = name.getTextContent();
    }
    return finalName;
  }
}







