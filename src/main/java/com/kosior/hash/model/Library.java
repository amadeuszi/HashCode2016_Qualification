package com.kosior.hash.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Library implements  Comparable<Library> {

	public int id;
	public int numberOfBooks;
	public int signupTime = 0;
	public int performance;
	public List<Book> books = new ArrayList<>();
	public List<Book> booksToScan = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	public int getSignupTime() {
		return signupTime;
	}

	public void setSignupTime(int signupTime) {
		this.signupTime = signupTime;
	}

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooksToScan() {
		return booksToScan;
	}

	public void setBooksToScan(List<Book> booksToScan) {
		this.booksToScan = booksToScan;
	}

	@Override
	public int compareTo(Library library) {
		return Integer.compare(library.getSignupTime(), this.getSignupTime());
	}

}
