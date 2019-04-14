package com.example.user.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

    public class CAdapter extends ArrayAdapter<Contact> {

        Context context;
        ArrayList<Contact> mcontact;


        public CAdapter(Context context, ArrayList<Contact> contact){
            super(context, R.layout.userlist, contact);
            this.context=context;
            this.mcontact=contact;
        }

        public  class  Holder{
            TextView nameFV;
            TextView nameSV;
            TextView phoneV;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position

            Contact data = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view

            Holder viewHolder; // view lookup cache stored in tag

            if (convertView == null) {


                viewHolder = new Holder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.userlist, parent, false);

                viewHolder.nameFV = (TextView) convertView.findViewById(R.id.txtView1);
                viewHolder.nameSV = (TextView) convertView.findViewById(R.id.txtView2);
                viewHolder.phoneV = (TextView) convertView.findViewById(R.id.txtView3);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (Holder) convertView.getTag();
            }


            viewHolder.nameFV.setText("Contact no: "+data.getAddress());
            viewHolder.nameSV.setText("Address: "+data.getUserName());
            viewHolder.phoneV.setText("Blood Group: "+data.getBloodGroup());


            // Return the completed view to render on screen
            return convertView;
        }

    }



