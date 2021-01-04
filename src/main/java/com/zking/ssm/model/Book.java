package com.zking.ssm.model;

import lombok.ToString;

@ToString
public class Book {
    private Integer bookId;

    private String bookName;

    private Float bookPrice;

    private String bookBrief;

    private Long bookImage;

    public Book(Integer bookId, String bookName, Float bookPrice, String bookBrief,Long bookImage) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookBrief = bookBrief;
        this.bookImage=bookImage;
    }

    public Book() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookBrief() {
        return bookBrief;
    }

    public void setBookBrief(String bookBrief) {
        this.bookBrief = bookBrief;
    }

    public Long getBookImage() {
        return bookImage;
    }

    public void setBookImage(Long bookImage) {
        this.bookImage = bookImage;
    }
}