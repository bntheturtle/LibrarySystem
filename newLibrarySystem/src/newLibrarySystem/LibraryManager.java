package newLibrarySystem;


	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.List;
	import java.util.Map;

	// Parent extends attribute to the child class. 
	public class LibraryManager extends LibrarySystem  {
		
		
		
		// 6 - 
		public void loadFromAFile(String filename) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
				String line; 
				while((line = reader.readLine()) != null) {
					String [] parts = line.split("\\|"); 
					if (parts.length !=2) continue; 
					
					String genre = parts[0].trim(); 
					String [] bookParts = parts[1].split("/"); 
					if (bookParts.length !=3 )continue; 
					
					String title = bookParts[0].trim(); 
					String author = bookParts[1].trim(); 
					int year = Integer.parseInt(bookParts[2].trim()) ; 
					
					 addBook(genre, new Book(title, author, year)); 
				}
				System.out.println("Library loaded from : " + filename);
				
			}catch ( IOException | NumberFormatException e ) {
				System.err.println("Failed to load the file " + filename + e.getMessage()); 
				e.printStackTrace(); 
			}
			
		}

		// 7 - 
		public void saveToFile(String filename) {
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
				for(Map.Entry<String, List<Book>> entry: booksByGenre.entrySet()) {
				String genre = entry.getKey();
				for(Book book : entry.getValue()) {
					writer.write(genre + " | " + book.toString());
					writer.newLine();
				}		
			}
				System.out.println("Library saved to : " + filename);	
			
			}catch (IOException e) {
				System.err.println("Error saving file " + e.getMessage()); 
			}
		}
		
		
	}


