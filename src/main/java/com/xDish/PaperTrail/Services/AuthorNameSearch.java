package com.xDish.PaperTrail.Services;


import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Getter
public class AuthorNameSearch {

  private String name;
  private Integer id;

  public AuthorNameSearch(int variant, String query) throws Exception {
    parseName(variant, query);
  }

  public void parseName(int variant, String query) throws Exception {
    Document document =  BuildXmlDocument.XmlDocument(ApiUrlBuilder.buildUrl(variant, query));
    NodeList xml = document.getElementsByTagName("author");
    Node nameOfAuthor = xml.item(0);
    if (nameOfAuthor.getNodeType() == Node.ELEMENT_NODE) {
      Element author = (Element) nameOfAuthor;
      NodeList authorNames = author.getChildNodes();
      Node name = authorNames.item(3);
      Node authorId = authorNames.item(1);
      this.name = name.getTextContent();
      this.id = Integer.parseInt(authorId.getTextContent());
    }
  }
}







