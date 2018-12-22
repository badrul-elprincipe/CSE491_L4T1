package com.example.user.lab4t1;

/**
 * Created by user on 3/20/2018.
 */
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class fetchData extends AsyncTask<Void,Void,Void>{

    String data="";
    //String dataParsed="";
    //String singleParsed="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL("http://anontech.info/courses/cse491/employees.json");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            String br="";
            while (br!=null){
                br=bufferedReader.readLine();
                data=data+br;

            }
            JSONArray JA=new JSONArray(data);
            //for (int i=0;i<JA.length();i++){
                //JSONObject JO= (JSONObject) JA.get(i);
                //singleParsed=JO.get("name").toString()+"\n"+
                       // JO.get("location").toString()+"\n";//+
                        //JO.get("latitude").toString()+"\n"+
                        //JO.get("longitude").toString()+"\n";
                //dataParsed=dataParsed+singleParsed;

            //}



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //MainActivity.show.setText(this.data);
        MainActivity.data=this.data;

    }
}
