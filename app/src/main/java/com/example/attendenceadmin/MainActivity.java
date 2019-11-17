package com.example.attendenceadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText u,p,c;
Button l;
public static String cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u=findViewById(R.id.username);
        c=findViewById(R.id.classID);
        p=findViewById(R.id.pass);
        l=findViewById(R.id.login);
        cid="S5CSEBETA";
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(u.getText().toString().equals("admin")&& p.getText().toString().equals("admin") && c.getText().toString().equals("S5CSEBETA")){
                    startActivity(new Intent(MainActivity.this,Main2Activity.class));
                }
            }
        });

    }
}
