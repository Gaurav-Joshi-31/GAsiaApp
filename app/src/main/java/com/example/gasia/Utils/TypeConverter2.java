package com.example.gasia.Utils;
import androidx.room.TypeConverter;

import com.example.gasia.models.languages;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TypeConverter2 {
    @TypeConverter // note this annotation
    public String listtoString(List<languages> languages) {
        Gson gson = new Gson();
        String json = gson.toJson(languages);
        return json;
    }

    @TypeConverter // note this annotation
    public List<languages> stringTolist(String string) {
        Type listType = new TypeToken<List<languages>>() {}.getType();
        return new Gson().fromJson(string, listType);
    }
}
