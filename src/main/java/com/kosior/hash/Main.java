package com.kosior.hash;

import com.kosior.hash.model.Book;
import com.kosior.hash.model.Data;
import com.kosior.hash.model.Library;

import java.util.*;

public class Main {

    public static Data data;

    public static int currentDay = 0;
    private static List<Library> outputLibraries = new ArrayList<>();
    private static Library processLibrary = null;

    public static List<Library> librarySortable;
    private int finishSignUp = -1;
    public static List<Integer> booksInHowManyLibraries;


    private void run() {
        data = InputReaderAndParser.readAndParseInput();
        librarySortable = new ArrayList<>(data.getLibraries());

        // this.printLibrariesData();

        while (currentDay < data.getNumberOfDays()) {
            if (finishSignUp == currentDay) {
                outputLibraries.add(processLibrary);
                processLibrary = null;
            }
            if (finishSignUp <= currentDay && !librarySortable.isEmpty()) {
                librarySortable.sort(Library::compareTo);
                Library library = librarySortable.remove(0);
                finishSignUp = currentDay + library.getSignupTime(); // TODO czy na pewno - 1
                processLibrary = library;
            }
            for (Library library : outputLibraries) {
                List<Book> books = this.findBooks(library);
                library.getBooksToScan().addAll(books);
            }

            // symulowanko

            currentDay++;
        }

        this.printOutput();
    }

    private void printLibrariesData() {
        for (Library library : data.libraries) {
            int suma = library.getBooks().stream().filter(b -> !b.isDone()).map(b -> b.getScore()).reduce(0, Integer::sum);
            System.out.println(library.getSignupTime() + " " + library.getPerformance() + " " + library.getDistinctBooks() + " " + Math.log(suma));
        }
    }

    private List<Book> findBooks(Library library) {
        int size = library.getNumberOfBooks() * (this.data.getNumberOfDays() - this.currentDay + 1);
        library.getBooks().removeIf(Book::isDone);
        library.getBooks().sort(Book::compareTo);
        if (library.getBooks().isEmpty()) {
            return Collections.emptyList();
        }
        List<Book> ret = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (ret.size() == size) {
                break;
            }
            ret.add(book);
            book.setDone(true);

        }
        return ret;
    }

    private void printOutput() {
        outputLibraries.removeIf(l -> l.getBooksToScan().isEmpty());
        System.out.println(outputLibraries.size());
        for (Library library : outputLibraries) {
            System.out.println(library.getId() + " " + library.getBooksToScan().size());
            for (Book book : library.getBooksToScan()) {
                System.out.print(book.getId() + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        new Main().run();
    }
}
