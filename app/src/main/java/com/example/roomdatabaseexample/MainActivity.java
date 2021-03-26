package com.example.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.roomdatabaseexample.model.Example2;
import com.example.roomdatabaseexample.model.Example3;
import com.example.roomdatabaseexample.model.ExampleModel;
import com.example.roomdatabaseexample.roomDB.dao.ExampleDao;
import com.example.roomdatabaseexample.roomDB.database.RoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoomDatabase roomDatabase = RoomDatabase.getInstance(this);
        ExampleDao exampleDao = roomDatabase.exampleDao();

        List<ExampleModel> example  = new ArrayList<>();

        ExampleModel exampleModel = new ExampleModel();
        Example2 example2 = new Example2();
        example2.setE_ID(1);
        example2.setTitle("ok");
        example2.setSubTitle("prueba");

        Example3 example3 = new Example3();
        example3.setMas("aaaaa");
        List<Example3> example3s = new ArrayList<>();
        example3s.add(example3);

        exampleModel.setName("1");
        exampleModel.setSurname("1");
        exampleModel.setNewName("11");
        exampleModel.setOtro("ok1");
        exampleModel.setExample2(example2);
        exampleModel.setExample3List(example3s);
        example.add(exampleModel);

        ExampleModel exampleModel1 = new ExampleModel();
        Example2 example22 = new Example2();
        example22.setE_ID(2);
        example22.setTitle("ok2");
        example22.setSubTitle("prueba 22");

        Example3 example33 = new Example3();
        example33.setMas("aaaaa");
        List<Example3> example33s = new ArrayList<>();
        example33s.add(example33);

        exampleModel1.setName("2");
        exampleModel1.setSurname("2");
        exampleModel1.setNewName("22");
        exampleModel1.setExample2(example22);
        exampleModel1.setExample3List(example33s);
        exampleModel1.setOtro("ok22");
        example.add(exampleModel1);

        exampleDao.addExampleList(example);

        System.out.println("hola");
    }
}