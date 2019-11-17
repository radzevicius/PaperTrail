package com.xDish.PaperTrail.services;

import org.w3c.dom.Element;

public class ElementTextContent {

    public String ElementTextContent(Element element, String name){
        return textContent(element,name);
    }

    private static String textContent(Element element,String name){
        return element.getElementsByTagName(name).item(0).getTextContent();
    }
}
