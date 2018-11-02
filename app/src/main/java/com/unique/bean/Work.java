package com.unique.bean;

/**
 * Created by zzf on 2018/5/15.
 */
public class Work {

    private int imageurl;
    private String name;
    private String author;
    private String introduce;

    public Work(String name, String author, String introduce, int imageurl) {
        this.name = name;
        this.author = author;
        this.introduce = introduce;
        this.imageurl = imageurl;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
