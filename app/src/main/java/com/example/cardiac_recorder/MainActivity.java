package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView measurementlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        measurementlist=findViewById(R.id.measurement);
        ArrayList<Measurement> MeasurementList=new ArrayList<>();
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        MeasurementList.add(new Measurement("20.06.22","1.00 pm",140,80,60,"Normal"));
        showList adapter=new showList(this);
        adapter.setMeasurementList(MeasurementList);
        measurementlist.setAdapter(adapter);
        measurementlist.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

}