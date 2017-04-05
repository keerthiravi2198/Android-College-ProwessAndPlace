package com.example.pandp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    RadioButton a;
    RadioButton r;
    String string;
    TestAdapter mDbHelper;
    Integer i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDbHelper = new TestAdapter(this);
        Intent intent = getIntent();
        i = intent.getIntExtra("temp", 0);
        help();
    }

    public void help(){

        ArrayList<Questions> ArrayList = new ArrayList<Questions>();
        if(i == 0){
            string = "A";
        }
        if(i == 1){
            string = "R";
        }
        mDbHelper.createDatabase();
        mDbHelper.open();
        int i =0;
        Cursor cursor = mDbHelper.getTestData(string);
        try {
            while (cursor.moveToNext()) {
                String Question = cursor.getString(2);
                String optionA = cursor.getString(3);
                String optionB = cursor.getString(4);
                String optionC = cursor.getString(5);
                String optionD = cursor.getString(6);
                ArrayList.add(new Questions(Question, optionA, optionB, optionC, optionD));
                Log.i("cursor", "Passed" + i);
            }
            QuestionsAdapter Adapter = new QuestionsAdapter(this, ArrayList);
            ListView listView = (ListView) findViewById(R.id.commonView);
            listView.setAdapter(Adapter);
        } finally {

            cursor.close();
        }
        mDbHelper.close();
    }
}
