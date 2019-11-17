package com.example.attendenceadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
Button m,t,w,th,f,s;
public static String day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        m=findViewById(R.id.monday);
        t=findViewById(R.id.tuesday);
        w=findViewById(R.id.wed);
        th=findViewById(R.id.thursday);
        f=findViewById(R.id.friday);
        s=findViewById(R.id.sat);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day="Monday";
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day="Tuesday";
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day="Wednesday";
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
        th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day="Thursday";
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day="Friday";
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day="Saturday";
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
            }
}
