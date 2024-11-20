package com.tushar;

class Book {
    String name;
    String id;
    String author;
    double price;
    int rating;

    public Book(String name, String id, String author, double price, int rating) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.price = price;
        this.rating = rating;
    }
    

    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public void displayBook() {
        System.out.println("\nBook Name: " + name);
        System.out.println("Book ID: " + id);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Rating: " + rating);
        System.out.println("-------------------------------------------");
    }
}