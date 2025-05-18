package newLibrarySystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LibrarySystem {

	
	protected final Map<String, List<Book >> booksByGenre = new HashMap<>() ; 
	protected final Set <Book> allBooks  = new HashSet <>(); 
	
	
	// 8 - 
	public void addBook( String genre, Book book) {
		Objects.requireNonNull(genre , "Genre cannot be null "); 
		Objects.requireNonNull(book, "Book cannot be null"); 
		
		booksByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(book);
		allBooks.add(book); 
	}
	
	// 9 -  
	public List<Book> getBooksByGenre(String genre){
		return Collections.unmodifiableList(booksByGenre.getOrDefault(genre, Collections.emptyList())
				);			
	}
	
	// 10 - 
	public void printBooksInGenre(String genre) {
		List<Book> books = getBooksByGenre(genre) ; 
		
		if (books.isEmpty()) {
			System.out.println("No books have been found in" + genre); 
		} else { 
				System.out.println("\n ===" + genre + "Books (" + books.size() + ")===="); 
				books.forEach(System.out::print);
			}	
		}
	
	//11 - 
	public void sortAndPrintGenre(String genre, Comparator<Book> comparator) {
		getBooksByGenre(genre).stream()		
			.sorted(comparator)
			.forEach(System.out ::println); 
		}

// 12- 
	public List <Book> searchByTitle(String title){
		return allBooks.stream()
					.filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
					.collect(Collectors.toUnmodifiableList());
		
	}
	
	// 13- 
	public Set<Book> getAllBooks(){
		return Collections.unmodifiableSet(allBooks);
	}
	
	public Map<String, List<Book>> getBooksByGenreMap(){
		return Collections.unmodifiableMap(booksByGenre); 
	}
	
}
