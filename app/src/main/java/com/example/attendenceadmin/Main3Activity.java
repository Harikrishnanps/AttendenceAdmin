package com.example.attendenceadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {
EditText s1,s2,s3,s4,s5,s6,s7;
Button ok,up,d;
    public static String[] subjects= new String[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        s3=findViewById(R.id.s3);
        s4=findViewById(R.id.s4);
        s5=findViewById(R.id.s5);
        s6=findViewById(R.id.s6);
        ok=findViewById(R.id.ok);
        d=findViewById(R.id.day);
        up=findViewById(R.id.upd);
        d.setText(Main2Activity.day);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subjects[0]=s1.getText().toString();
                subjects[1]=s2.getText().toString();
                subjects[2]=s3.getText().toString();
                subjects[3]=s4.getText().toString();
                subjects[4]=s5.getText().toString();
                subjects[5]=s6.getText().toString();
                subjects[6]=s7.getText().toString();
                final ProgressDialog progressDialog=new ProgressDialog(Main3Activity.this);
                progressDialog.setMessage("UPDATING!!!");
                progressDialog.show();
                RequestQueue requestQueue = Volley.newRequestQueue(Main3Activity.this);
                StringRequest request = new StringRequest(Request.Method.POST, "https://herbiest-shelf.000webhostapp.com/att_update.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.hide();
                        toast("Updated");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        toast(error.getMessage());
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("classID", MainActivity.cid);
                        hashMap.put("day", Main2Activity.day);
                        hashMap.put("s1", subjects[0]);
                        hashMap.put("s2", subjects[1]);
                        hashMap.put("s3", subjects[2]);
                        hashMap.put("s4", subjects[3]);
                        hashMap.put("s5", subjects[4]);
                        hashMap.put("s6", subjects[5]);
                        hashMap.put("s7", subjects[6]);
                        return hashMap;
                    }
                };
                requestQueue.add(request);
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                subjects[0]=s1.getText().toString();
                subjects[1]=s2.getText().toString();
                subjects[2]=s3.getText().toString();
                subjects[3]=s4.getText().toString();
                subjects[4]=s5.getText().toString();
                subjects[5]=s6.getText().toString();
                subjects[6]=s7.getText().toString();

                for(int i=0;i<7;i++){
                    Update(subjects[i]);

                }

            }
        });
        s7=findViewById(R.id.s7);
        loadFromServer();
    }

    private void Update(final String subject) {
        final ProgressDialog progressDialog=new ProgressDialog(Main3Activity.this);
        progressDialog.setMessage("UPDATING!!!");
        progressDialog.show();
        RequestQueue requestQueue = Volley.newRequestQueue(Main3Activity.this);
        StringRequest request = new StringRequest(Request.Method.POST, "https://herbiest-shelf.000webhostapp.com/tot_update.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.hide();
                toast("Updated");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                toast(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("CID", MainActivity.cid);
                hashMap.put("SubID", subject);
                return hashMap;
            }
        };
        requestQueue.add(request);
    }

    public void toast(String Message) {
        Toast.makeText(Main3Activity.this,Message,Toast.LENGTH_SHORT).show();
    }
    private void loadFromServer() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Getting Details!!!");
        progressDialog.show();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, "https://herbiest-shelf.000webhostapp.com/subjects.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray jsonArray = obj.getJSONArray("details");
                    for(int i=0;i<=jsonArray.length();i++){
                        JSONObject o=jsonArray.getJSONObject(i);
                        s1.setText(o.getString("SUB1"));
                        s2.setText(o.getString("SUB2"));
                        s3.setText(o.getString("SUB3"));
                        s4.setText(o.getString("SUB4"));
                        s5.setText(o.getString("SUB5"));
                        s6.setText(o.getString("SUB6"));
                        s7.setText(o.getString("SUB7"));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main3Activity.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();


            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("day", Main2Activity.day);
                hashMap.put("classID",MainActivity.cid);
                return hashMap;
            }
        };
        requestQueue.add(request);
    }
}
