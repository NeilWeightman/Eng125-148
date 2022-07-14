package com.sparta.func;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortTest {
//    private static class AuthorComparator implements Comparator<Author> {
//        @Override
//        public int compare(Author o1, Author o2) {
//            return o1.getFirstName().compareTo(o2.getFirstName());
//        }
//    }

    public static void main(String[] args) {
        try {
            List<String> emails = Files.lines(Path.of("authors.csv"))
                    .skip(1) // skip headers
                    .map(s -> s.split(",")[3])
                    .filter(e -> e.substring(e.length()-3).equals("net"))
                    .toList();
            System.out.println(emails);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main3(String[] args) {
        List<Author> authorList = getAuthorList();
        authorList.stream()
                .filter(a -> a.getLastName().length() == 4)
                .forEach(a -> System.out.println(a));
        System.out.println(authorList.stream()
                .anyMatch(a -> a.getLastName().length() < 6));
        authorList.stream()
                .mapToInt(a -> a.getLastName().length())
                .forEach(System.out::println);
    }

    public static void main2(String[] args) {
        List<Author> authorList = getAuthorList();
        List<String> nameList = getNameList(authorList);
//        Collections.sort(authorList); // why is this an error...
        // anonymous inner class version
//        Collections.sort(authorList, new Comparator<Author>() {
//            public int compare(Author o1, Author o2) {
//                return o1.getFirstName().compareTo(o2.getFirstName());
//            }
//        });
        Collections.sort(authorList, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

//            Comparator.comparing(Author::getLastName) // using method reference
//            (o1, o2) -> {
////                System.out.println("Hello!" + nameList); // can have other statements
//                // can access variables from enclosing scope
//                return o1.getLastName().compareTo(o2.getLastName());
//            }
//        );
        System.out.println(authorList);
        Collections.sort(nameList); // ...when this is fine?
        System.out.println(nameList);
        // get a random name to answer this question
        Collections.shuffle(nameList);
        System.out.println(nameList.get(0));
    }

    private static List<String> getNameList(List<Author> authorList) {
        List<String> result = new ArrayList<>();
        for (Author author : authorList) {
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
