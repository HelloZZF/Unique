package com.unique.bean;

/**
 * Created by zzf on 2018/5/21.
 */
public class Teacher {

    private int icon;
    private String name;
    private String introduce;
    private String time;

    public Teacher(int icon, String name, String introduce, String time) {
        this.icon = icon;
        this.name = name;
        this.introduce = introduce;
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
