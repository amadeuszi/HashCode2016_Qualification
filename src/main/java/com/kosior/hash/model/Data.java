package com.kosior.hash.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Data {
    public int numberOfBooks;
    public int numberOfDays;
    public int numberOfLibraries;
    public List<Book> allBooks = new ArrayList<>();
    public List<Library> libraries = new ArrayList<>();

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public int getNumberOfLibraries() {
        return numberOfLibraries;
    }

    public void setNumberOfLibraries(int numberOfLibraries) {
        this.numberOfLibraries = numberOfLibraries;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
