package main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {
	//Information about each single book:
	int id;
	String title, author, genre;
	LocalDate lastCheckOutDate;
	boolean checkedOut;
	
	//Getters and Setters functions
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
	
	@Override
	public String toString() {
		/* This is supposed to follow the format
		 * {TITLE} By {AUTHOR}
		 * Both the title and author are in uppercase. */
		return title.toUpperCase() + " BY " + author.toUpperCase() + "\n";
	}
	public float calculateFees() {
		//According the rubric today's date is 2023/15/8 + 31 Days (23/15/9).
		LocalDate from31Days = LocalDate.of(2023, 8, 15); 
		long daysPassed = lastCheckOutDate.until(from31Days, ChronoUnit.DAYS);
		
		/* fee (if applicable) = base fee + 1.5 per additional day */
		if(lastCheckOutDate.isAfter(from31Days)) 
			return (float) (10 + 1.5 * ((int)(daysPassed) - 31));
		return 0.0f;
	}
}
