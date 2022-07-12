package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView measurementlist;
    private Button add_measurement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        measurementlist=findViewById(R.id.measurement);
        add_measurement = (Button) findViewById(R.id.add_msr);

        ArrayList<Measurement> MeasurementList=new ArrayList<>();
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));

        showList adapter=new showList(this);
        adapter.setMeasurementList(MeasurementList);
        measurementlist.setAdapter(adapter);
        measurementlist.setLayoutManager(new LinearLayoutManager(this));

        add_measurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddMeasurement.class);
                startActivity(intent);
            }
        });

    }

}