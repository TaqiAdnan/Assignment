package com.example.assignmentone;

public class History {

    private String event;
    private String date;


    public History(String event, String date) {
        this.event = event;
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
            return getEvent() ;
    }
}
