package main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * This class represent a single book in this library. In this class there are 4 fields: 
 * Variables, Constructor, Getters and Setters, and General Methods. The Variable's field 
 * have private variables which store information about the books. Each variable can be 
 * obtained and changed with the methods on the "Getters and Setters" (line 51) field and 
 * they are initialized by the constructor method (line 41).
 * 
 * @author Cristian Marcial cristian.marcial@upr.edu
 */
public class Book {
	
	//Variables
	
	/**
	 * This holds a Integer ID which identifies every book in the catalog 
	 */
	private int id;
	
	/**
	 * The variables "title", "author" & "genre" hold a String representing the title, 
	 * author and genre of each book.
	 */
	private String title, author, genre;
	
	/**
	 * By using the LocalDate Class, this holds the last date where someone borrowed the book.
	 */
	private LocalDate lastCheckOutDate;
	
	/**
	 * This is a boolean which represent if the book has been checked out (This status can 
	 * be changed with methods at the LibraryCatalog Class such as checkOutBook method).
	 */
	private boolean checkedOut;
	
	//Constructor
	public Book(int id, String title, String author, String genre, LocalDate lastCheckOutDate, boolean checkedOut) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.lastCheckOutDate = lastCheckOutDate;
		this.checkedOut = checkedOut;
	}
	
	//Getters and Setters
	
	/**
	 * Returns the id of the book.
	 * 
	 * @return an integer representing the id of the book.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id of the book with the given argument.
	 * 
	 * @param id an integer for replacing the previous id of the book.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the value held in the private variable of its class "title".
	 * 
	 * @return a String held in the "title" variable.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the value of the variable "title" with the given argument.
	 * 
	 * @param title a String for replacing the value held in the variable "title".
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns the value held in the private variable of its class "author".
	 * 
	 * @return a String held in the "author" variable.
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the value of the variable "author" with the given argument.
	 * 
	 * @param author a String for replacing the value held in the variable "author".
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Returns the value held in the private variable of its class "genre".
	 * 
	 * @return a String held in the "genre" variable.
	 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * Sets the genre of the book with the given argument.
	 * 
	 * @param genre a String for replacing the previous genre which the book belonged.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * Returns the value held in the private variable of its class "lastCheckOutDate".
	 * 
	 * @return a value of LocalDate Class held in the "lastCheckOutDate" variable.
	 */
	public LocalDate getLastCheckOut() {
		return lastCheckOutDate;
	}
	
	/**
	 * Sets the value of the variable "lastCheckOutDate" with the given argument.
	 * 
	 * @param lastCheckOut a value of LocalDate Class for replacing the previous last checked out date.
	 */
	public void setLastCheckOut(LocalDate lastCheckOut) {
		this.lastCheckOutDate = lastCheckOut;
	}
	
	/**
	 * Checks if the book was checked out or not.
	 * 
	 * @return checked out status of the book.
	 */
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	/**
	 * Sets the value of the variable "checkedOut" with the given argument.
	 * 
	 * @param checkedOut a boolean for replacing the value held in the variable "checkedOut".
	 */
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	//General Methods
	
	/**
	 * This method overrides the toString method and returns the information of the book
	 * in a String in the format: {TITLE} By {AUTHOR}. {TITLE} represents the String held 
	 * in the variable "title" and {AUTHOR} represents the String held in the variable 
	 * "author". Both Strings are returned in capital letters.
	 * 
	 * @return title and author of the book.
	 */
	@Override
	public String toString() {
		return title.toUpperCase() + " BY " + author.toUpperCase();
	}
	
	/**
	 * Returns how much money is owed in late fees. The fee is calculated taking account how many 
	 * days has been passed since the last check out date. If the book has been checked out for 31 
	 * days or more then the base fee is $10.00. Then an added $1.50 is owed per day passed 31.
	 * 
	 * @return the calculated fee
	 */
	public float calculateFees() { 
		
		/**
		 * This counts the days between today's date and the last date where someone borrowed the book,
		 * which is represented by the variable "lastCheckedOutDate".
		 */
		long daysPassed = lastCheckOutDate.until(LocalDate.of(2023, 9, 15), ChronoUnit.DAYS);
		
		/**
		 * fee (if applicable) = base fee + 1.5 per additional day
		 * According the rubric, today's date is 2023/16/8 + 31 days == (23/15/9).
		 */
		if(lastCheckOutDate.isBefore(LocalDate.of(2023, 8, 16))) 
			return (float) (10 + 1.5 * ((int)(daysPassed) - 31));
		return 0.0f;
	}
}
