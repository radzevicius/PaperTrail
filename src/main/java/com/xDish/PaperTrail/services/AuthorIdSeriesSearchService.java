package com.xDish.PaperTrail.services;


import com.xDish.PaperTrail.entities.*;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class AuthorIdSeriesSearchService {

    public AuthorSeriesModel getAuthorSeriesData(int variant, String id) throws Exception {
        AuthorSeriesModel authorSeriesModel =new AuthorSeriesModel();
        Document document = BuildXmlDocument.XmlDocument(ApiUrlBuilder.buildUrl(variant, id));
        NodeList listOfSeriesWorks = document.getElementsByTagName("series_work");
        for (int i=0; i< listOfSeriesWorks.getLength(); i++){
            Element specificSeries =(Element) listOfSeriesWorks.item(i);
            Element bestBook = (Element) specificSeries.getElementsByTagName("best_book").item(0);
            AuthorOverview author = parseAuthorData(bestBook);
            Element seriesElement = (Element) specificSeries.getElementsByTagName("series").item(0);
            Series series = parseSeriesData(seriesElement);
            System.out.println(author.getId());
            System.out.println(id);
            if(Integer.parseInt(author.getId()) == Integer.parseInt(id)){
                authorSeriesModel.addAuthorOverview(author);
                authorSeriesModel.addSeries(series);
            }
        }
        return authorSeriesModel;
    }

    private Series parseSeriesData(Element seriesElement) {
        Series series = new Series();
        String id = seriesElement.getElementsByTagName("id").item(0).getTextContent();
        String title = seriesElement.getElementsByTagName("title").item(0).getTextContent();
        String description = seriesElement.getElementsByTagName("description").item(0).getTextContent();
        series.setId(id);
        series.setTitle(title);
        series.setDescription(description);
        return series;
    }

    private AuthorOverview parseAuthorData(Element bestBook) {
        AuthorOverview author = new AuthorOverview();
        Element authorElement =(Element) bestBook.getElementsByTagName("author").item(0);
        String name =  authorElement.getElementsByTagName("name").item(0).getTextContent();
        String id = authorElement.getElementsByTagName("id").item(0).getTextContent();
        author.setName(name);
        author.setId(id);
        return author;
    }

}
