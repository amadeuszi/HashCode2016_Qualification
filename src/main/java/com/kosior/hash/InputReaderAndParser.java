package com.kosior.hash;

import com.kosior.hash.model.Book;
import com.kosior.hash.model.Data;
import com.kosior.hash.model.Library;

import java.util.Scanner;

public class InputReaderAndParser {

	public static Scanner scanner = new Scanner(System.in);

	public static Data readAndParseInput() {
		Data data = new Data();
		data.setNumberOfBooks(scanner.nextInt());
		data.setNumberOfLibraries(scanner.nextInt());
		data.setNumberOfDays(scanner.nextInt());

		for (int i = 0; i < data.getNumberOfBooks(); i++) {
			Book book = new Book();
			book.setId(i);
			book.setScore(scanner.nextInt());
			data.getAllBooks().add(book);
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
				library.getBooks().add(book);
			}
			data.getLibraries().add(library);
		}

		return data;
	}

}
