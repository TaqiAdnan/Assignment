package com.example.assignmentone;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Base {


    private ArrayList<History> list = new ArrayList<>();


    public Base() {

        list.add(new History("United Nations Resolution 181", "1948"));
        list.add(new History("Palestinian Exodus (Nakba)", "1948"));
        list.add(new History("Six-Day War", "1967"));
        list.add(new History("Israeli Occupation of the West Bank and Gaza Strip", "1967"));
        list.add(new History("Jerusalem Divided", "1948"));
        list.add(new History("UN Security Council Resolution 242", "1967"));
        list.add(new History("Oslo Accords", "1994"));
        list.add(new History("Israel-Jordan Peace Treaty", "1994"));

    }


    public ArrayList<History> getEvents(String date) {

        ArrayList<History> events = new ArrayList<>();
        for (History hist : list) {
            if (hist.getDate().equals(date)) {
                events.add(hist);
            }
        }
        return events;
    }
}
