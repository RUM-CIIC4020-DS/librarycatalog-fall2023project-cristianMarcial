package main;

import interfaces.List;

/**
 * In this class there are 3 fields: Variables, Constructor, and Getters and Setters.
 * 
 * This field have private variables which store information about the user. The variable
 * "id" holds a Integer ID which represents every user, the variable "name" holds a String 
 * representing the name of the user and the variable "books" is a List which holds elements
 * of the Book Class. Each variable can be obtained with the functions on the "Getters and
 * Setters"(line 28) field and they are initialized by the Constructor function (line 21).
 * 
 * @author Cristian Marcial cristian.marcial@upr.edu
 */
public class User {
	
	//Variables
	private int id;
	private String name;
	private List<Book> books;
	
	//Constructor
	public User(int id, String name, List<Book> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getCheckedOutList() {
		return books;
	}
	public void setCheckedOutList(List<Book> checkedOutList) {
		this.books = checkedOutList;
	}	
}