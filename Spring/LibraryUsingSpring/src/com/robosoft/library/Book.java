package com.robosoft.library;

public class Book {
    private String name;
    private String authorNme;

    public Book(String name, String authorNme) {
        this.name = name;
        this.authorNme = authorNme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorNme() {
        return authorNme;
    }

    public void setAuthorNme(String authorNme) {
        this.authorNme = authorNme;
    }

    public void bookDetails(){
        System.out.println("Book name : " + name + " .....Written By : " + authorNme);
    }
}
