package newLibrarySystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LibraryManager manager = new LibraryManager(); 
		
		// loading file 
		manager.loadFromAFile("books.txt");

		// modifying file 
		manager.addBook("Fantasy", new Book("The year of flowers", "Simon L", 1984)); 
		manager.addBook("Sci-Fi", new Book("Simon", "Paloma V", 2021)); 
		manager.addBook("Fantasy", new Book("Zebre malgrès lui", "Vanessa H", 1600)); 
		
		manager.printBooksInGenre("Fantasy"); 
		
		System.out.println(" Sorted by author : "); 
		manager.sortAndPrintGenre("Fantasy",Comparator.comparing(Book ::getAuthor));
		
		System.out.println(" Books matching title keyword : 'Simon' : "); 
		manager.searchByTitle("Simon").forEach(System.out::println);
		 
		// saving file 
		manager.saveToFile("books.txt");
		
	}

}

