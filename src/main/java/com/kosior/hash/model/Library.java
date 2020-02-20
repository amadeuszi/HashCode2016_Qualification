package com.kosior.hash.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {

	public int id;
	public int numberOfBooks;
	public int signupTime = 0;
	public int performance;
	public List<Book> books = new ArrayList<>();

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
}
