package com.example.roomdatabaseexample.roomDB.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomdatabaseexample.model.ExampleModel;

import java.util.List;

@Dao
public abstract class ExampleDao {

    @Query("delete from example")
    public  abstract void deleteAllExample();

    @Query("select * from example")
    public  abstract List<ExampleModel> getAllExample();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public  abstract void addExampleList(List<ExampleModel> exampleModelList);
}
