package book;

import java.util.ArrayList;

public interface BookManipulable {
    public ArrayList<Book> filter(ArrayList<Book> list);

    public ArrayList<Book> sorted(ArrayList<Book> list);


}
