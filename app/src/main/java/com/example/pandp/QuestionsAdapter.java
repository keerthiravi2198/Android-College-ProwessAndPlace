package com.example.pandp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionsAdapter extends ArrayAdapter<Questions>{

    public QuestionsAdapter(Activity context, ArrayList<Questions> ListAdapter) {
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
        nameView.setText(temp.getqName());
        noView.setText(String.valueOf(temp.getqNo()));
        aButton.setText(temp.getopA());
        bButton.setText(temp.getopB());
        cButton.setText(temp.getopC());
        dButton.setText(temp.getopD());
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.responses[position] = 1;
            }
        });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.responses[position] = 2;
            }
        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.responses[position] = 3;
            }
        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.responses[position] = 4;
            }
        });

        return tempView;
    }

}
