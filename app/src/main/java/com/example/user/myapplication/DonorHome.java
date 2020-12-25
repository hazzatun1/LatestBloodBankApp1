package com.example.user.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DonorHome extends AppCompatActivity {

    private EditText amount;
    private DatabaseHelper db;
    private Button free, demand;
    private  ListView lv;
    private CAdapter data;
    private Contact dataModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_home);


        db=new DatabaseHelper(this);

        lv = (ListView) findViewById(R.id.list1);



       ShowRecords();
    }
    private void ShowRecords(){
        final ArrayList<Contact> contacts = new ArrayList<>(db.getAllContacts());
        data=new CAdapter(getApplicationContext(), contacts);

        lv.setAdapter(data);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)DonorHome.this);
                EditText editText = new EditText((Context)DonorHome.this);
                builder.setTitle("Donate free or enter amount");
                builder.setMessage("Enter demanded amount").setCancelable(false).setView((View)editText).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        DonorHome.this.updonate();
                        param2DialogInterface.cancel();
                    }
                }).setNegativeButton("Free Donate", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        DonorHome.this.updonate();
                        param2DialogInterface.cancel();
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        Toast.makeText((Context)DonorHome.this, "Cancel", 1).show();
                        param2DialogInterface.cancel();
                    }
                });
                builder.create().show();
            }
        });
    }

    public void updonate() {



    }
}
