package com.robosoft.BookManagementSpringBoot.Service;

import com.robosoft.BookManagementSpringBoot.Modal.Book;

import java.util.HashSet;

public interface BookService {
    HashSet<Book> findAllBook();
    Book findBookByID(long id);
    void addBook(Book b);
    void deleteAllData();
}
