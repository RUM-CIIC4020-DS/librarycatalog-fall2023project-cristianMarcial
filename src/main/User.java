package main;

import interfaces.List;

/**
 * This class represent a user from this library. In this class there are 3 fields: Variables, 
 * Constructor, and Getters and Setters. Variable's field have private variables which store 
 * information about the user. Each variable can be obtained with the methods on the "Getters
 * and Setters" (line 39) field and they are initialized by the Constructor method (line 32).
 * 
 * @author Cristian Marcial cristian.marcial@upr.edu
 */
public class User {
	
	//Variables
	
	/**
	 * This holds a Integer ID which represents each user.
	 */
	private int id;
	
	/**
	 * This holds a String representing the name of the user
	 */
	private String name;
	
	/**
	 * List which holds elements of the Book Class.
	 */
	private List<Book> books;
	
	//Constructor
	public User(int id, String name, List<Book> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}
	
	//Getters and Setters
	
	/**
	 * Returns the id of the user.
	 * 
	 * @return an integer representing the id of the user.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id of the user with the given argument.
	 * 
	 * @param id an integer for replacing the previous id of the user.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the name of the user.
	 * 
	 * @return a String which represents the user's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the user with the given argument.
	 * 
	 * @param name a String for replacing the previous user's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns The List of the books which the user has.
	 * 
	 * @return A List of books.
	 */
	public List<Book> getCheckedOutList() {
		return books;
	}
	
	/**
	 * Replace The List of books which the user has with a new one.
	 * 
	 * @param checkedOutList A List of books for replacing the current Book List of the user.
	 */
	public void setCheckedOutList(List<Book> checkedOutList) {
		this.books = checkedOutList;
	}	
}