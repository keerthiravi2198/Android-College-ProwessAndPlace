package com.example.pandp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button msubmit;
    Spinner a,b;
    Integer company, item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (Spinner) findViewById(R.id.company);
        b = (Spinner) findViewById(R.id.type);
        msubmit = (Button) findViewById(R.id.button);
        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                company = a.getSelectedItemPosition();
                item = b.getSelectedItemPosition();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("temp", company);
                intent.putExtra("temp2", item);
                startActivity(intent);
            }
        });
    }
}
