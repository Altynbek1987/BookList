package com.example.booklist.model;

import java.io.Serializable;

public class BooksModels implements Serializable {
    private String bookName;
    private String bookDesc;

    public BooksModels(String bookName, String bookDesc) {
        this.bookName = bookName;
        this.bookDesc = bookDesc;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }
}
