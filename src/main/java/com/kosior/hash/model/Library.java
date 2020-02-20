package com.kosior.hash.model;

import java.util.ArrayList;
import java.util.List;

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
		int x1 = this.getScore(this);
		int x2 = this.getScore(library);
		return Integer.compare(x2, x1);
	}

	private int getScore(Library library) {
		int res = 0;
		res += library.getBooks().stream().filter(b -> !b.isDone()).map(b -> b.getScore()).reduce(0, Integer::sum) * 0.7; // TODO factor
//		res += library.getPerformance();
		res += (-1) * library.getSignupTime() ; // TODO factor

		return res;
	}

}
