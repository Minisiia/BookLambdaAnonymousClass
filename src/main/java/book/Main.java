package book;

import java.util.*;

/**
 * Створити клас Book, зробити 3 поля та відповідні методи.
 * Необхідно реалізувати замикання анонімного класу та лямбда-виразу.
 */
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Alexandre Dumas", "The Count of Monte Cristo", 1845);
        Book book2 = new Book("Nat Gould", "Fast as the Wind", 1918);
        Book book3 = new Book("Arthur Conan Doyle", "The Lost World", 1912);
        Book book4 = new Book("Jules Verne", "A Journey to the Centre of the Earth", 1871);
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        System.out.println((char) 27 + "[34m" + "Lambda expression:" + (char) 27 + "[38m");
        bookList.stream().filter(b -> b.getYear() <= 1915)
                .sorted(Comparator.comparing(Book::getTitle))
                .map(Book::getTitle)
                .forEach(
                        System.out::println
                );

        System.out.println((char) 27 + "[34m" + "Anonymous class:" + (char) 27 + "[38m");

        BookManipulable manipulable = new BookManipulable() {
            @Override
            public ArrayList<Book> filter(ArrayList<Book> list) {
                ArrayList<Book> tempList = new ArrayList<>();
                for (Book temp : list) {
                    if (temp.getYear() <= 1915) tempList.add(temp);
                }
                return tempList;
            }

            @Override
            public ArrayList<Book> sorted(ArrayList<Book> list) {
                ArrayList<Book> tempList = list;
                tempList.sort(Comparator.comparing(Book::getTitle));
                return tempList;
            }
        };
        ArrayList<Book> filterList = manipulable.filter(bookList);
        manipulable.sorted(filterList);
        for (Book temp : filterList) {
            System.out.println(temp.getTitle());
        }
    }
}
