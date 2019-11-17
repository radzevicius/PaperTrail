package com.xDish.PaperTrail.services;

public class ApiUrlBuilder {

    private static String urlPicker(int variant) {
        String urlFragment;
        switch (variant) {
            case 1:
                urlFragment = "https://www.goodreads.com/search/index.xml?key=v8zzKlJwTVg7h9uJXCuzpg&search[field]=author&q=";
                break;
            case 2:
                urlFragment = "https://www.goodreads.com/author/show.xml?key=v8zzKlJwTVg7h9uJXCuzpg&id=";
                break;
            default:
                urlFragment = "https://www.goodreads.com/search/index.xml?key=v8zzKlJwTVg7h9uJXCuzpg&search[field]=autheeor&q=";
                break;
        }
        return urlFragment;
    }

    public static String buildUrl(int urlVariant, String search){
        return urlPicker(urlVariant)+ search;
    }
}
