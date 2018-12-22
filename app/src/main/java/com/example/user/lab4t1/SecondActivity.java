package com.example.user.lab4t1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    String Json_data;
    NameAdapter nameAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        Json_data=intent.getExtras().getString("Json");

        listView=(ListView) findViewById(R.id.l1);
        nameAdapter=new NameAdapter(this);
        listView.setAdapter(nameAdapter);




        try {

            JSONArray jsonArray=new JSONArray(Json_data);
            int count=0;
            String employee;
            while (count<jsonArray.length()){
                JSONObject jsonObject=jsonArray.getJSONObject(count);
                //JSONObject jo=jsonObject.getJSONObject("location");
                employee=jsonObject.getString("name");
                Name names=new Name(employee);
                nameAdapter.list.add(names);

                count++;
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
