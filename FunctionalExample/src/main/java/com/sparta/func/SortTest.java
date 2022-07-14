package com.sparta.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Author> authorList = getAuthorList();
        List<String> nameList = getNameList(authorList);
        System.out.println(authorList);
        System.out.println(nameList);
    }

    private static List<String> getNameList(List<Author> authorList) {
        List<String> result = new ArrayList<>();
        for(Author author: authorList){
            result.add(author.toString());
        }
        return result;
    }

    private static List<Author> getAuthorList() {
        return new ArrayList<>(List.of(new Author("Michael", "Alo"),
                new Author("Ray", "Azam"),
                new Author("Jeff", "Champion"),
                new Author("Michael", "Matson"),
                new Author("Marc", "Murray"),
                new Author("Dhrushil", "Sedani"),
                new Author("Alfred", "Abraham"),
                new Author("David", "Carew"),
                new Author("Kira", "Coke"),
                new Author("Toby", "Gascoigne"),
                new Author("Dogukhan", "Karapinar"),
                new Author("Yanaki", "Kolarov"),
                new Author("Vlad", "Logyin"),
                new Author("Mustafa", "Nawaz"),
                new Author("Billie", "Parsons"),
                new Author("Bart", "Perczynski"),
                new Author("Jamie", "Scofield"),
                new Author("Omar", "Tehami"),
                new Author("Pete", "Wiatr")));
    }
}
