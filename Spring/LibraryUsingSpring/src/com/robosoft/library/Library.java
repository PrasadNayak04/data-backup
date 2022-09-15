package com.robosoft.library;

import java.util.*;

public class Library {

    private String libraryName;
    private Librarian librarian;
    private Clerk clerk;
    private List<Borrower> borrowers;
    private Borrower borrowerObj;

    private List<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.borrowers = new ArrayList<Borrower>();
        this.books = new ArrayList<Book>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
        librarian.setBorrowers(borrowers);
        clerk.setBorrowers(borrowers);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        librarian.setBooks(books);
        clerk.setBooks(books);
        //borrowerObj.setBooks(books);
    }

    public Borrower getBorrowerObj() {
        return borrowerObj;
    }

    public void setBorrowerObj(Borrower borrowerObj) {
        this.borrowerObj = borrowerObj;
    }

    //Searching a book by its title
    public void searchBookByTitle(String name){

        for(Book book : books){
            if(book.getName().equalsIgnoreCase(name)){
                System.out.println("Library found book " + name);
                book.bookDetails();
                System.out.println();
                return;
            }
        }
        System.out.println("Message from Library " + libraryName +  " --> Book not found!!!\n");
    }

    //Display all the borrowers
    public void viewBorrowers(){

        System.out.println("Borrowers History... (Provided by Library)");
        for(Borrower borrower : borrowers){
            System.out.println(borrower.toString());
        }
        System.out.println();
    }

    //Display all the books in the library
    public void viewBooks(){
        System.out.println("Books detail...");
        for(Book book : books){
           book.bookDetails();
        }
        System.out.println();
    }

}
