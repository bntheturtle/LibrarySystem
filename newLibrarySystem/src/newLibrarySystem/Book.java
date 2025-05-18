package newLibrarySystem;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable{
	

	private static final long serialVersionUID = 1L; 
	protected final String title; 
	protected final String author; 
	protected final int publicationYear ;
	
	
	// 1 -  
	public Book (String title, String author, int year ) {
		this.title = Objects.requireNonNull(title, "title cannot be null " ) ; 
		this.author = Objects.requireNonNull(author,"author cannot be null") ; 
		if (year <= 0) {
			throw new IllegalArgumentException ("Publication year must be positive"); 
			}	
		this.publicationYear = year; 

			}
	
	// 2 - 
	public String getTitle() {	return title; }
	
	public String getAuthor() {	return author ; }
	
	public int getPublicationYear() { return publicationYear; }
	
	
	// 3 - 
	 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
               title.equals(book.title) &&
               author.equals(book.author);
    }

	 // 4 -  
    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }

    // 5 - 
    @Override
    public String toString() {
        return String.format("%s by %s (%d)", title, author, publicationYear);
    }

	}

