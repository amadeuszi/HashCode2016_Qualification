package com.kosior.hash.model;

public class Book implements Comparable<Book> {

	public int id;
	public boolean done = false;
	public int score;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Book book) {
		return Integer.compare(book.getScore(), this.getScore());
	}
}
