package com.example.fyptest;

import java.util.ArrayList;

import Model.listItem;

public class DashboardData {
    private String[] dash_Name = {"My Advisor","Appointments","My Report","Messages","FAQs","Settings"};
    public ArrayList<listItem> itemList() {
        ArrayList<listItem> list = new ArrayList<>();
        for (int i = 0; i < dash_Name.length; i++){
            listItem item = new listItem();
            list.add(item);
        }
        return list;
    }
}
