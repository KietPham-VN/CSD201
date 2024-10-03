/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author mndkh
 */
public class Book {
    private String title;
    private int ID;
    public static int sID = 1000;
    private String author;

    public Book(String title, String author) {
        this.ID = Book.sID++;
        this.author = author;
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getsID() {
        return sID;
    }

    public static void setsID(int sID) {
        Book.sID = sID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return ID + ", " + title + ", " + author;
    }
    
    
    
}
