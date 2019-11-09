package com.xDish.PaperTrail.Controllers;


import com.xDish.PaperTrail.Services.GetAuthor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public String test() throws Exception {
        String finalName = "eiknx";
        Document document = (Document) new GetAuthor().xmlParsed();
        NodeList xml = document.getElementsByTagName("author");
        Node nameOfAuthor = xml.item(2);
        if(nameOfAuthor.getNodeType() == Node.ELEMENT_NODE){
            Element author =(Element) nameOfAuthor;
            NodeList authorNames = author.getChildNodes();
            Node name = authorNames.item(3);
            finalName = name.getTextContent();
        }
        return finalName;
    }
}
