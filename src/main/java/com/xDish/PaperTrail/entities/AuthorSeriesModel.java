package com.xDish.PaperTrail.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class AuthorSeriesModel {

    HashSet<AuthorOverview> authorOverviews = new HashSet<AuthorOverview>();
    List<Series> series = new ArrayList<Series>();

    public void addAuthorOverview(AuthorOverview authorOverview){ this.authorOverviews.add(authorOverview); }
    public void addSeries(Series series){this.series.add(series); }


}
