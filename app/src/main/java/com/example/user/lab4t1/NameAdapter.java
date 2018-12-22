package com.example.user.lab4t1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 3/21/2018.
 */

public class NameAdapter extends BaseAdapter {

    ArrayList<Name> list;
    Context c;
    NameAdapter(Context context){
        c=context;
        list=new ArrayList<Name>();


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.row_layout,parent,false);
        TextView employee=(TextView)row.findViewById(R.id.tx_name);


        Name tmp=list.get(position);
        employee.setText(tmp.name);


        return row;
    }
}
class Name{
    String name;

    Name(String name){
        this.name=name;

    }
}
