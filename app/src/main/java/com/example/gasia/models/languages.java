package com.example.gasia.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class languages {
    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }
}
