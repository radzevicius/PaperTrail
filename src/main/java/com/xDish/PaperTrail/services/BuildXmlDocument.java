package com.xDish.PaperTrail.services;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

public class BuildXmlDocument {

    private static Document loadTestDocument(String url) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return (Document) factory.newDocumentBuilder().parse(new URL(url).openStream());
    }

    public static Document XmlDocument(String url) throws Exception {
        Document doc = loadTestDocument(url);
        return doc;
    }
}
