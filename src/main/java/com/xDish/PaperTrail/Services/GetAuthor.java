package com.xDish.PaperTrail.Services;


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;


public class GetAuthor {

  public static String url = "https://www.goodreads.com/search/index.xml?key=v8zzKlJwTVg7h9uJXCuzpg&q=sanderson&search[field]=author";

  private static Document loadTestDocument(String url) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    return (Document) factory.newDocumentBuilder().parse(new URL(url).openStream());
  }

  public Document xmlParsed() throws Exception {
    Document  doc = loadTestDocument(url);
    return doc;
  }
}







