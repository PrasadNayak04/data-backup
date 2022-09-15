package com.robosoft.library;

import java.util.ArrayList;
import java.util.List;

public class Librarian implements User{

    private int id;
    private String name;
    private List<Book> books;
    private List<Borrower> borrowers;

    public Librarian(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    //Search book by title
    public void searchBookByTitle(String name){
        for(Book book : books){
            if(book.getName().equalsIgnoreCase(name)){
                System.out.println("Librarian found book " + name);
                book.bookDetails();
                System.out.println();
                return;
            }
        }
        System.out.println("Message from Librarian " + this.name +  " --> Book not found!!!\n");
    }

    //View all the borrowers
    public void viewBorrowers(){

        System.out.println("Borrowers History... (Provided by Librarian)");
        for(Borrower borrower : borrowers){
            System.out.println(borrower.toString());
        }
        System.out.println();
    }




}
