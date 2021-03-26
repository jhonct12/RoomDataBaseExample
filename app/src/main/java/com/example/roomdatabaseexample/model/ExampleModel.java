package com.example.roomdatabaseexample.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "example")
public class ExampleModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer ID_Example;
    private String name;
    private String surname;
    private String newName;
    private String otro;

    @Embedded(prefix = "example2")
    private Example2 example2;

    private List<Example3> example3List;

    public Integer getID_Example() {
        return ID_Example;
    }

    public void setID_Example(Integer ID_Example) {
        this.ID_Example = ID_Example;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public Example2 getExample2() {
        return example2;
    }

    public void setExample2(Example2 example2) {
        this.example2 = example2;
    }

    public List<Example3> getExample3List() {
        return example3List;
    }

    public void setExample3List(List<Example3> example3List) {
        this.example3List = example3List;
    }
}
