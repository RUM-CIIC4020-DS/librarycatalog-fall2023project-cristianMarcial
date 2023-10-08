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

public class LibraryCatalog {
	private List<Book> catalog = getBooksFromFiles(); //a List of books that this library have
	private List<User> users = getUsersFromFiles(); //a List of the clients of this library
		
	public LibraryCatalog() throws IOException {
		
	}
	
	//Getters and Setters
	private List<Book> getBooksFromFiles() throws IOException {
		List<Book> bookList = new ArrayList<Book>(0); //revise el 0.
		
		BufferedReader line = new BufferedReader (new FileReader("data/catalog.csv"));
		String currentLine = line.readLine(); //Line of the catalog.csv file which is being read.
		line.readLine();
		
        String[] lineSplit = currentLine.split(",", 5); //This divides each element from the line's commas
        String[] ls4 = lineSplit[4].split("-", 2); // the index 4 of line split represents a date separated by 2 "-"
        LocalDate localDate = LocalDate.of(Integer.parseInt(ls4[0]), Integer.parseInt(ls4[1]), Integer.parseInt(ls4[2]));
        boolean checkedOut = Boolean.parseBoolean(lineSplit[4]);
        
		while(line.readLine() != null) { //or currentLine /revise/
			Book addBook = new Book(Integer.parseInt(lineSplit[0]) + 1, lineSplit[1], lineSplit[2], lineSplit[3], localDate, checkedOut);
			bookList.add(addBook);
		} return bookList;
	}
	
	private List<User> getUsersFromFiles() throws IOException {
		return null;
	}
	
	public List<Book> getBookCatalog() {
		return catalog;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void addBook(String title, String author, String genre) {
		Book addedBook = new Book(catalog.size() + 1, title,  author,  genre, LocalDate.of(2023, 9, 15), false);
		catalog.add(addedBook);
	}
	
	public void removeBook(int id) {
		return;
	}	
	
	public boolean checkOutBook(int id) {
		return true;
	}
	
	public boolean returnBook(int id) {
		return true;
	}
	
	public boolean getBookAvailability(int id) {
		return true;
	}
	
	public int bookCount(String title) {
		int count = 0; //This counts how many books of a specified genre are found.
		for(int i = 0; i < catalog.size(); i++) 
			if(catalog.get(i).getGenre()==title) count++;
		return count;
	}
	
	public void generateReport() throws IOException {
		
		String output = "\t\t\t\tREPORT\n\n";
		output += "\t\tSUMMARY OF BOOKS\n";
		output += "GENRE\t\t\t\t\t\tAMOUNT\n";
		/*
		 * In this section you will print the amount of books per category.
		 * 
		 * Place in each parenthesis the specified count. 
		 * 
		 * Note this is NOT a fixed number, you have to calculate it because depending on the 
		 * input data we use the numbers will differ.
		 * 
		 * How you do the count is up to you. You can make a method, use the searchForBooks()
		 * function or just do the count right here.
		 */
		output += "Adventure\t\t\t\t\t" +"("+ bookCount("Adventure") +")"+ "\n"; //*Place here the amount of adventure books*
		output += "Fiction\t\t\t\t\t\t" +"("+ bookCount("Fiction") +")"+ "\n"; //(/*Place here the amount of fiction books*/)
		output += "Classics\t\t\t\t\t" +"("+ bookCount("Classics") +")"+ "\n"; //(/*Place here the amount of classics books*/)
		output += "Mystery\t\t\t\t\t\t" +"("+ bookCount("Mistery") +")"+ "\n"; //(/*Place here the amount of mystery books*/)
		output += "Science Fiction\t\t\t\t\t" +"("+ bookCount("Science Fiction") +")"+ "\n"; //(/*Place here the amount of science fiction books*/)
		output += "====================================================\n";
		output += "\t\t\tTOTAL AMOUNT OF BOOKS\t" +"("+ catalog.size() +")"+ "\n\n"; //(/*Place here the total number of books*/)
		
		/* * This part prints the books that are currently checked out */
		output += "\t\t\tBOOKS CURRENTLY CHECKED OUT\n\n";
		/*
		 * Here you will print each individual book that is checked out.
		 * 
		 * Remember that the book has a toString() method. 
		 * Notice if it was implemented correctly it should print the books in the 
		 * expected format.
		 * 
		 * PLACE CODE HERE
		 */
		
		int checkedOutCounter = 0;
		for(int i = 0; i < getBookCatalog().size(); i++) 
			if(catalog.get(i).isCheckedOut()) {
				output += catalog.get(i).toString() + "\n";
				checkedOutCounter++;
			}
		
		output += "====================================================\n";
		output += "\t\t\tTOTAL AMOUNT OF BOOKS\t" +"("+ checkedOutCounter +")"+ "\n\n"; // (/*Place here the total number of books that are checked out*/) +
		
		
		/*
		 * Here we will print the users the owe money.
		 */
		output += "\n\n\t\tUSERS THAT OWE BOOK FEES\n\n";
		/*
		 * Here you will print all the users that owe money.
		 * The amount will be calculating taking into account 
		 * all the books that have late fees.
		 * 
		 * For example if user Jane Doe has 3 books and 2 of them have late fees.
		 * Say book 1 has $10 in fees and book 2 has $78 in fees.
		 * 
		 * You would print: Jane Doe\t\t\t\t\t$88.00
		 * 
		 * Notice that we place 5 tabs between the name and fee and 
		 * the fee should have 2 decimal places.
		 * 
		 * PLACE CODE HERE!
		 */

			
		output += "====================================================\n";
		output += "\t\t\t\tTOTAL DUE\t$" + " ... " + "\n\n\n"; // (/*Place here the total amount of money owed to the library.*/) 
		output += "\n\n";
		System.out.println(output);// You can use this for testing to see if the report is as expected.
		
		/*
		 * Here we will write to the file. 
		 * The variable output has all the content we need to write to the report file.
		 * PLACE CODE HERE!!
		 */
		
	}
	
	/*
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