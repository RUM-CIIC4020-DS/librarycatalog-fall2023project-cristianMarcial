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
	 * This holds a Integer ID which represents every user.
	 */
	private int id;
	
	/**
	 * This holds a String representing the name of the user
	 */
	private String name;
	
	/**
	 * This is a List which holds elements of the Book Class.
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
	 * Returns the value held in the private variable of its class "id".
	 * 
	 * @return the id of the book held in the variable "id".
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the value of the local variable "id" with the given argument.
	 * 
	 * @param id an integer for replacing the value held in the variable "id".
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the value held in the private variable of its class "name".
	 * 
	 * @return a String held in the variable "name".
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of the local variable "name" with the given argument.
	 * 
	 * @param name a String for replacing the value held in the variable "name".
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns The List held in the private variable of its class "book".
	 * 
	 * @return A List held in the "books" variable.
	 */
	public List<Book> getCheckedOutList() {
		return books;
	}
	
	/**
	 * Replace The List of the local variable "books" with the given argument.
	 * 
	 * @param checkedOutList A List for replacing the value held in the variable "books".
	 */
	public void setCheckedOutList(List<Book> checkedOutList) {
		this.books = checkedOutList;
	}	
}