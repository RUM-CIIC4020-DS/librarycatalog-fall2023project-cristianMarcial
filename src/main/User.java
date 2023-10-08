package main;

import interfaces.List;

public class User {
	int id;
	String name;
	List<Book> books;
	
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
		return null;
	}

	public void setCheckedOutList(List<Book> checkedOutList) {
	
	}
	
}
