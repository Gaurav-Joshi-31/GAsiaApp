package com.example.gasia.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.gasia.Utils.TypeConverter1;
import com.example.gasia.Utils.TypeConverter2;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Entity(tableName = "country")
public class Country {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "capital")
    @SerializedName("capital")
    private String capital;

    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    private String flag;

    @ColumnInfo(name = "region")
    @SerializedName("region")
    private String region;

    @ColumnInfo(name = "subregion")
    @SerializedName("subregion")
    private String subregion;

    @ColumnInfo(name = "population")
    @SerializedName("population")
    private int population;

    @ColumnInfo(name = "borders")
    @SerializedName("borders")
    @TypeConverters(TypeConverter1.class)
    private List<String> borders;

    @ColumnInfo(name = "languages")
    @SerializedName("languages")
    @TypeConverters(TypeConverter2.class)
    private List<languages> languages;

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getFlag() {
        return flag;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public int getPopulation() {
        return population;
    }

    public List<String> getBorders() {
        return borders;
    }

    public List<languages> getLanguages() {
        return languages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public void setLanguages(List<com.example.gasia.models.languages> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", flag='" + flag + '\'' +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", population=" + population +
                ", borders=" + borders +
                ", languages=" + languages +
                '}';
    }
}
