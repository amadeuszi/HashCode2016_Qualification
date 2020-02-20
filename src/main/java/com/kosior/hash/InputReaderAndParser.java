package com.kosior.hash;

import com.kosior.hash.model.Book;
import com.kosior.hash.model.Data;
import com.kosior.hash.model.Library;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

import static com.kosior.hash.Main.booksInHowManyLibraries;

public class InputReaderAndParser {

	public static Scanner scanner = new Scanner(System.in);

	public static Data readAndParseInput() {
		Data data = new Data();
		data.setNumberOfBooks(scanner.nextInt());
		data.setNumberOfLibraries(scanner.nextInt());
		data.setNumberOfDays(scanner.nextInt());
		booksInHowManyLibraries = new ArrayList<>();
		for (int i = 0; i < data.getNumberOfBooks(); i++) {
			Book book = new Book();
			book.setId(i);
			book.setScore(scanner.nextInt());
			data.getAllBooks().add(book);
			booksInHowManyLibraries.add(0);
		}


		for (int i = 0; i < data.getNumberOfLibraries(); i++) {
			Library library = new Library();
			library.setId(i);
			library.setNumberOfBooks(scanner.nextInt());
			library.setSignupTime(scanner.nextInt());
			library.setPerformance(scanner.nextInt());

			for (int j = 0; j < library.getNumberOfBooks(); j++) {
				int bookId = scanner.nextInt();
				Book book = data.getAllBooks().get(bookId);
				booksInHowManyLibraries.set(bookId, booksInHowManyLibraries.get(bookId) + 1);
				library.getBooks().add(book);
			}
			library.getBooksToScan().sort(Book::compareTo);
			data.getLibraries().add(library);
		}

		for (Library library : data.getLibraries()) {
			int distinctBooks = 0;
			for (Book book : library.getBooks()) {
				if (booksInHowManyLibraries.get(book.getId()) == 1) {
					distinctBooks++;
				}
			}
			library.setDistinctBooks(distinctBooks);
		}

		return data;
	}

}
