package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import data_structures.ArrayList;
import data_structures.DoublyLinkedList;
import data_structures.SinglyLinkedList;
import interfaces.FilterFunction;
import interfaces.List;

/**
 * This class manages all the books in the catalog and any operation related to them. This make use of the ArrayList
 * Class to store in two private variables the user list (users) and the book list (catalog) written in the files from 
 * the data folder. This files are loaded and then stored in their respective variables by two separated methods: 
 * getBookFromFiles() and getUsersFromFiles(). In order to realize this action, the BufferedReader Class is used. Finally,
 * when they are already stored, a report about the library and its books is written in a separated text file called 
 * "report.txt" placed on the "report" folder; in order to do this, the BufferedWrite Class was used.
 * 
 * @author Cristian Marcial cristian.marcial@upr.edu
 */
public class LibraryCatalog {
	
	/**
	 * List of books that this library have.
	 */
	private List<Book> catalog = getBooksFromFiles();
	
	/**
	 * List of the clients of this library.
	 */
	private List<User> users = getUsersFromFiles(); 
	
	//Constructor
	public LibraryCatalog() throws IOException {}
	
	//Getters, Setters and other general methods
	
	/**
	 * This method will read the file catalog.csv in the data folder and then it will generate a Book ArrayList 
	 * which it is going to be returned; the Book ArrayList contains the books of the library. An ArrayList was 
	 * used to hold the books since it was only used the add() member method of the ArrayList to put the books on
	 * it, and that satisfy what it is needed to have all the books from the file.
	 * 
	 * @return "bookList" variable which is the Book ArrayList generated.
	 */
	private List<Book> getBooksFromFiles() throws IOException {
		
		/**
		 * This is a ArrayList that contains all Books from catalog.csv 
		 */
		List<Book> bookList = new ArrayList<Book>(); 
		
		/**
		 * This section inside the getBooksFromFiles method have a collection of variables which divides
		 * the lines of the document which is being read. the variable "line" loads the documents itself making use of
		 * the BufferedReader class. The variable "currentLine" is the line which is currently being iterated by the 
		 * while loop below.
		 */
		BufferedReader line = new BufferedReader(new FileReader("data/catalog.csv"));
		String currentLine;
		line.readLine(); //The first line don't represent a book, so is iterated before the following loop starts.
        
		/**
		 * This while loop iterates through every line until reaches the end of the document (which there is no more lines,
		 * so currentLine is null). Inside of it, there is the variable "lineSplit", which divides "currentLine" variable from
		 * the line's commas in order to have each book parameters in separated strings inside a String Array. The fifty 
		 * parameter of the book Class have a date, which in the document it is separated by 2 "-" so lineSplit[4] has to be 
		 * split in a String Array of 3 indexes called "ls4" which its 3 indexes represent a year, a month and a day.
		 */
		while((currentLine = line.readLine()) != null) { 
	        String[] lineSplit = currentLine.split(",", 6); 
	        String[] ls4 = lineSplit[4].split("-", 3); 
	        
	        /**
	         * The 3 indexes of "ls4" String Array represent a year, month and a day, so they are passed to the variable
	         * "localDate" which makes use of the LocalDate Class to be passed as a argument in the addBook variable.
	         */
	        LocalDate localDate = LocalDate.of(Integer.parseInt(ls4[0]), Integer.parseInt(ls4[1]), Integer.parseInt(ls4[2]));
	        boolean checkedOut = Boolean.parseBoolean(lineSplit[5]);
	        
			Book addBook = new Book(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2], lineSplit[3], localDate, checkedOut);
			bookList.add(addBook);
		} 
		return bookList;
	}
	
	/**
	 * This method will read the file users.csv in the data folder and then it will generate a User ArrayList which its 
	 * going to be returned. the User ArrayList contains the books of the library. An ArrayList was used to hold the users
	 * since it was only used the add() member method of the ArrayList to place the users on it, and that satisfy what it is
	 * needed to have all the user from the file.
	 * 
	 * @return "userList" variable which is the User ArrayList generated.
	 */
	private List<User> getUsersFromFiles() throws IOException {
		List<User> userList = new ArrayList<User>();
		
		/**
		 * Like in the previous method, this section inside the getUsersFromFiles method have variables which divides
		 * the lines of the document which is being read. the variable "line" loads the documents itself making use of
		 * the BufferedReader class. The variable "currentLine" is the line which is currently being iterated by the 
		 * while loop below.
		 */
		BufferedReader line = new BufferedReader (new FileReader("data/user.csv"));
		String currentLine;
		line.readLine();
		
		/*
		 * This while loop iterates through every line until reaches the end of the document. Inside of it there is the 
		 * variable "lineSplit", which divides "currentLine" variable from the line's commas in order to have each user 
		 * parameters in separated strings inside a String Array.
		 */
		while((currentLine = line.readLine()) != null) { //or currentLine /revise/
	        String[] lineSplit = currentLine.split(",");
	        List<Book> books = new ArrayList<Book>();
	        
	        /**
	         * If a user have books, it has a third field in its respective document separated by a third comma. This third
	         * field have the id's of the books which the user has and they have to be passed to The Book ArrayList "books".
	         */
	        if(lineSplit.length > 2) {
	        	String ls = lineSplit[2].replaceAll("\\{", ""); // The index 2 of line split represents the books id surrounded by "{}".
	        	String lsB = ls.replaceAll("}", ""); 
	        	String[] ls2 = lsB.split(" "); //This divides the books surrounded by "{}" using the spaces.
		        
		        /*
		         * This for loop search for the books that the user have
		         */
	        	for(int j = 0; j < ls2.length; j++)
		        	books.add(catalog.get( Integer.parseInt(ls2[j])-1 ));
	        }
	        
			User addUser = new User(Integer.parseInt(lineSplit[0]), lineSplit[1], books);
			userList.add(addUser);
		} 
		return userList;
	}
	
	/**
	 * Returns the value held in the private variable "catalog".
	 * 
	 * @return A Book ArrayList held in the "catalog" variable.
	 */
	public List<Book> getBookCatalog() {
		return catalog;
	}
	
	/**
	 * Returns the value held in the private variable "users".
	 * 
	 * @return A User ArrayList held in the "users" variable.
	 */
	public List<User> getUsers() {
		return users;
	}
	
	/**
	 * Adds a Book with a given title, author and genre on the last index of the Book ArrayList held in the private 
	 * variable "catalog", assigning to each added book an index based on their index position in the ArrayList. It 
	 * is also assigned to each book today's date (September 9, 2023) as its last checked out date and its assumed 
	 * that the book is not checked out.
	 * 
	 * @param title String representing the title of the added book.
	 * @param author String representing the author of the added book.
	 * @param genre String representing the genre of the added book.
	 */
	public void addBook(String title, String author, String genre) {
		Book addedBook = new Book(catalog.size() + 1, title,  author,  genre, LocalDate.of(2023, 9, 15), false);
		catalog.add(addedBook);
	}
	
	/** 
	 * Removes from the Book ArrayList "catalog" a book with a specified id. The books are sorted in ascending order
	 * so the index position of a book with a specific id is its id minus 1.
	 *
	 * @param id id of the book which is going to be removed.
	 */
	public void removeBook(int id) {
		catalog.remove(id-1);
	}	
	
	/**
	 * Takes a book of a specific id and checks out it if it is not already checked out. It turns true its checked 
	 * out status and updates the checkout date to today’s (September 15, 2023).
	 * 
	 * @param id the id of the book which it is going to be checked out.
	 * @return true if the book was check out and false if its checked out status was already true  or it does not 
	 * even exist in the catalog.
	 */
	public boolean checkOutBook(int id) {
		if(catalog.get(id-1)!=null) {
			if(!catalog.get(id-1).isCheckedOut()) {
				catalog.get(id-1).setLastCheckOut(LocalDate.of(2023, 9, 15));
				return true;
			}
		} return false;
	}
	
	/**
	 * Returns a book from this library if it is not already returned and changes its checked out status to false.
	 * 
	 * @param id the id of the book which it is going to be returned.
	 * @return true if the book was successfully returned and false if its checked out status was false or it
	 * does not even exist in the catalog.
	 */
	public boolean returnBook(int id) {
		if(catalog.get(id-1)!=null) {
			if(catalog.get(id-1).isCheckedOut()) {
				catalog.get(id-1).setCheckedOut(false);
				return true;
			} 
		} return false;
	}
	
	/**
	 * Returns whether a book of a specified id is available for being checked out.
	 * 
	 * @param id the id of the book which its availability of being checked out is going to be evaluated.
	 * @return true if the book has not been checked out, else it returns false.
	 */
	public boolean getBookAvailability(int id) {
		return !catalog.get(id-1).isCheckedOut();
	}
	
	/**
	 * Returns how many books of a specified title are present in the catalog.
	 * 
	 * @param title string which is being searched how many books have it as a title.
	 * @return number of how many books with a specific title are found.
	 */
	public int bookCount(String title) {
		int count = 0; //This counts how many books of a specified title are found.
		for(int i = 0; i < catalog.size(); i++) 
			if(catalog.get(i).getTitle().equals(title)) count++;
		return count;
	}
	
	/**
	 * Returns how many books of a specified genre are present in the catalog.
	 * 
	 * @param genre string which is being searched how many books have it as its genre.
	 * @return number of how many books with a specific genre are found.
	 */
	public int bookGenreCount(String genre) {
		int count = 0; //This counts how many books of a specified genre are found.
		for(int i = 0; i < catalog.size(); i++) 
			if(catalog.get(i).getGenre().equals(genre)) count++;
		return count;
	}
	
	/**
	 * Store in a string called output a report about the content which is currently in the library. Later, 
	 * the content of the output variable is displayed in a text file called report.txt; the content of it 
	 * is written by making use of the BufferedWrite Class.
	 */
	public void generateReport() throws IOException {
		
		String output = "\t\t\t\tREPORT\n\n";
		output += "\t\tSUMMARY OF BOOKS\n";
		output += "GENRE\t\t\t\t\t\tAMOUNT\n";
		
		/**
		 * In this field it will be printed the amount of books per category.
		 */
		output += "Adventure\t\t\t\t\t" + bookGenreCount("Adventure") + "\n"; 
		output += "Fiction\t\t\t\t\t\t" + bookGenreCount("Fiction") + "\n"; 
		output += "Classics\t\t\t\t\t" + bookGenreCount("Classics") + "\n"; 
		output += "Mystery\t\t\t\t\t\t" + bookGenreCount("Mystery") + "\n"; 
		output += "Science Fiction\t\t\t\t\t" + bookGenreCount("Science Fiction") + "\n";
		output += "====================================================\n";
		output += "\t\t\tTOTAL AMOUNT OF BOOKS\t" + catalog.size() + "\n\n";
		
		output += "\t\t\tBOOKS CURRENTLY CHECKED OUT\n\n";
		
		/**
		 * Here it will be printed each individual book that is checked out.
		 */
		int checkedOutCounter = 0;
		for(int i = 0; i < getBookCatalog().size(); i++) 
			if(catalog.get(i).isCheckedOut()) {
				output += catalog.get(i).toString() + "\n";
				checkedOutCounter++;
			}
		
		output += "====================================================\n";
		output += "\t\t\tTOTAL AMOUNT OF BOOKS\t" + checkedOutCounter + "\n\n";
		
		
		output += "\n\n\t\tUSERS THAT OWE BOOK FEES\n\n";
		
		/**
		 * Sum of all fees of each user.
		 */
		float totalDue = 0.0f;
		
		/**
		 * Here it will be printed all the users that owe money. The amount will be calculating taking 
		 * into account all the books that have late fees.
		 */
		for(int i = 0; i < getUsers().size(); i++) {
			float fee = 0.0f;
			List<Book> currentBookList = getUsers().get(i).getCheckedOutList();
			
			if(currentBookList.size()>0) {
				for(int j = 0; j < currentBookList.size(); j++) 
					fee += currentBookList.get(j).calculateFees();
				if(fee > 0) 
					output += getUsers().get(i).getName() + "\t\t\t\t\t" + "$" + String.format("%.2f",fee) + "\n";
				totalDue+=fee;
			}
		}
			
		output += "====================================================\n";
		
		/**
		 * Total amount of money owed to the library. 
		 */
		output += "\t\t\t\tTOTAL DUE\t$" + String.format("%.2f",totalDue) + "\n\n\n"; 
		output += "\n\n";
		
		/**
		 * Here it will be written to the file "report.txt" in the "/report" folder.
		 * The variable output has all the content needed to write to the report file.
		 */
        try {
            BufferedWriter outputText = new BufferedWriter(new FileWriter("report/report.txt")); // Initializing file
            outputText.write(output); //Writing on it
            outputText.close(); // Closing file
        } catch (IOException except) { except.printStackTrace(); }
	}
	
	/**
	 * BONUS Methods
	 * You are not required to implement these, but they can be useful for
	 * other parts of the project.
	 */
	public List<Book> searchForBook(FilterFunction<Book> func) {
		return null;
	}
	
	public List<User> searchForUsers(FilterFunction<User> func) {
		return null;
	}
}