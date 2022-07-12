package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ConditionDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition_details);

        Intent intent = getIntent();
        Measurement m = (Measurement) intent.getSerializableExtra("data");

        TextView date, time, sys_pr, dias_pr, hrt_rate, comment;

        date = findViewById(R.id.edit_date);
        time = findViewById(R.id.edit_time);
        sys_pr = findViewById(R.id.edit_sys_pr);
        dias_pr = findViewById(R.id.edit_dias_pr);
        hrt_rate = findViewById(R.id.edit_heat_rate);
        comment = findViewById(R.id.edit_comment);

        date.setText(m.getDate());
        time.setText(m.getTime());
        sys_pr.setText(Integer.toString(m.getSystolicPressure()));
        dias_pr.setText(Integer.toString(m.getDiastolicPressure()));
        hrt_rate.setText(Integer.toString(m.getHeartRate()));
        comment.setText(m.getComment());
    }
}