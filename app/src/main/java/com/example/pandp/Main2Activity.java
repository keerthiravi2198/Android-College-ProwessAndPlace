package com.example.pandp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Button sub;
    String string, string2;
    TestAdapter mDbHelper;
    ListView listView;
    Integer i,j;
    Integer qNo = 1;
    ArrayList<Questions> ArrayList;
    QuestionsAdapter Adapter;
    public static Integer answers[] = new Integer[20];
    public static Integer responses[] = new Integer[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDbHelper = new TestAdapter(this);
        Intent intent = getIntent();
        i = intent.getIntExtra("temp", 0);
        j = intent.getIntExtra("temp2", 0);
        help();
        sub = (Button) findViewById(R.id.finalsubmit);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //listView.setVisibility(View.GONE);
                help2();
                int count = listView.getAdapter().getCount();
                int score = 0;
                for(int i = 0; i < count; i++){
                    if(answers[i]==responses[i]){
                        score++;
                    }
                }
                sub.setText("Your Score: " +score+ " / " +count+ " ("+(score*100/count)+"%)");
            }
        });

    }

    public void help2(){

        ArrayList<Questions> ArrayList2 = new ArrayList<Questions>();
        if(i == 0){
            string = "I";
        }
        else if(i == 1){
            string = "W";
        }
        else if(i == 2){
            string = "C";
        }
        else{
            string = "A";
        }
        if(j == 0){
            string2 = "R";
        }
        else if(j == 1){
            string2 = "V";
        }
        else{
            string2 = "A";
        }
        mDbHelper.createDatabase();
        mDbHelper.open();
        Cursor cursor = mDbHelper.getTestData(string, string2);
        try {
            while (cursor.moveToNext()) {
                String Question = cursor.getString(3);
                String optionA = cursor.getString(4);
                String optionB = cursor.getString(5);
                String optionC = cursor.getString(6);
                String optionD = cursor.getString(7);
                Integer answer = cursor.getInt(8);
                ArrayList2.add(new Questions(qNo, Question, optionA, optionB, optionC, optionD, answer));
                qNo++;
            }
            QuestionsAdapter2 Adapter2 = new QuestionsAdapter2(this, ArrayList);
            listView = (ListView) findViewById(R.id.commonView);
            listView.setAdapter(Adapter2);
        } finally {
            cursor.close();
        }
        mDbHelper.close();
    }

    public void help(){

        ArrayList = new ArrayList<Questions>();
        if(i == 0){
            string = "I";
        }
        else if(i == 1){
            string = "W";
        }
        else if(i == 2){
            string = "C";
        }
        else{
            string = "A";
        }
        if(j == 0){
            string2 = "R";
        }
        else if(j == 1){
            string2 = "V";
        }
        else{
            string2 = "A";
        }
        mDbHelper.createDatabase();
        mDbHelper.open();
        Cursor cursor = mDbHelper.getTestData(string, string2);
        try {
            while (cursor.moveToNext()) {
                String Question = cursor.getString(3);
                String optionA = cursor.getString(4);
                String optionB = cursor.getString(5);
                String optionC = cursor.getString(6);
                String optionD = cursor.getString(7);
                Integer answer = cursor.getInt(8);
                ArrayList.add(new Questions(qNo, Question, optionA, optionB, optionC, optionD, answer));
                answers[qNo-1]=answer;
                qNo++;
            }
            Adapter = new QuestionsAdapter(this, ArrayList);
            listView = (ListView) findViewById(R.id.commonView);
            listView.setAdapter(Adapter);
        } finally {
            cursor.close();
        }
        mDbHelper.close();
    }
}
