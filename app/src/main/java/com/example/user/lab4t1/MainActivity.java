package com.example.user.lab4t1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    Button f;
    public static TextView show;
    public static String data="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=(TextView)findViewById(R.id.showdata);
        b=(Button)findViewById(R.id.button);

        f=(Button) findViewById(R.id.fetch);












    }

    public void fetching(View view) {
        fetchData process=new fetchData();
        process.execute();





    }

    public void changing(View view) {
        if (data.equals("")){
            Toast.makeText(getApplicationContext(),"Did not get data",Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("Json",show.getText().toString());
            intent.putExtra("Json",data.toString());
            startActivity(intent);

        }


    }
}
