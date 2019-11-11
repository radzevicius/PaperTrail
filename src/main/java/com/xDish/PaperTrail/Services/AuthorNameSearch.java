package com.xDish.PaperTrail.Services;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;


public class AuthorNameSearch {

  public static String url = "https://www.goodreads.com/search/index.xml?key=v8zzKlJwTVg7h9uJXCuzpg&q=sanderson&search[field]=author";

  public AuthorNameSearch() throws Exception {
  }

  Document document =  new GetXml().XmlDocument(url);

  public String parsedName() throws Exception {
    String finalName = "I didn't change";
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







