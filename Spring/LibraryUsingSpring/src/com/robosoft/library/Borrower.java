package com.robosoft.library;

import java.time.LocalDate;
import java.util.List;

public class Borrower implements User{

    private int id;
    private String name;
    private String borrowedBook;
    private LocalDate borrowDate;
    public List<Book> books;

    public Borrower(int id, String name, String borrowedBook) {
        this.id = id;
        this.name = name;
        this.borrowedBook = borrowedBook;
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

    public String getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(String borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //Searching book by title
    public void searchBookByTitle(String name){
        for(Book book : books){
            if(book.getName().equalsIgnoreCase(name)){
                System.out.println("Borrower found book " + name);
                book.bookDetails();
                System.out.println();
                return;
            }
        }
        System.out.println("Message from Borrower " + this.name +  " --> Book not found!!!");
    }

    @Override
    public String toString() {
        return "Id=" + id +
                ", Name='" + name + '\'' +
                ", BorrowedBook='" + borrowedBook + '\'' +
                ", BorrowDate=" + borrowDate +
                ", Books=" + books;
    }


}
