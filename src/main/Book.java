package main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * In this class there are 4 fields: Variables, Constructor, Getters and Setters, and General 
 * Methods.
 * 
 * The Variables field have private variables which store information about the books. The variable
 * "id" holds a Integer ID which represents every book; the variables "title", "author" &
 * "genre" hold a String representing the title, author and genre of each book; the variable
 * "lastCheckOutDate", by using the LocalDate Class, holds the last date where someone borrowed 
 * the book; and the variable "checkedOut" is a boolean which represent if the book has been
 * checked out (This status can be changed with functions at the LibraryCatalog Class such as
 * checkOutBook function).
 * 
 * Each variable can be obtained and changed with the functions on the "Getters and
 * Setters" (line 39) field and they are initialized by the Constructor function (line 29).
 * 
 * @author  Cristian Marcial cristian.marcial@upr.edu
 */
public class Book {
	
	//Variables
	private int id;
	private String title, author, genre;
	private LocalDate lastCheckOutDate;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getLastCheckOut() {
		return lastCheckOutDate;
	}
	public void setLastCheckOut(LocalDate lastCheckOut) {
		this.lastCheckOutDate = lastCheckOut;
	}
	public boolean isCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	//General Functions
	
	
	
	@Override
	public String toString() {
		/**
		 * This is supposed to follow the format: {TITLE} By {AUTHOR}
		 * Both the title and author are in uppercase.
		 */
		return title.toUpperCase() + " BY " + author.toUpperCase();
	}
	
	public float calculateFees() { 
		
		/**
		 * This variable counts the days between today's date and the last date where
		 * someone borrowed the book, which is represented by the variable "lastCheckedOutDate".
		 */
		long daysPassed = lastCheckOutDate.until(LocalDate.of(2023, 9, 15), ChronoUnit.DAYS);
		
		/* 
		 * fee (if applicable) = base fee + 1.5 per additional day 
		 * According the rubric, today's date is 2023/16/8 + 31 days == (23/15/9).
		 */
		if(lastCheckOutDate.isBefore(LocalDate.of(2023, 8, 16))) 
			return (float) (10 + 1.5 * ((int)(daysPassed) - 31));
		return 0.0f;
	}
}
