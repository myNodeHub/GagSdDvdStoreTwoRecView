package com.example.gagsddvdstoretworecview;

import java.util.ArrayList;

public class Items {
    private String name;
    private ArrayList<Item> item;
    private boolean expanded;

    public Items(String name, ArrayList<Item> item) {
        this.name = name;
        this.item = item;
    }

    public Items() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", item=" + item +
                ", expanded=" + expanded +
                '}';
    }
}
