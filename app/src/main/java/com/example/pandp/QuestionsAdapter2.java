package com.example.pandp;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionsAdapter2 extends ArrayAdapter<Questions>{

    public QuestionsAdapter2(Activity context, ArrayList<Questions> ListAdapter) {
        super(context, 0, ListAdapter);
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View tempView = convertView;
        if(tempView == null) {
            tempView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        Questions temp = getItem(position);

        TextView noView = (TextView) tempView.findViewById(R.id.no);
        TextView nameView = (TextView) tempView.findViewById(R.id.name);
        RadioButton aButton = (RadioButton) tempView.findViewById(R.id.ansa);
        RadioButton bButton = (RadioButton) tempView.findViewById(R.id.ansb);
        RadioButton cButton = (RadioButton) tempView.findViewById(R.id.ansc);
        RadioButton dButton = (RadioButton) tempView.findViewById(R.id.ansd);
        TextView correctnessView = (TextView) tempView.findViewById(R.id.correctness);
        TextView answerView = (TextView) tempView.findViewById(R.id.answerview);
        nameView.setText(temp.getqName());
        noView.setText(String.valueOf(temp.getqNo()));
        aButton.setText(temp.getopA());
        bButton.setText(temp.getopB());
        cButton.setText(temp.getopC());
        dButton.setText(temp.getopD());
        if(Main2Activity.responses[position]==Main2Activity.answers[position]){
            correctnessView.setText("CORRECT");
            correctnessView.setTextColor(Color.GREEN);
        }else{
            correctnessView.setText("WRONG");
            correctnessView.setTextColor(Color.RED);
        }
        answerView.setText("ANSWER: "+Main2Activity.answers[position]);

        return tempView;
    }

}