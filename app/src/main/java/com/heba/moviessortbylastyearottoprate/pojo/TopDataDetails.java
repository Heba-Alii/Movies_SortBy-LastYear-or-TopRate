package com.heba.moviessortbylastyearottoprate.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TopDataDetails implements Serializable {
    private ArrayList<ItemsModel> items;

    public ArrayList<ItemsModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemsModel> items) {
        this.items = items;
    }
}
