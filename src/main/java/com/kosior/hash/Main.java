package com.kosior.hash;

import com.kosior.hash.model.Book;
import com.kosior.hash.model.Data;
import com.kosior.hash.model.Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    private Data data;

    private int currentDay = 0;


    private static List<Library> outputLibraries = new ArrayList<>();
    private static Library processLibrary = null;

    private PriorityQueue<Library> libraryQueue;
    private int finishSignUp = -1;


    private void run() {
        data = InputReaderAndParser.readAndParseInput();
        libraryQueue = new PriorityQueue<>(data.getLibraries());

        while (currentDay < data.getNumberOfDays()) {
            if (finishSignUp == currentDay) {
                assert processLibrary != null;
                outputLibraries.add(processLibrary);
                processLibrary = null;
            }
            if (finishSignUp < currentDay && !libraryQueue.isEmpty()) {
                Library library = libraryQueue.poll();
                finishSignUp = currentDay + library.getSignupTime() - 1; // TODO czy na pewno - 1
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

    private List<Book> findBooks(Library library) {
        int size = library.getNumberOfBooks();
        library.getBooksToScan().removeIf(Book::isDone);
        if (library.getBooksToScan().isEmpty()) {
            return Collections.emptyList();
        }
        List<Book> ret = new ArrayList<>();
        for (Book book : library.getBooksToScan()) {
            if (ret.size() == size) {
                break;
            }
            ret.add(book);
            book.setDone(true);

        }
        return ret;
    }

    private void printOutput() {
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
