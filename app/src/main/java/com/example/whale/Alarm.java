package com.example.whale;

public class Alarm {
    private String date;
    private String time;

    private Alarm() {

    }

    public Alarm(String date, String time){
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
