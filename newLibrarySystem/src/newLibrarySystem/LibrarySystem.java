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
	
	
	// 8 - Adding new books under the given genre + if genre unknown, create it and add to the Set(= unique element). 
	public void addBook( String genre, Book book) {
		Objects.requireNonNull(genre , "Genre cannot be null "); 
		Objects.requireNonNull(book, "Book cannot be null"); 
		
		booksByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(book);
		allBooks.add(book); 
	}
	
	// 9 - Returns an unmodifiable list of books for safety -> ensure read-only access.
	public List<Book> getBooksByGenre(String genre){
		return Collections.unmodifiableList(booksByGenre.getOrDefault(genre, Collections.emptyList())
				);			
	}
	
	// 10 - Prints all books for a genre + informs if empty with message.
	public void printBooksInGenre(String genre) {
		List<Book> books = getBooksByGenre(genre) ; 
		
		if (books.isEmpty()) {
			System.out.println("No books have been found in" + genre); 
		} else { 
			System.out.println("\n ===" + genre + "Books (" + books.size() + ")===="); 
			books.forEach(System.out::print);
			}	
		}
	
	// 11 - Sorts and prints books in the given genre using the provided comparator.
	public void sortAndPrintGenre(String genre, Comparator<Book> comparator) {
		getBooksByGenre(genre).stream()		
			.sorted(comparator)
			.forEach(System.out ::println); 
		}

// 12- Search by title, ignore case-insensitive . Returns an unmodifiable list of matches.
	public List <Book> searchByTitle(String title){
		return allBooks.stream()
				.filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
				.collect(Collectors.toUnmodifiableList());
			}
	
	// 13- Returns an unmodifiable view of the global set of all books. 
	public Set<Book> getAllBooks(){
		return Collections.unmodifiableSet(allBooks);
		}
// 14 - Handle the protected Map for safe external access. Returns an unmodifiable view. 
	public Map<String, List<Book>> getBooksByGenreMap(){
		return Collections.unmodifiableMap(booksByGenre); 
		}
	
}
