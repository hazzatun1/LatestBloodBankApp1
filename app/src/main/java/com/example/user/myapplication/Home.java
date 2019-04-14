package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private EditText fname,sname,phone,newv;
    private DatabaseHelper db;
    private String f_name,s_name,p_no;
    private ListView lv;
    private DCAdapter data;
    private DonorContact dataModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Instantiate database handler
        db=new DatabaseHelper(this);

        lv = (ListView) findViewById(R.id.list1);

       ShowRecords(); //etar jonno login page ei break hocche. how can i show the user list to this page???
    }


    private void ShowRecords(){
        final ArrayList<DonorContact> contacts = new ArrayList<>(db.getAllDonor());
        data=new DCAdapter(getApplicationContext(), contacts);

        lv.setAdapter(data);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dataModel = contacts.get(position);

                Toast.makeText(getApplicationContext(),String.valueOf(dataModel.getID()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
