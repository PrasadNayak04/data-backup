package com.robosoft.library;

import java.util.List;

public class Clerk implements User{

    private int id;
    private String name;
    public List<Book> books;

    private List<Borrower> borrowers;

    public Clerk(int id, String name) {
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

    public void searchBookByTitle(String name){
        for(Book book : books){
            if(book.getName().equalsIgnoreCase(name)){
                System.out.println("Client found book " + name);
                book.bookDetails();
                System.out.println();
                return;
            }
        }
        System.out.println("Message from Clerk " + this.name +  " --> Book not found!!!\n");
    }

    public void viewBorrowers(){

        System.out.println("Borrowers History... (Provided by Client)");
        for(Borrower borrower : borrowers){
            System.out.println(borrower.toString());
        }
        System.out.println();
    }

}
