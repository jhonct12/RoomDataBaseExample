package com.example.roomdatabaseexample.roomDB.database;

import androidx.room.TypeConverter;

import com.example.roomdatabaseexample.model.Example3;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DatabaseConverters {

    @TypeConverter
    public static List<Example3> toJavaListExample3(String example3) {
        if (example3 == null || example3.trim().equals("")) {
            return new ArrayList<>();
        }
        Type listType = new TypeToken<List<Example3>>() {}.getType();
        return new Gson().fromJson(example3, listType);
    }

    @TypeConverter
    public static String toStringExample3(List<Example3> example3List) {
        Gson gson = new Gson();
        String json = gson.toJson(example3List);
        return json;
    }


}
