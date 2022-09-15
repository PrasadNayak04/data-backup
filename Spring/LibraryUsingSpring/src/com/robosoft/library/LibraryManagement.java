package com.robosoft.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Library library = (Library)context.getBean("library");

        library.viewBorrowers();                     //display borrowers using Library
        library.getLibrarian().viewBorrowers();      //display borrowers using Librian
        library.getClerk().viewBorrowers();          //display borrowers using Clerk


        library.viewBooks();                         //display books in the library

        library.searchBookByTitle("Thunthuru");                      //Libray searching books by title
        library.getLibrarian().searchBookByTitle("Thunthuru1");      //Librian searching books by title
        library.getClerk().searchBookByTitle("Thunthuru2");         //Clerk searching books by title
       //library.getBorrowerObj().searchBookByTitle("Thunthuru1");    //Borrower searching books by title

        context.close();
    }

}
